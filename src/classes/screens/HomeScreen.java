package classes.screens;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class HomeScreen extends JFrame {

    ImageIcon logoPath = new ImageIcon("Spotimy/src/assets/logo.png");
    JLabel logo = new JLabel(logoPath);

    JLabel title = new JLabel(
        "O que vamos ouvir hoje?", 
        SwingConstants.CENTER
    );

    JButton playlist = new JButton(
        "Playlists"
    );

    JButton podcast = new JButton(
        "Podcasts"
    );

    JButton audiobook = new JButton(
        "Áudio Livros"
    );

    public HomeScreen() {
        setTitle("Spotimy");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        logo.setBounds(427, 75, 133, 133);
        add(logo);

        title.setBounds(339, 208, 300, 30);
        title.setFont(new Font("Poppins", Font.PLAIN, 25));
        add(title, playlist);

        playlist.setBounds(236, 294, 528, 72);
        playlist.setFont(new Font("Poppins", Font.PLAIN, 22));
        playlist.setCursor(new Cursor(12));
        add(playlist);

        podcast.setBounds(236, 396, 528, 72);
        podcast.setFont(new Font("Poppins", Font.PLAIN, 22));
        podcast.setCursor(new Cursor(12));
        add(podcast);

        audiobook.setBounds(236, 498, 528, 72);
        audiobook.setFont(new Font("Poppins", Font.PLAIN, 22));
        audiobook.setCursor(new Cursor(12));
        add(audiobook);
    }
}
