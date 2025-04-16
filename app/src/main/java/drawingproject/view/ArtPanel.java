package drawingproject.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.SpringLayout.Constraints;

import drawingproject.controller.Controller;

public class ArtPanel extends JPanel {
   private Controller app;
   private SpringLayout layout;
   private JPanel buttonPanel;
   private JButton saveButton;

   private CanvasPanel canvas;

   public ArtPanel(Controller app){
      super();
      this.app = app;
      this.layout = new SpringLayout();
      this.buttonPanel = new JPanel();
      this.saveButton = new JButton("Save");

      this.canvas = new CanvasPanel(app);

      setupPanel();
      setupListeners();
      setupLayout();
   }

   public void setupPanel(){
      this.setLayout(layout);
      this.add(canvas);
      this.add(buttonPanel);
      this.buttonPanel.add(saveButton);
   }

   public void setupListeners(){

   }

   public void setupLayout(){
      layout.putConstraint(SpringLayout.NORTH, canvas, 50, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.WEST, canvas, 50, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.EAST, canvas, 850, SpringLayout.WEST, this);
      layout.putConstraint(SpringLayout.SOUTH, canvas, -50, SpringLayout.SOUTH, this);

      layout.putConstraint(SpringLayout.NORTH, buttonPanel, 50, SpringLayout.NORTH, this);
      layout.putConstraint(SpringLayout.EAST, buttonPanel, -50, SpringLayout.EAST, this);
      layout.putConstraint(SpringLayout.WEST, buttonPanel, 50, SpringLayout.EAST, canvas);
      layout.putConstraint(SpringLayout.SOUTH, buttonPanel, -50, SpringLayout.SOUTH, this);
   }
}
