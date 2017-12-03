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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import projectcomponents.ProjectFrame;
import projectcomponents.ProjectLabel;
import projectcomponents.ProjectTextArea;

public class RecursiveIterativeMath {

  public static void main(String[] args) {
    
    RecursiveIterativeMath example = new RecursiveIterativeMath();
    example.createGui();

  }
  
  private void createGui() {
    ProjectFrame projectFrame = new ProjectFrame("Recursive/Iterative Example", 350, 200);
    
    JPanel buttonPanel = new JPanel();
    JPanel textPanel = new JPanel(new GridLayout(4, 2, 5, 5));
    
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
        } else {
          showMessageDialog(projectFrame, "Please enter a valid positive integer larger than 1.");
          enterTextArea.setText(null);
        }
        
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
    
    projectFrame.setLayout(new BorderLayout(5, 5));
    projectFrame.add(buttonPanel, NORTH);
    projectFrame.add(textPanel, CENTER);
    projectFrame.add(new JPanel(), EAST);
    projectFrame.add(new JPanel(), SOUTH);
    
    projectFrame.display();
  }

}
