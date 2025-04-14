package drawingproject.view;

import javax.swing.JFrame;

import drawingproject.controller.Controller;

public class ArtFrame extends JFrame {
   private Controller app;

   public ArtFrame(Controller app){
      this.app = app;
   }
}
