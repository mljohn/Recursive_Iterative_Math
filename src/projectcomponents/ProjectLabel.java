/**
 * File: ProjectLabel
 * Author: Michelle John
 * Date: 03 Dec 2017
 * Purpose: Project 3: Recursion and Iteration
 */
package projectcomponents;

import javax.swing.JLabel;

/**
 * Class that extends {@link JLabel} for customized labels for this application.
 *
 */
public class ProjectLabel extends JLabel {

  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param text the text to set
   */
  public ProjectLabel(String text) {
    super(text, CENTER);
  }
}
