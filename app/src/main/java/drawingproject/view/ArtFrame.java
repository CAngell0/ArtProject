package drawingproject.view;

import javax.swing.JFrame;

import drawingproject.controller.Controller;

public class ArtFrame extends JFrame {
   private Controller app;
   private ArtPanel artPanel;

   public ArtFrame(Controller app){
      super();
      this.app = app;
      this.artPanel = new ArtPanel();

      setupFrame();
   }

   public void setupFrame(){
      this.setSize(1200, 900);
      this.setContentPane(artPanel);
      this.setTitle("Java Artwork");
      this.setResizable(false);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
