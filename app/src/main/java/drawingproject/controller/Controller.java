package drawingproject.controller;

import javax.swing.JOptionPane;
import drawingproject.view.ArtFrame;

public class Controller {
   private ArtFrame window;

   public Controller(){
      window = new ArtFrame(this);
   }

   public void start(){
      JOptionPane.showMessageDialog(window, "Welcome to Java Art!");
   }

   public void handleError(Exception error){
      JOptionPane.showMessageDialog(window, error.getMessage(), "Java Art Error!", JOptionPane.ERROR_MESSAGE);
   }
}
