package drawingproject.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import drawingproject.controller.Controller;

public class ArtPanel extends JPanel {
   private Controller app;
   private SpringLayout layout;
   private JPanel buttonPanel;
   private JButton saveButton;

   public ArtPanel(Controller app){
      super();
      this.app = app;
      this.layout = new SpringLayout();
      this.buttonPanel = new JPanel();
      this.saveButton = new JButton("Save");
   }

   public void setupPanel(){
      this.setLayout(layout);
      this.add(buttonPanel);
      this.buttonPanel.add(saveButton);
   }

   public void setupListeners(){

   }

   public void setupLayout(){

   }
}
