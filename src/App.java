import java.awt.*;
import java.net.http.WebSocket.Listener;

import javax.swing.*;

public class App extends JFrame{

    JButton botao = new JButton("Clique em mim!");
    JButton botao2 = new JButton("Clique em mim!");

    App(){
        setTitle("Spotimy");
        setSize(1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(null);
        botao.setBounds(1, 1, botao.getPreferredSize().width, botao.getPreferredSize().height);
        botao2.setBounds(botao.getWidth(), 1, botao.getPreferredSize().width, botao.getPreferredSize().height);
        botao.setBackground(new Color(00,255,00));
        add(botao);
        add(botao2);
        setVisible(true);
    }
    
    public static void main(String[] args) {

        App app = new App();
    }
}
