package drawingproject.controller;

import javax.swing.JOptionPane;
import drawingproject.view.ArtFrame;

public class Controller {
   private ArtFrame frame;

   public Controller(){
      frame = new ArtFrame(this);
   }

   public void start(){
      JOptionPane.showMessageDialog(frame, "Welcome to Java Art!");
   }

   public void handleError(Error error){
      System.err.println(error.getMessage() + error.getStackTrace());
   }
}
