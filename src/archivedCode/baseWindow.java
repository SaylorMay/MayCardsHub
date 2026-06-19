package archivedCode;

import javax.swing.*;
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
                ImageProcessor.setContinueRequest(true);
                System.out.println("Button Pressed!");
            }
        });
    }

    public JButton getButton1() {return button1;}
    public JFormattedTextField getFormattedTextField1() {return formattedTextField1;}
    public JFormattedTextField getFormattedTextField2() {return formattedTextField2;}
    public JFormattedTextField getFormattedTextField3() {return formattedTextField3;}
    public JFormattedTextField getFormattedTextField4() {return formattedTextField4;}

}