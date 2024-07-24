import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    private JButton teste4Button;
    private JButton teste1Button;
    private JButton teste3Button;
    private JButton test2Button;
    private JPanel panel1;

    public App() {
        setContentPane(panel1);
        setTitle("Spotimy");
        getDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        
        teste1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(App.this, "Clicou");
            }
        });
    }

    private void getDefaultCloseOperation(int exitOnClose) {
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {
        new App();
    }
}
