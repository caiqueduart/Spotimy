package classes.components;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Music extends JPanel {
    private JLabel nome = new JLabel();
    private JButton play = new JButton("Play");

    public Music(String nome) {
        setSize(570, 60);
        setLayout(null);
        add(this.nome);
        add(play);
        setBackground(new Color(222, 222, 222));
        
        this.nome.setText(nome);
        this.nome.setBounds(20, 16, 420, 28);
        this.nome.setFont(new Font("Poppins", Font.PLAIN, 22));

        play.setBounds(450, 10, 100, 40);
        play.setFont(new Font("Poppins", Font.PLAIN, 22));
    }

    public String getNome() {
        return nome.getText();
    }

    public void setNome(String nome) {
        this.nome.setText(nome);
    }
}
