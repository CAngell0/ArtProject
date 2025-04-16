package drawingproject.view;

import drawingproject.controller.Controller;

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
   int CANVAS_WIDTH = 800;
   int CANVAS_HEIGHT = 800;

   private Controller app;
   private BufferedImage canvasImage;

   public CanvasPanel(Controller app){
      super();
      this.app = app;
      this.canvasImage = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
      this.setMinimumSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
      
      updateCanvas();
   }

   private void updateCanvas(){
      Graphics2D drawingGraphics = (Graphics2D) canvasImage.getGraphics();
      Rectangle background = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

      drawingGraphics.setColor(new Color(240, 180, 180));
      drawingGraphics.fill(background);

      drawingGraphics.setColor(new Color(0, 0, 0));
      drawingGraphics.setStroke(new BasicStroke(2));

      drawShapes(drawingGraphics);

      drawingGraphics.dispose();
      repaint();
   }

   private void drawShapes(Graphics2D drawingTool){
      drawingTool.draw(drawBoot(10,10,2));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      graphics.drawImage(canvasImage, 0, 0, null);
   }

   private Polygon drawBoot(int x, int y, double scaleFactor){
      Polygon shape;
      int[] xPoints = {0, 30, 40, 60, 20, 0};
      int[] yPoints = {0, 0, 30, 50, 40, 0};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   private Polygon drawDiamond(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      shape.addPoint((int) (20 * scaleFactor) + x, (int) (0 * scaleFactor) + y);
      shape.addPoint((int) (40 * scaleFactor) + x, (int) (30 * scaleFactor) + y);
      shape.addPoint((int) (30 * scaleFactor) + x, (int) (60 * scaleFactor) + y);
      shape.addPoint((int) (20 * scaleFactor) + x, (int) (70 * scaleFactor) + y);
      shape.addPoint((int) (10 * scaleFactor) + x, (int) (60 * scaleFactor) + y);
      shape.addPoint((int) (0 * scaleFactor) + x, (int) (30 * scaleFactor) + y);
      shape.addPoint((int) (20 * scaleFactor) + x, (int) (0 * scaleFactor) + y);

      return shape;
   }

   private Polygon drawCube(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {0, 10, 40, 40, 30, 30, 40, 30, 0, 0, 30, 30};
      int[] yPoints = {10, 0, 0, 30, 40, 10, 0, 10, 10, 40, 40, 10};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   private Polygon drawGem(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {40, 30, 10, 0, 0, 10, 10, 0, 0, 40, 30, 10, 0, 40, 40, 30, 30, 40};
      int[] yPoints = {0, 10, 10, 0, 40, 30, 10, 0, 40, 40, 30, 30, 40, 40, 0, 10, 30, 40};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   private Polygon drawArrow(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {10, 20, 10, 20, 40, 30, 40, 30, 40, 90, 90, 120, 90, 90};
      int[] yPoints = {10, 20, 30, 20, 20, 10, 20, 30, 20, 20, 0, 20, 40, 20};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   private Ellipse2D.Double drawOval(int x, int y, double scaleFactor){
      Ellipse2D.Double shape = new Ellipse2D.Double(x, y, 80 * scaleFactor, 40 * scaleFactor);

      return shape;
   }

   private int[] adjustValues(int[] values, int originOffset, double scaleFactor){
      int[] result = values;

      for (int index = 0; index < result.length; index++){
         result[index] = (int) Math.round(result[index] * scaleFactor);
         result[index] += originOffset;
      }

      return result;
   }
}
