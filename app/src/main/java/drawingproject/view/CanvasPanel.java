package drawingproject.view;

import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class CanvasPanel extends JPanel {
   public CanvasPanel(){

   }

   private Polygon drawBoot(){
      Polygon shape = new Polygon();

      return shape;
   }

   private Polygon drawDiamond(){
      Polygon shape = new Polygon();

      return shape;
   }

   private Polygon drawCube(){
      Polygon shape = new Polygon();

      return shape;
   }

   private Polygon drawGem(){
      Polygon shape = new Polygon();

      return shape;
   }

   private Polygon drawArrow(){
      Polygon shape = new Polygon();

      return shape;
   }

   private Ellipse2D.Double drawOval(){
      Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, 80, 40);

      return shape;
   }
}
