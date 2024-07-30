package classes.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.ArrayList;

public class AudioList extends JScrollPane {
    private ArrayList<Music> musics = new ArrayList<>();
    private JPanel musicPanel = new JPanel();;

    public AudioList(String[] musicNames) {
        musicPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        musicPanel.setBackground(new Color(222, 222, 222));

        for (String musicName : musicNames) {
            Music music = new Music(musicName);
            musics.add(music);
            musicPanel.add(music);
        }

        int height = musicNames.length * 70;
        musicPanel.setPreferredSize(new Dimension(610, height));

        setViewportView(musicPanel);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        setBounds(390, 100, 598, 565);
    }
}
