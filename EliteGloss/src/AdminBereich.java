import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.nio.file.*;

public class AdminBereich {

    private static DefaultTableModel kundenModel;
    private static DefaultTableModel auftragModel;

    public static void zeige() {
        JFrame frame = new JFrame("EliteGloss – Ultimativer Adminbereich");
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();

        // 👥 Kunden-Tabelle
        kundenModel = new DefaultTableModel(new String[]{"ID", "Vorname", "Nachname", "Telefon", "E-Mail"}, 0);
        JTable kundenTabelle = new JTable(kundenModel);
        JScrollPane kundenScroll = new JScrollPane(kundenTabelle);
        JPanel kundenPanel = new JPanel(new BorderLayout());
        JButton speichernBtn = new JButton("💾 Änderungen speichern");
        kundenPanel.add(kundenScroll, BorderLayout.CENTER);
        kundenPanel.add(speichernBtn, BorderLayout.SOUTH);
        tabs.add("👥 Kunden", kundenPanel);

        // 📦 Aufträge-Tabelle
        auftragModel = new DefaultTableModel(new String[]{"Auftrag-ID", "Kunde-ID", "Paket", "Zusatz", "Datum", "Preis"}, 0);
        JTable auftragTabelle = new JTable(auftragModel);
        JScrollPane auftragScroll = new JScrollPane(auftragTabelle);
        tabs.add("📦 Aufträge", auftragScroll);

        // 🧾 PDF-Bereich
        DefaultListModel<File> pdfListModel = new DefaultListModel<>();
        JList<File> pdfList = new JList<>(pdfListModel);
        JScrollPane pdfScroll = new JScrollPane(pdfList);
        JButton pdfOpen = new JButton("📂 Öffnen");
        JButton pdfSave = new JButton("⬇ Speichern");

        JPanel pdfBtnPanel = new JPanel();
        pdfBtnPanel.add(pdfOpen);
        pdfBtnPanel.add(pdfSave);
        JPanel pdfPanel = new JPanel(new BorderLayout());
        pdfPanel.add(pdfScroll, BorderLayout.CENTER);
        pdfPanel.add(pdfBtnPanel, BorderLayout.SOUTH);
        tabs.add("🧾 Rechnungen", pdfPanel);

        // 🔄 Aktualisieren
        JButton refreshBtn = new JButton("🔄 Aktualisieren");
        mainPanel.add(refreshBtn, BorderLayout.SOUTH);
        mainPanel.add(tabs, BorderLayout.CENTER);
        frame.setContentPane(mainPanel);

        // 🔧 Logik

        refreshBtn.addActionListener(e -> ladeDaten());
        pdfOpen.addActionListener(e -> {
            File f = pdfList.getSelectedValue();
            if (f != null) {
                try { Desktop.getDesktop().open(f); }
                catch (Exception ex) { JOptionPane.showMessageDialog(frame, "Fehler beim Öffnen."); }
            }
        });

        pdfSave.addActionListener(e -> {
            File f = pdfList.getSelectedValue();
            if (f != null) {
                JFileChooser chooser = new JFileChooser();
                chooser.setSelectedFile(f);
                if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
                    try {
                        Files.copy(f.toPath(), chooser.getSelectedFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(frame, "✅ PDF gespeichert.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Fehler beim Speichern.");
                    }
                }
            }
        });

        speichernBtn.addActionListener(e -> {
            try (Connection conn = DBVerbindung.verbinde()) {
                for (int i = 0; i < kundenModel.getRowCount(); i++) {
                    PreparedStatement stmt = conn.prepareStatement(
                            "UPDATE kunden SET vorname=?, nachname=?, telefonnummer=?, email=? WHERE id=?");
                    stmt.setString(1, kundenModel.getValueAt(i, 1).toString());
                    stmt.setString(2, kundenModel.getValueAt(i, 2).toString());
                    stmt.setString(3, kundenModel.getValueAt(i, 3).toString());
                    stmt.setString(4, kundenModel.getValueAt(i, 4).toString());
                    stmt.setInt(5, Integer.parseInt(kundenModel.getValueAt(i, 0).toString()));
                    stmt.executeUpdate();
                }
                JOptionPane.showMessageDialog(frame, "✅ Änderungen gespeichert.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "❌ Fehler: " + ex.getMessage());
            }
        });

        ladeDaten();
        ladePDFs(pdfListModel);
        frame.setVisible(true);
    }

    private static void ladeDaten() {
        kundenModel.setRowCount(0);
        auftragModel.setRowCount(0);
        try (Connection conn = DBVerbindung.verbinde()) {
            Statement stmt = conn.createStatement();

            ResultSet kunden = stmt.executeQuery("SELECT * FROM kunden");
            while (kunden.next()) {
                kundenModel.addRow(new Object[]{
                        kunden.getInt("id"),
                        kunden.getString("vorname"),
                        kunden.getString("nachname"),
                        kunden.getString("telefonnummer"),
                        kunden.getString("email")
                });
            }

            ResultSet auftraege = stmt.executeQuery("SELECT * FROM auftraege");
            while (auftraege.next()) {
                auftragModel.addRow(new Object[]{
                        auftraege.getInt("id"),
                        auftraege.getInt("kunde_id"),
                        auftraege.getString("paket"),
                        auftraege.getString("zusatzleistungen"),
                        auftraege.getDate("datum"),
                        auftraege.getDouble("preis")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Fehler beim Laden der Daten:\n" + e.getMessage());
        }
    }

    private static void ladePDFs(DefaultListModel<File> model) {
        model.clear();
        File dir = new File(".");
        File[] pdfs = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".pdf"));
        if (pdfs != null) {
            for (File f : pdfs) {
                model.addElement(f);
            }
        }
    }
}
// End of file