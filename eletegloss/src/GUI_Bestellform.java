package eletegloss.src;


//Bestellformular


import javax.swing.*;
import java.awt.*;

public class GUI_Bestellform extends JFrame{

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


    }
}