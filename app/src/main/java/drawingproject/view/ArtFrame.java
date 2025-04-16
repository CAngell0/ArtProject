package drawingproject.view;

import javax.swing.JFrame;

import drawingproject.controller.Controller;

public class ArtFrame extends JFrame {
   private Controller app;
   private ArtPanel artPanel;

   public ArtFrame(Controller app){
      super();
      this.app = app;
      this.artPanel = new ArtPanel(app);

      setupFrame();
   }

   public void setupFrame(){
      this.setSize(1350, 900);
      this.setContentPane(artPanel);
      this.setTitle("Java Artwork");
      this.setResizable(false);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
   }
}
