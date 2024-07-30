package classes.screens;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import classes.components.Header;
import classes.components.Music;

public class PlaylistScreen extends JFrame {

    Header header = new Header();
    JPanel playlistInfo = new JPanel();
    JPanel musicInfo = new JPanel();
    Music music = new Music("Midnight Sky");
    JLabel playlistInfoColab = new JLabel("Colaboradores");
    JLabel musicInfoTitle = new JLabel("It Will Rain");

    public PlaylistScreen() {
        setTitle("Spotimy");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);

        playlistInfo.setBounds(20, 120, 350, 150);
        playlistInfo.setBackground(new Color(222, 222, 222));
        playlistInfo.add(playlistInfoColab);
        playlistInfoColab.setBounds(25, 15, 300, 170);
        playlistInfoColab.setFont(new Font("Poppins", Font.PLAIN, 22));

        musicInfo.setBounds(20, 290, 350, 200);
        musicInfo.setBackground(new Color(222, 222, 222));
        musicInfo.add(musicInfoTitle);
        musicInfoTitle.setBounds(25, 15, 300, 120);
        musicInfoTitle.setFont(new Font("Poppins", Font.PLAIN, 22));
        
        music.setBounds(410, 120, 570, 60);

        add(header);
        add(playlistInfo);
        add(musicInfo);
        add(music);
    }
}
