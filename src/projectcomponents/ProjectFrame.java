/**
 * File: ProjectFrame
 * Author: Michelle John
 * Date: 03 Dec 2017
 * Purpose: Project 3: Recursion and Iteration
 */
package projectcomponents;

import javax.swing.JFrame;

/**
 * Class that extends {@link JFrame} for a customized frame for this application.
 */
public class ProjectFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @param title the frame's title
   * @param width the width of the frame
   * @param height the height of the frame
   */
  public ProjectFrame(String title, int width, int height) {
    super(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  /**
   * Sets visibility to true.
   */
  public void display() {
    setVisible(true);
  }
}
