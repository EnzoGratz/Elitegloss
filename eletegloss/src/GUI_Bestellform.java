package eletegloss.src;


//Bestellformular


import javax.swing.*;
import java.awt.*;

public class GUI_Bestellform extends JFrame{

    private static final String PAKET_BASIC   = "Basic‑Clean";
    private static final String PAKET_PREMIUM = "Premium‑Gloss";
    private static final String PAKET_DELUXE  = "Deluxe‑Shine";

    private JLabel lblUeberschrift, lblName, lblPaket, lblExtras, lblAnzahl, lblTel, lblZahlung;
    private JTextField txtName, txtTel;
    private JComboBox<String> cboPaket;
    private JComboBox<Integer> cboAnzahl;
    private JCheckBox chkVersiegelung, chkFelgen, chkInnenreinigung, chkAbholer;
    private JRadioButton optPaypal, optBar;
    private JButton btnReset, btnDatei, btnDb, btnBeenden;

    public GUI_Bestellform() {
        this.setTitle("Elitegloss – Paket-Bestellung");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        initComponents();

        pack();
        this.setVisible(true);
    }
    

    private void initComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        Font fontLabel  = new Font("Segoe UI", Font.PLAIN, 13);
        Font fontTitel  = new Font("Segoe UI", Font.BOLD, 24);
        Font fontButton = new Font("Segoe UI", Font.BOLD, 15);

        // Überschrift
        lblUeberschrift = new JLabel("Elitegloss – Dein Fahrzeug, dein Glanz");
        lblUeberschrift.setFont(fontLabel);
        lblUeberschrift.setForeground(new Color(0x003366));
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(20, 10, 15, 10);

        this.add(lblUeberschrift,c);

        lblName = new JLabel("Kundenname:");
        lblName.setFont(fontLabel);
        c.gridx = 0; c.gridy = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblName, c);

        txtName = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 0, 10);
        add(txtName, c);


        lblPaket = new JLabel("Paket:");
        lblPaket.setFont(fontLabel);
        c.gridx = 0; c.gridy = 2;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblPaket, c);

        String[] pakete = { PAKET_BASIC, PAKET_PREMIUM, PAKET_DELUXE};
        cboPaket = new JComboBox<>(pakete);
        cboPaket.setFont(fontLabel);
        c.gridx = 1; c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        add(cboPaket, c);

        lblExtras = new JLabel("Zusatzleistungen:");
        lblExtras.setFont(fontLabel);
        c.gridx = 0; c.gridy = 3;
        c.insets = new Insets(5, 10, 0, 10);
        add(lblExtras, c);

            chkVersiegelung = new JCheckBox("Lack­versiegelung");
    chkVersiegelung.setFont(fontLabel);
    c.gridx = 0; c.gridy = 4;
    c.insets = new Insets(3, 10, 0, 10);
    add(chkVersiegelung, c);

    chkFelgen = new JCheckBox("Felgenreinigung");
    chkFelgen.setFont(fontLabel);
    c.gridx = 1; c.gridy = 4;
    c.insets = new Insets(3, 0, 0, 10);
    add(chkFelgen, c);

    chkInnenreinigung = new JCheckBox("Innenraum-Detailing");
    chkInnenreinigung.setFont(fontLabel);
    c.gridx = 0; c.gridy = 5;
    c.insets = new Insets(3, 10, 0, 10);
    add(chkInnenreinigung, c);

    lblAnzahl = new JLabel("Anzahl Fahrzeuge:");
    lblAnzahl.setFont(fontLabel);
    c.gridx = 0; c.gridy = 6;
    c.insets = new Insets(7, 10, 0, 10);
    add(lblAnzahl, c);

    Integer[] anzahlfahrz = {1,2,3,4,5};
    cboAnzahl = new JComboBox<>(anzahlfahrz);
    cboAnzahl.setFont(fontLabel);
    c.gridx = 1; c.gridy = 6;
    c.insets = new Insets(7, 0, 0, 10);
    add(cboAnzahl, c);

        lblTel = new JLabel("Tel.-Nr.:");
    lblTel.setFont(fontLabel);
    c.gridx = 0; c.gridy = 7;
    c.insets = new Insets(5, 10, 0, 10);
    add(lblTel, c);

    txtTel = new JTextField(15);
    txtTel.setFont(fontLabel);
    c.gridx = 1; c.gridy = 7;
    c.insets = new Insets(5, 0, 0, 10);
    add(txtTel, c);

        // ─ Telefon ─
    lblTel = new JLabel("Tel.-Nr.:");
    lblTel.setFont(fontLabel);
    c.gridx = 0; c.gridy = 7;
    c.insets = new Insets(5, 10, 0, 10);
    add(lblTel, c);

    txtTel = new JTextField(15);
    txtTel.setFont(fontLabel);
    c.gridx = 1; c.gridy = 7;
    c.insets = new Insets(5, 0, 0, 10);
    add(txtTel, c);

    lblZahlung = new JLabel("Zahlung:");
    lblZahlung.setFont(fontLabel);
    c.gridx = 0; c.gridy = 9;
    c.insets = new Insets(5, 10, 0, 10);
    add(lblZahlung, c);

    ButtonGroup zahlungsart = new ButtonGroup();

    optPaypal = new JRadioButton("PayPal");
    optPaypal.setFont(fontLabel);
    c.gridx = 0; c.gridy = 10;
    c.insets = new Insets(3, 10, 0, 10);
    add(optPaypal, c);

    optBar = new JRadioButton("Bar");
    optBar.setFont(fontLabel);
    optBar.setSelected(true);
    c.gridx = 1; c.gridy = 10;
    c.insets = new Insets(3, 0, 0, 10);
    add(optBar, c);

    zahlungsart.add(optPaypal);
    zahlungsart.add(optBar);

    //Buttons
    btnReset = new JButton("Zurücksetzen");
    btnReset.setFont(fontButton);
    c.gridx = 0; c.gridy = 11;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 5, 10);
    add(btnReset, c);

    btnDatei = new JButton("Speichern in Datei");
    btnDatei.setFont(fontButton);
    c.gridx = 1; c.gridy = 11;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 0, 5, 10);
    add(btnDatei, c);

        btnDb = new JButton("Speichern in DB");
    btnDb.setFont(fontButton);
    c.gridx = 0; c.gridy = 12;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 10, 15, 10);
    add(btnDb, c);

    btnBeenden = new JButton("Beenden");
    btnBeenden.setFont(fontButton);
    c.gridx = 1; c.gridy = 12;
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10, 0, 15, 10);
    add(btnBeenden, c);

    }
}