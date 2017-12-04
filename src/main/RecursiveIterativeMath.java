/**
 * File: RecursiveIterativeMath
 * Author: Michelle John
 * Date: 03 Dec 2017
 * Purpose: Project 3: Recursion and Iteration
 */
package main;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static javax.swing.JOptionPane.showMessageDialog;
import static main.Sequence.computeIterative;
import static main.Sequence.computeRecursive;
import static main.Sequence.getEfficiency;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import projectcomponents.ProjectFrame;
import projectcomponents.ProjectLabel;
import projectcomponents.ProjectTextArea;

/**
 * Main class to start this application. 
 */
public class RecursiveIterativeMath {

  /**
   * Main method. Start of application.
   * 
   * @param args the array of arguments
   */
  public static void main(String[] args) {
    
    RecursiveIterativeMath example = new RecursiveIterativeMath();
    example.createGui();

  }
  
  /**
   * Method that creates this application's GUI.
   */
  private void createGui() {
    ProjectFrame projectFrame = new ProjectFrame("Recursive/Iterative Example", 350, 200);
    
    JPanel buttonPanel = new JPanel();
    JPanel textPanel = new JPanel(new GridLayout(5, 2, 5, 5));
    
    JRadioButton iterativeButton = new JRadioButton("Iterative", true);
    JRadioButton recursiveButton = new JRadioButton("Recursive");
    
    ButtonGroup radioButtons = new ButtonGroup();
    
    ProjectTextArea resultTextArea = new ProjectTextArea(false);
    ProjectTextArea efficiencyTextArea = new ProjectTextArea(false);
    ProjectTextArea enterTextArea = new ProjectTextArea(true);
    ProjectLabel resultLabel = new ProjectLabel("Result");
    ProjectLabel efficiencyLabel = new ProjectLabel("Efficiency");
    ProjectLabel label = new ProjectLabel("Enter a number");
    
    JButton computeButton = new JButton("Compute");
    JButton clearButton = new JButton("Clear");
    
    computeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        int startNumber = 0;
        try {
          startNumber = Integer.parseInt(enterTextArea.getText());
        } catch (NumberFormatException ex) {
          showMessageDialog(projectFrame, "Please enter a valid positive integer larger than 1.");
          enterTextArea.setText(null);
        }
        if (iterativeButton.isSelected() && startNumber > 1) {
          resultTextArea.setText(Integer.toString(computeIterative(startNumber)));
          efficiencyTextArea.setText(Integer.toString(getEfficiency()));
        } else if (recursiveButton.isSelected() && startNumber > 1) {
          resultTextArea.setText(Integer.toString(computeRecursive(startNumber)));
          efficiencyTextArea.setText(Integer.toString(getEfficiency()));
        }
      }
    });
    
    clearButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        enterTextArea.setText(null);
        resultTextArea.setText(null);
        efficiencyTextArea.setText(null);
      }
    });
    
    radioButtons.add(iterativeButton);
    radioButtons.add(recursiveButton);
    
    buttonPanel.add(iterativeButton);
    buttonPanel.add(recursiveButton);
    
    textPanel.add(label);
    textPanel.add(enterTextArea);
    textPanel.add(new JPanel());
    textPanel.add(computeButton);
    textPanel.add(resultLabel);
    textPanel.add(resultTextArea);
    textPanel.add(efficiencyLabel);
    textPanel.add(efficiencyTextArea);
    textPanel.add(new JPanel());
    textPanel.add(clearButton);
    
    projectFrame.addWindowListener(new ProjectWindowListener());
    projectFrame.setLayout(new BorderLayout(5, 5));
    projectFrame.add(buttonPanel, NORTH);
    projectFrame.add(textPanel, CENTER);
    projectFrame.add(new JPanel(), EAST);
    projectFrame.add(new JPanel(), SOUTH);
    
    projectFrame.display();
  }
  
  /**
   * Private class that handles the window closing event.
   */
  private class ProjectWindowListener extends WindowAdapter {
    /**
     * Re-implementation if the windowClosing method in {@link WindowAdapter}. This method computes the values
     * using an index of 0 to 10 and prints the results to a csv file.
     */
    public void windowClosing(WindowEvent e) {
      BufferedWriter writer = null;
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0;  i < 10; i++) {
        sb.append(Integer.toString(i) 
            + ","
            + Integer.toString(computeIterative(i)) 
            + "," 
            + Integer.toString(getEfficiency())
            + "," 
            + Integer.toString(computeRecursive(i))
            + "," 
            + Integer.toString(getEfficiency())
            + "\n");
      }
      try {
        writer = new BufferedWriter(new FileWriter("Project_Data.csv"));
        writer.write(sb.toString());
        writer.close();
      } catch (IOException ex) {
        System.err.println("Failed to write the file");
      }
    }
  }
}
