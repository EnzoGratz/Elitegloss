package eletegloss.src;

// Bestellformular

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class GUI_Bestellform extends JFrame {

    private static final String PAKET_BASIC = "Basic‑Clean";
    private static final String PAKET_PREMIUM = "Premium‑Gloss";
    private static final String PAKET_DELUXE = "Deluxe‑Shine";

    private JLabel lblUeberschrift, lblvName, lblName, lblPaket, lblExtras, lblAnzahl, lblTel, lblZahlung;
    private JTextField txtvName, txtName, txtTel;
    private JComboBox<String> cboPaket;
    private JComboBox<Integer> cboAnzahl;
    private JCheckBox chkVersiegelung, chkFelgen, chkInnenreinigung;
    private JRadioButton optPaypal, optBar;
    private JButton btnReset, btnDatei, btnBeenden;

    public GUI_Bestellform() {
        this.setTitle("Elitegloss – Paket-Bestellung");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        initComponents();
        pack();
        this.setVisible(true);
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Font fontLabel = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontTitel = new Font("Segoe UI", Font.BOLD, 24);
        Font fontButton = new Font("Segoe UI", Font.BOLD, 15);

        int zeile = 0; //Einfacher

        // Überschrift
        lblUeberschrift = new JLabel("Elitegloss – Dein Fahrzeug, dein Glanz");
        lblUeberschrift.setFont(fontTitel);
        lblUeberschrift.setForeground(new Color(0x003366));
        c.gridx = 0; c.gridy = zeile++;
        c.gridwidth = 2;
        c.insets = new Insets(20, 10, 15, 10);
        add(lblUeberschrift, c);

        c.gridwidth = 1;

        // Vorname
        lblvName = new JLabel("Vorname:");
        lblvName.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblvName, c);

        txtvName = new JTextField(15);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(5, 0, 0, 10);
        add(txtvName, c);

        // Nachname
        lblName = new JLabel("Nachname:");
        lblName.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblName, c);

        txtName = new JTextField(15);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(5, 0, 0, 10);
        add(txtName, c);

        // Paket
        lblPaket = new JLabel("Paket:");
        lblPaket.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblPaket, c);

        String[] pakete = { PAKET_BASIC, PAKET_PREMIUM, PAKET_DELUXE };
        cboPaket = new JComboBox<>(pakete);
        cboPaket.setFont(fontLabel);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(5, 0, 0, 10);
        add(cboPaket, c);

        // Zusatzleistungen
        lblExtras = new JLabel("Zusatzleistungen:");
        lblExtras.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile++;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblExtras, c);

        chkVersiegelung = new JCheckBox("Lack­versiegelung");
        chkVersiegelung.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(3, 10, 0, 10);
        add(chkVersiegelung, c);

        chkFelgen = new JCheckBox("Felgenreinigung");
        chkFelgen.setFont(fontLabel);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(3, 0, 0, 10);
        add(chkFelgen, c);

        chkInnenreinigung = new JCheckBox("Innenraum-Detailing");
        chkInnenreinigung.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile++;
        c.insets = new Insets(3, 10, 0, 10);
        add(chkInnenreinigung, c);

        // Anzahl
        lblAnzahl = new JLabel("Anzahl Fahrzeuge:");
        lblAnzahl.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(7, 10, 0, 10);
        add(lblAnzahl, c);

        Integer[] anzahlfahrz = { 1, 2, 3, 4, 5 };
        cboAnzahl = new JComboBox<>(anzahlfahrz);
        cboAnzahl.setFont(fontLabel);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(7, 0, 0, 10);
        add(cboAnzahl, c);

        // Telefon
        lblTel = new JLabel("Tel.-Nr.:");
        lblTel.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblTel, c);

        txtTel = new JTextField(15);
        txtTel.setFont(fontLabel);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(5, 0, 0, 10);
        add(txtTel, c);

        // Zahlung
        lblZahlung = new JLabel("Zahlung:");
        lblZahlung.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile++;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblZahlung, c);

        ButtonGroup zahlungsart = new ButtonGroup();

        optPaypal = new JRadioButton("PayPal");
        optPaypal.setFont(fontLabel);
        c.gridx = 0; c.gridy = zeile;
        c.insets = new Insets(3, 10, 0, 10);
        add(optPaypal, c);

        optBar = new JRadioButton("Bar");
        optBar.setFont(fontLabel);
        optBar.setSelected(true);
        c.gridx = 1; c.gridy = zeile++;
        c.insets = new Insets(3, 0, 0, 10);
        add(optBar, c);

        zahlungsart.add(optPaypal);
        zahlungsart.add(optBar);

        // Buttons
        MyActionListener actionlistner = new MyActionListener();

        btnReset = new JButton("Zurücksetzen");
        btnReset.setFont(fontButton);
        c.gridx = 0; c.gridy = zeile;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 5, 10);
        add(btnReset, c);
        btnReset.addActionListener(actionlistner);

        btnDatei = new JButton("Speichern");
        btnDatei.setFont(fontButton);
        c.gridx = 1; c.gridy = zeile++;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 5, 10);
        add(btnDatei, c);
        btnDatei.addActionListener(actionlistner);

        btnBeenden = new JButton("Beenden");
        btnBeenden.setFont(fontButton);
        c.gridx = 1; c.gridy = zeile++;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 0, 15, 10);
        add(btnBeenden, c);
        btnBeenden.addActionListener(actionlistner);
    }

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnReset) {
                resetForm();
            } else if (e.getSource() == btnBeenden) {
                dispose();
            } else if (e.getSource() == btnDatei) {
                if (checkFormular()) {
                    String vName = txtvName.getText();
                    String nname = txtName.getText();
                    String paket = (String) cboPaket.getSelectedItem();
                    int anzahl = (Integer) cboAnzahl.getSelectedItem();
                    String tel = txtTel.getText();
                    String zahlung = optPaypal.isSelected() ? "PayPal" : "Bar";
                    BigDecimal preis = berechnePreis(paket, chkVersiegelung.isSelected(), chkFelgen.isSelected(),
                    chkInnenreinigung.isSelected(), anzahl);

                    String extras = "";
                    if (chkVersiegelung.isSelected()) extras += "Lackversiegelung, ";
                    if (chkFelgen.isSelected()) extras += "Felgenreinigung, ";
                    if (chkInnenreinigung.isSelected()) extras += "Innenraum-Detailing, ";
                    if (extras.endsWith(", ")) extras = extras.substring(0, extras.length() - 2);
                    if (extras.isEmpty()) extras = "Keine";

                    String bestellung = "Elitegloss-Bestellung\n\n";
                    bestellung += "Vorname: " + vName + "\n";
                    bestellung += "Name: " + nname + "\n";
                    bestellung += "Telefon: " + tel + "\n";
                    bestellung += "Preis: " + preis + "\n";
                    bestellung += "Paket: " + paket + "\n";
                    bestellung += "Extras: " + extras + "\n";
                    bestellung += "Anzahl Fahrzeuge: " + anzahl + "\n";
                    bestellung += "Zahlung: " + zahlung + "\n";
                    JOptionPane.showMessageDialog(null, bestellung);

                    Paket neueBestellung = new Paket(vName, nname, tel, paket, preis, extras, zahlung);
                    System.out.println(neueBestellung);
                }
            }
        }
    }

    private boolean checkFormular() {
        String vname = txtvName.getText().trim();
        String nname = txtName.getText().trim();
        String tel = txtTel.getText().trim();

        if (vname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte gib deinen Vornamen ein.");
            txtName.requestFocus();
            return false;
        }

        if (nname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte gib deinen Namen ein.");
            txtName.requestFocus();
            return false;
        }

        if (tel.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bitte gib deine Telefonnummer ein.");
            txtTel.requestFocus();
            return false;
        }

        return true;
    }

    private void resetForm() {
        txtvName.setText("");
        txtName.setText("");
        txtTel.setText("");
        cboPaket.setSelectedIndex(0);
        cboAnzahl.setSelectedIndex(0);
        optBar.setSelected(true);
        optPaypal.setSelected(false);
        chkFelgen.setSelected(false);
        chkInnenreinigung.setSelected(false);
        chkVersiegelung.setSelected(false);
    }

    private BigDecimal berechnePreis(String paketName,
                                    boolean versiegelung,
                                    boolean felgen,
                                    boolean innen,
                                    int anzahl) {

        BigDecimal basis = BigDecimal.ZERO;
        BigDecimal aufpreis = BigDecimal.ZERO;

        if (paketName.equals(PAKET_BASIC)) {
            basis = new BigDecimal("49.90");
        } else if (paketName.equals(PAKET_PREMIUM)) {
            basis = new BigDecimal("79.90");
        } else if (paketName.equals(PAKET_DELUXE)) {
            basis = new BigDecimal("119.90");
        } else {
            basis = BigDecimal.ZERO;//Zur sicherheit (für mein Gewissen)
        }

        if (versiegelung) {
            aufpreis = aufpreis.add(new BigDecimal("19.90"));
        }
        if (felgen) {
            aufpreis = aufpreis.add(new BigDecimal("14.90"));
        }
        if (innen) {
            aufpreis = aufpreis.add(new BigDecimal("24.90"));
        }

        BigDecimal einzelpreis = basis.add(aufpreis);
        return einzelpreis.multiply(BigDecimal.valueOf(anzahl));
    }

}
