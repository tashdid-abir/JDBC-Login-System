import javax.swing.*;
import java.awt.*;

public class test2 {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Practise");
        frame.setBounds(200,200,800,800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JButton button = new JButton("Login");
        button.setBounds(95,460,200,35);
        button.setForeground(Color.black);
        //button.setBackground(new Color(102,178,255));
        button.setFocusable(false);

        frame.add(button);

    }
}
