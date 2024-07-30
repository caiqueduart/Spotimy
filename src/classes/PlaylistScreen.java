package classes;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PlaylistScreen extends JFrame {

    JPanel header = new JPanel();
    JPanel playlistInfo = new JPanel();
    JPanel musicInfo = new JPanel();
    JLabel playlistInfoColab = new JLabel("Colaboradores");
    JLabel musicInfoTitle = new JLabel("It Will Rain");

    String[] playlists = {
        "play 1", 
        "play 2", 
        "play 3"
    };

    JLabel playingNow = new JLabel("Reproduzindo Agora ...");
    JComboBox selection = new JComboBox(playlists);

    public PlaylistScreen() {
        setTitle("Spotimy");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        header.setBounds(0, 0, 1000, 100);
        header.setBackground(new Color(222, 222, 222));
        header.setLayout(null);
        header.add(selection);
        header.add(playingNow);

        playingNow.setBounds(400, 37, 570, 27);
        playingNow.setFont(new Font("Poppins", Font.PLAIN, 22));

        selection.setBounds(20, 20, 350, 60);
        selection.setFont(new Font("Poppins", Font.PLAIN, 22));

        playlistInfo.setBounds(20, 120, 350, 150);
        playlistInfo.setBackground(new Color(222, 222, 222));
        playlistInfo.add(playlistInfoColab);
        playlistInfoColab.setBounds(20, 120, 350, 150);
        playlistInfoColab.setFont(new Font("Poppins", Font.PLAIN, 22));

        musicInfo.setBounds(20, 290, 350, 200);
        musicInfo.setBackground(new Color(222, 222, 222));
        musicInfo.add(musicInfoTitle);
        musicInfoTitle.setBounds(20, 290, 350, 200);
        musicInfoTitle.setFont(new Font("Poppins", Font.PLAIN, 22));
        
        add(header);
        add(playlistInfo);
        add(musicInfo);
    }
}
