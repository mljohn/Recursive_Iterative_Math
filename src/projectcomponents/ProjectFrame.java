package projectcomponents;

import javax.swing.JFrame;

public class ProjectFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;

  public ProjectFrame(String title, int width, int height) {
    super(title);
    setSize(width, height);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }
  
  public void display() {
    setVisible(true);
  }
}
