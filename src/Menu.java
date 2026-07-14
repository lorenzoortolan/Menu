import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    private ButtonGroup gruppoCibo;
    private ButtonGroup gruppoBevande;
    private ButtonGroup gruppoOrario;
    
    private JPanel panelPrincipale;
    
    private JLabel lblTitolo;
    private JLabel lblCibo;
    private JLabel lblBevanda;
    private JLabel lblOrario;
    
    private JRadioButton radPasta;
    private JRadioButton radCarne;
    private JRadioButton radSushi;
    
    private JRadioButton radAcquaNat;
    private JRadioButton radAcquaFriz;
    private JRadioButton radVino;
    
    private JRadioButton radOrario1;
    private JRadioButton radOrario2;
    private JRadioButton radOrario3;
    
    private JLabel imgMostrata;
    private JLabel imgSfondo;
    
    private JButton btnConferma;

    public Menu() {
        impostaFinestra();
        inizializzaComponenti();
        aggiungiComponenti();
    }

    private void impostaFinestra() {
        setTitle("Ordinazione Menù");
        setSize(500, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inizializzaComponenti() {
        panelPrincipale = new JPanel();
        panelPrincipale.setLayout(null);
        panelPrincipale.setBackground(Color.WHITE);

        Font fontTitolo = new Font("Segoe UI", Font.BOLD, 18);
        Font fontSezione = new Font("Segoe UI", Font.BOLD, 14);
        Font fontOpzioni = new Font("Segoe UI", Font.PLAIN, 13);

        lblTitolo = new JLabel("Crea la tua ordinazione");
        lblTitolo.setFont(fontTitolo);
        lblTitolo.setForeground(new Color(50, 50, 50));
        lblTitolo.setBounds(30, 20, 300, 30);

        lblCibo = new JLabel("Cibo:");
        lblCibo.setFont(fontSezione);
        lblCibo.setBounds(30, 70, 100, 25);

        radPasta = new JRadioButton("Pasta");
        radPasta.setFont(fontOpzioni);
        radPasta.setBackground(Color.WHITE);
        radPasta.setBounds(30, 100, 150, 25);
        radPasta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiornaImmagineCibo("/pasta.png");
            }
        });

        radCarne = new JRadioButton("Carne");
        radCarne.setFont(fontOpzioni);
        radCarne.setBackground(Color.WHITE);
        radCarne.setBounds(30, 130, 150, 25);
        radCarne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiornaImmagineCibo("/carne.jpg");
            }
        });

        radSushi = new JRadioButton("Sushi");
        radSushi.setFont(fontOpzioni);
        radSushi.setBackground(Color.WHITE);
        radSushi.setBounds(30, 160, 150, 25);
        radSushi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aggiornaImmagineCibo("/sushi.png");
            }
        });

        imgMostrata = new JLabel();
        imgMostrata.setBounds(250, 80, 150, 150);
        imgMostrata.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));

        gruppoCibo = new ButtonGroup();
        gruppoCibo.add(radPasta);
        gruppoCibo.add(radCarne);
        gruppoCibo.add(radSushi);

        lblBevanda = new JLabel("Bevanda:");
        lblBevanda.setFont(fontSezione);
        lblBevanda.setBounds(30, 210, 100, 25);

        radAcquaNat = new JRadioButton("Acqua Naturale");
        radAcquaNat.setFont(fontOpzioni);
        radAcquaNat.setBackground(Color.WHITE);
        radAcquaNat.setBounds(30, 240, 200, 25);

        radAcquaFriz = new JRadioButton("Acqua Frizzante");
        radAcquaFriz.setFont(fontOpzioni);
        radAcquaFriz.setBackground(Color.WHITE);
        radAcquaFriz.setBounds(30, 270, 200, 25);

        radVino = new JRadioButton("Vino Rosso");
        radVino.setFont(fontOpzioni);
        radVino.setBackground(Color.WHITE);
        radVino.setBounds(30, 300, 200, 25);

        gruppoBevande = new ButtonGroup();
        gruppoBevande.add(radAcquaNat);
        gruppoBevande.add(radAcquaFriz);
        gruppoBevande.add(radVino);

        lblOrario = new JLabel("Orario:");
        lblOrario.setFont(fontSezione);
        lblOrario.setBounds(30, 350, 100, 25);

        radOrario1 = new JRadioButton("19.00 - 20.00");
        radOrario1.setFont(fontOpzioni);
        radOrario1.setBackground(Color.WHITE);
        radOrario1.setBounds(30, 380, 150, 25);

        radOrario2 = new JRadioButton("20.00 - 21.00");
        radOrario2.setFont(fontOpzioni);
        radOrario2.setBackground(Color.WHITE);
        radOrario2.setBounds(30, 410, 150, 25);

        radOrario3 = new JRadioButton("21.00 - 22.00");
        radOrario3.setFont(fontOpzioni);
        radOrario3.setBackground(Color.WHITE);
        radOrario3.setBounds(30, 440, 150, 25);

        gruppoOrario = new ButtonGroup();
        gruppoOrario.add(radOrario1);
        gruppoOrario.add(radOrario2);
        gruppoOrario.add(radOrario3);

        btnConferma = new JButton("Conferma Ordine");
        btnConferma.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConferma.setBackground(new Color(70, 130, 180));
        btnConferma.setForeground(Color.WHITE);
        btnConferma.setFocusPainted(false);
        btnConferma.setBounds(150, 500, 200, 40);
        
        btnConferma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                gestisciConferma();
            }
        });

        imgSfondo = new JLabel();
        try { imgSfondo.setIcon(new ImageIcon(getClass().getResource("/download.jpeg"))); } catch (Exception e) {}
        imgSfondo.setBounds(350, 20, 100, 100);
    }

    private void aggiornaImmagineCibo(String percorso) {
        try {
            ImageIcon iconaOriginale = new ImageIcon(getClass().getResource(percorso));
            Image immagineScalata = iconaOriginale.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            imgMostrata.setIcon(new ImageIcon(immagineScalata));
        } catch (Exception e) {
            imgMostrata.setIcon(null);
        }
    }

    private void aggiungiComponenti() {
        panelPrincipale.add(lblTitolo);
        panelPrincipale.add(lblCibo);
        panelPrincipale.add(radPasta);
        panelPrincipale.add(radCarne);
        panelPrincipale.add(radSushi);
        panelPrincipale.add(imgMostrata);
        
        panelPrincipale.add(lblBevanda);
        panelPrincipale.add(radAcquaNat);
        panelPrincipale.add(radAcquaFriz);
        panelPrincipale.add(radVino);
        
        panelPrincipale.add(lblOrario);
        panelPrincipale.add(radOrario1);
        panelPrincipale.add(radOrario2);
        panelPrincipale.add(radOrario3);
        
        panelPrincipale.add(btnConferma);
        panelPrincipale.add(imgSfondo);
        
        setContentPane(panelPrincipale);
    }

    private void gestisciConferma() {
        String riepilogo = "Hai scelto:\n";
        String cibo = "\nCibo: Nessuna selezione";
        String bevanda = "\nBevanda: Nessuna selezione";
        String orario = "\nOrario: Nessuna selezione";

        if (radPasta.isSelected()) cibo = "\nCibo: " + radPasta.getText();
        else if (radCarne.isSelected()) cibo = "\nCibo: " + radCarne.getText();
        else if (radSushi.isSelected()) cibo = "\nCibo: " + radSushi.getText();

        if (radAcquaNat.isSelected()) bevanda = "\nBevanda: " + radAcquaNat.getText();
        else if (radAcquaFriz.isSelected()) bevanda = "\nBevanda: " + radAcquaFriz.getText();
        else if (radVino.isSelected()) bevanda = "\nBevanda: " + radVino.getText();

        if (radOrario1.isSelected()) orario = "\nOrario: " + radOrario1.getText();
        else if (radOrario2.isSelected()) orario = "\nOrario: " + radOrario2.getText();
        else if (radOrario3.isSelected()) orario = "\nOrario: " + radOrario3.getText();

        JOptionPane.showMessageDialog(this, riepilogo + cibo + bevanda + orario, "Riepilogo Ordine", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}