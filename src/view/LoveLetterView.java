package view;

import javax.swing.*;

public class LoveLetterView extends JFrame {

    private JTextArea zoneTexte;
    private JTextField zoneSaisie;
    private JButton boutonValider;

    public LoveLetterView() {
        setTitle("Love Letter");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centre la fenêtre

        zoneTexte = new JTextArea();
        zoneTexte.setEditable(false);

        zoneSaisie = new JTextField();
        boutonValider = new JButton("Valider");

        JScrollPane scroll = new JScrollPane(zoneTexte);

        JPanel bas = new JPanel();
        bas.setLayout(new BoxLayout(bas, BoxLayout.X_AXIS));
        bas.add(zoneSaisie);
        bas.add(boutonValider);

        add(scroll, "Center");
        add(bas, "South");

        setVisible(true); // 🔥 la fenêtre apparaît
    }

    public void afficherMessage(String msg) {
        zoneTexte.append(msg + "\n");
    }

    public String lireSaisie() {
        String texte = zoneSaisie.getText();
        zoneSaisie.setText("");
        return texte;
    }
}
