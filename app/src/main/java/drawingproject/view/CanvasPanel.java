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
      Polygon shape;

      double scaleFactor = 1;
      int[] xPoints = {0, 30, 40, 60, 20, 0};
      int[] yPoints = {0, 0, 30, 50, 40, 0};

      for (int index = 0; index < xPoints.length; index++){
         xPoints[index] = (int) Math.round(xPoints[index] * scaleFactor);
         yPoints[index] = (int) Math.round(yPoints[index] * scaleFactor);
      }

      shape = new Polygon(xPoints, yPoints, xPoints.length);

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
