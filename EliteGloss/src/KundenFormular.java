import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.regex.Pattern;

public class KundenFormular {

    public static void zeige() {
        while (true) {
            JTextField vorname = new JTextField();
            JTextField nachname = new JTextField();
            JTextField telefon = new JTextField();
            JTextField email = new JTextField();

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(0, 1, 5, 5));
            panel.setPreferredSize(new Dimension(300, 200));

            panel.add(new JLabel("Vorname:"));
            panel.add(vorname);
            panel.add(new JLabel("Nachname:"));
            panel.add(nachname);
            panel.add(new JLabel("Telefonnummer:"));
            panel.add(telefon);
            panel.add(new JLabel("E-Mail-Adresse:"));
            panel.add(email);

            vorname.requestFocus();

            int auswahl = JOptionPane.showConfirmDialog(null, panel, "🆕 Neukunde registrieren",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (auswahl != JOptionPane.OK_OPTION) break;

            // Eingaben einlesen & trimmen
            String v = vorname.getText().trim();
            String n = nachname.getText().trim();
            String t = telefon.getText().trim();
            String e = email.getText().trim();

            // Validierung
            if (v.isEmpty() || n.isEmpty() || t.isEmpty() || e.isEmpty()) {
                JOptionPane.showMessageDialog(null, "⚠️ Bitte alle Felder ausfüllen.");
                continue;
            }

            if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$", e)) {
                JOptionPane.showMessageDialog(null, "📧 Ungültige E-Mail-Adresse.");
                continue;
            }

            if (!Pattern.matches("^[+\\d][\\d\\s/-]{5,}$", t)) {
                JOptionPane.showMessageDialog(null, "📱 Ungültige Telefonnummer.");
                continue;
            }

            // Daten speichern
            try (Connection conn = DBVerbindung.verbinde();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO kunden (vorname, nachname, telefonnummer, email) VALUES (?, ?, ?, ?)")) {

                stmt.setString(1, v);
                stmt.setString(2, n);
                stmt.setString(3, t);
                stmt.setString(4, e);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "✅ Kunde \"" + v + " " + n + "\" erfolgreich registriert.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "❌ Fehler beim Speichern:\n" + ex.getMessage());
            }

            break;
        }
    }
}
