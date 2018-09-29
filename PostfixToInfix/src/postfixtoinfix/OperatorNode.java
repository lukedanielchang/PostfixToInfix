/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixtoinfix;

/**
 *
 * @author ldcha
 */
import java.io.*;

public class OperatorNode extends Node {
  private Node left;
  private Node right;
  private String operator;
  private String leftValue;
  private String rightValue;
  private File file;
  private PrintWriter printWriter;
  private String registerName;
  private static int i = 0;

  // Constructor
  public OperatorNode(String operator, Node right, Node left) {
    this.operator = operator;
    this.left = left;
    this.right = right;
  }

  // Getter
  public String getName() {
    return registerName;
  }

  // Setter
  public void setName() {
    this.registerName = "R" + i;
    i++;
  }

    /* Initialize file and writer to print output to file, call methods
    * to print three address instructions to file and close writer
    */  
  public void printFile() {
    file = new File("ExpressionTree.txt");
    try {
      printWriter = new PrintWriter(file);
      this.postOrderWalk(printWriter);
      printWriter.close();
      i = 0;
    } catch (FileNotFoundException ex) {
      System.out.println("File Does Not Exist");
    }
  }

  /*postOrderWalk traverses the tree 
   *print three address instructions to ExpressionTree.txt file
   */
  public void postOrderWalk(PrintWriter printWriter) {
    left.postOrderWalk(printWriter);
    right.postOrderWalk(printWriter);
    if (this instanceof OperatorNode) {
      this.setName();
    }
    leftValue = left.getName();
    rightValue = right.getName();
    printWriter.println(getOutput(operator) + " " + registerName + " "
        + leftValue + " " + rightValue);
  }

  //inOrderWalk traverses the tree to return final infix expression
  public String inOrderWalk() {
    leftValue = left.inOrderWalk();
    rightValue = right.inOrderWalk();
    return "(" + leftValue + " " + operator + " " + rightValue + ")";
  }

  //  getOutputMethod returns operation for three address output in the txt file
  private static String getOutput(String operation) {
    switch (operation) {
      case "+":
          return "Add";
      case "-":
          return "Sub";
      case "*":
          return "Mul";
      case "/":
        return "Div";
    }
    return "Errr";
  }
}