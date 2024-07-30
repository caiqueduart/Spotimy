package classes.components;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel{
    JPanel header = new JPanel();
    String[] playlists = {
        "play 1", 
        "play 2", 
        "play 3"
    };
    JLabel playingNow = new JLabel("Reproduzindo Agora ...");
    JComboBox selection = new JComboBox(playlists);

    public Header() {
        setBounds(0, 0, 1000, 100);
        setBackground(new Color(222, 222, 222));
        setLayout(null);
        add(selection);
        add(playingNow);

        playingNow.setBounds(400, 37, 570, 27);
        playingNow.setFont(new Font("Poppins", Font.PLAIN, 22));

        selection.setBounds(20, 20, 350, 60);
        selection.setFont(new Font("Poppins", Font.PLAIN, 22));
    }
}
