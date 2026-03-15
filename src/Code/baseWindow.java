package Code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class baseWindow extends JFrame {

    private JPanel contentPane;
    private JButton button1;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;

    public baseWindow() {

        setTitle("Card Shit!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formattedTextField3.setText("Test successs!");
            }
        });

        formattedTextField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                formattedTextField2.setText(formattedTextField1.getText());
                super.keyTyped(e);
            }
        });
    }

}
