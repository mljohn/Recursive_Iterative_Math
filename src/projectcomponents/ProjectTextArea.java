package projectcomponents;

import static java.awt.Color.BLACK;
import static java.awt.Color.LIGHT_GRAY;

import javax.swing.JTextArea;

public class ProjectTextArea extends JTextArea {
  
  private static final long serialVersionUID = 1L;

  public ProjectTextArea(boolean editable) {
    super();
    setEditable(editable);
    setColumns(10);
    setBackground(LIGHT_GRAY);
    setForeground(BLACK);
  }

}
