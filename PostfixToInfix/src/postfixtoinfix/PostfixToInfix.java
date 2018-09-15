/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ldcha
 */
public class PostfixToInfix {

    /**
     * @param args the command line arguments
     */
    public JTextField inputText = new JTextField(20);
    public JTextField resultText = new JTextField(20);

    public JButton evaluateButton = new JButton("Construct Tree");
    //Create GUI
 public PostfixToInfix(){
      //create JFrame
        JFrame frame = new JFrame("Three Address Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set Font
        Font f = new Font("Roboto", Font.PLAIN, 30);
        //create panels
        //create inputPanel
        JPanel inputPanel = new JPanel();
        //create JButton panel
        JPanel buttonPanel = new JPanel();
        //create resultPanel
        JPanel resultPanel = new JPanel();

        //create Labels
        JLabel inputLabel = new JLabel("Enter Postfix Expression: ", SwingConstants.CENTER);
        JLabel resultLabel = new JLabel("Infix Expression: ", SwingConstants.CENTER);
        resultText.setEditable(false);
        //create button
        evaluateButton = new JButton("evaluate");
       
        //Set Font to fields
        inputLabel.setFont(f);
        inputLabel.repaint();
        resultLabel.setFont(f);
        resultLabel.repaint();
        inputText.setFont(f);
        inputText.repaint();
        resultText.setFont(f);
        resultText.repaint();
        evaluateButton.setFont(f);
        evaluateButton.repaint();
        evaluateButton.setPreferredSize(new Dimension(500, 50));
        
        //add labels to Panels
        inputPanel.add(inputLabel);
        inputPanel.add(inputText);
        buttonPanel.add(evaluateButton);
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);
        //add Panels to frame with BorderLayout
        frame.add(inputPanel, BorderLayout.PAGE_START);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.PAGE_END);
        frame.setSize(900, 275);
        frame.setVisible(true);
 }
    public static void main(String[] args) {
        PostfixToInfix postfixtoinfix = new PostfixToInfix();
    }
    
}
