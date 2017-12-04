/**
 * File: ProjectTextArea
 * Author: Michelle John
 * Date: 03 Dec 2017
 * Purpose: Project 3: Recursion and Iteration
 */
package projectcomponents;

import static java.awt.Color.BLACK;
import static java.awt.Color.LIGHT_GRAY;

import javax.swing.JTextArea;

/**
 * Class that extends {@link JTextArea} for customized text areas for this application.
 *
 */
public class ProjectTextArea extends JTextArea {
  
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param editable if the field is editable
   */
  public ProjectTextArea(boolean editable) {
    super();
    setEditable(editable);
    setColumns(10);
    setBackground(LIGHT_GRAY);
    setForeground(BLACK);
  }

}
