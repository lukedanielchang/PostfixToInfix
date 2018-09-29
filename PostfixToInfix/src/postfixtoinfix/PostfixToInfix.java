/*
 * This program will take a postfix expression and 
 * create an algebraic expression.  This class will be responsible for creating
 * and launching the GUI.  It contains the main method, which is uses the
 * launch() to launch the program.
 */
package postfixtoinfix;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ldcha
 */
public class PostfixToInfix {

    /**
     * initialize text fields and button
     */
    private JTextField inputText = new JTextField(20);
    private JTextField resultText = new JTextField(20);
    private JButton constructButton = new JButton("Construct Tree");
    private JFrame frame = new JFrame("Three Address Generator");

    //Create GUI
    public PostfixToInfix() {
        //set default close operation to smoothly close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set Font
        Font f = new Font("Roboto", Font.PLAIN, 30);
        /*create panels: input, button, and result panels.  These panels will
        *house their specified elements, which will be added to the frame.
         */
        //create inputPanel
        JPanel inputPanel = new JPanel();
        //create JButton panel
        JPanel buttonPanel = new JPanel();
        //create resultPanel
        JPanel resultPanel = new JPanel();

        //create Labels
        JLabel inputLabel = new JLabel("Enter Postfix Expression: ", SwingConstants.CENTER);
        JLabel resultLabel = new JLabel("Infix Expression: ", SwingConstants.CENTER);
        //make resulting feild uneditable
        resultText.setEditable(false);

        //add event handler to button
        constructButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ExpressionTree result = new ExpressionTree(inputText.getText());
                    resultText.setText(result.getInfix());
                } catch (RuntimeException ex) {
                    resultText.setText("error");
                    JOptionPane.showMessageDialog(null, "Invalid Expression: " + ex.getMessage(),
                            "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        /* Set Fonts to Labels, Text Fields and Button
                *Repaint lables, fields, and button with new fonts
                *set preferred Size for button
         */
        inputLabel.setFont(f);
        inputLabel.repaint();
        resultLabel.setFont(f);
        resultLabel.repaint();
        inputText.setFont(f);
        inputText.repaint();
        resultText.setFont(f);
        resultText.repaint();
        constructButton.setFont(f);
        constructButton.repaint();
        constructButton.setPreferredSize(new Dimension(500, 50));

        //add labels to Panels
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);
        buttonPanel.add(constructButton);
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);

        //add Panels to frame with BorderLayout
        frame.add(inputPanel, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.PAGE_END);
        frame.setSize(900, 275);
    }

    //Create method to launch GUI
    public void launch() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        PostfixToInfix postfixtoinfix = new PostfixToInfix();
        postfixtoinfix.launch();
    }

}
