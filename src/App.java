import javax.swing.*;
import classes.Teste;
import classes.Valores;

public class App {

    public static void main(String[] args) {

        Object selectedValue1 = JOptionPane.showOptionDialog(
            null, 
            "Estou testando isso aqui, selecione uma opção", 
            "Testanto isso", 
            JOptionPane.YES_NO_OPTION, 
            1, 
            null, 
            Valores.valores, 
            null
        );

        JOptionPane.showMessageDialog(null, "O valor selecionado foi: " + Valores.valores[(int)selectedValue1]);

        Object selectedValue2 = JOptionPane.showInputDialog(
            null,
            Teste.message,
            Teste.title, 
            JOptionPane.INFORMATION_MESSAGE,
            null, 
            Teste.opcao, 
            Teste.opcao[0]
        );

        JOptionPane.showMessageDialog(null, "O valor selecionado foi: " + selectedValue2);
    }
}
