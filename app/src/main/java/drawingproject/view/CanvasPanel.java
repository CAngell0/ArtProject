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

   private Graphics2D ctx;
   private Rectangle background;

   public CanvasPanel(Controller app){
      super();
      this.app = app;
      this.canvasImage = new BufferedImage(CANVAS_WIDTH, CANVAS_HEIGHT, BufferedImage.TYPE_INT_ARGB);
      this.setMinimumSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

      ctx = (Graphics2D) canvasImage.getGraphics();
      background = new Rectangle(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
      
      updateCanvas();
   }

   /**Sets up and prepares the canvas for drawing */
   private void updateCanvas(){
      ctx.setColor(new Color(240, 180, 180));
      ctx.fill(background);

      ctx.setColor(new Color(0, 0, 0));
      ctx.setStroke(new BasicStroke(2));

      drawShapes();

      ctx.dispose();
      repaint();
   }

   /**
    * Draws all the default shapes on the canvas
    * @param drawingTool The graphics engine to draw the shapes with
    */
   private void drawShapes(){
      ctx.draw(drawBoot(10,10,2));
      ctx.draw(drawCube(100, 100,2));
      ctx.draw(drawDiamond(253, 180, 2));
      ctx.draw(drawGem(423, 623, 3));
      ctx.draw(drawOval(300, 400, 2));
      ctx.draw(drawArrow(100, 650, 2));
   }

   @Override
   protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      graphics.drawImage(canvasImage, 0, 0, null);
   }

   /**Saves the current artwork in canvas to a local png image based on a file chooser */
   public void save(){
      try {
         JFileChooser fileChooser = new JFileChooser();
         if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
            String filePath = fileChooser.getSelectedFile().getPath();
            if (!filePath.toLowerCase().endsWith(".png")){
               filePath += ".png";
            }
            ImageIO.write(canvasImage, "PNG", new File(filePath));
         }
      } catch (IOException | NullPointerException error){
         app.handleError(error);
      }
   }

   /**
    * Created a boot shaped polygon object for drawing
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The Polygon object containing the shape
    */
   private Polygon drawBoot(int x, int y, double scaleFactor){
      Polygon shape;
      int[] xPoints = {0, 30, 40, 60, 20, 0};
      int[] yPoints = {0, 0, 30, 50, 40, 0};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   /**
    * Creates a diamond shaped polygon object for drawing
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The Polygon object containing the shape
    */
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

   /**
    * Creates a cube shaped polygon object for drawing
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The Polygon object containing the shape
    */
   private Polygon drawCube(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {0, 10, 40, 40, 30, 30, 40, 30, 0, 0, 30, 30};
      int[] yPoints = {10, 0, 0, 30, 40, 10, 0, 10, 10, 40, 40, 10};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   /**
    * Creates a gem shaped polygon object for drawing
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The Polygon object containing the shape
    */
   private Polygon drawGem(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {40, 30, 10, 0, 0, 10, 10, 0, 0, 40, 30, 10, 0, 40, 40, 30, 30, 40, 40, 0};
      int[] yPoints = {0, 10, 10, 0, 40, 30, 10, 0, 40, 40, 30, 30, 40, 40, 0, 10, 30, 40, 0, 0};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   /**
    * Creates a arrow shapes polygon object for drawing
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The Polygon object containing the shape
    */
   private Polygon drawArrow(int x, int y, double scaleFactor){
      Polygon shape = new Polygon();
      int[] xPoints = {10, 20, 10, 20, 40, 30, 40, 30, 40, 90, 90, 120, 90, 90, 20, 10};
      int[] yPoints = {10, 20, 30, 20, 20, 10, 20, 30, 20, 20, 0, 20, 40, 20, 20, 10};

      xPoints = adjustValues(xPoints, x, scaleFactor);
      yPoints = adjustValues(yPoints, y, scaleFactor);

      shape = new Polygon(xPoints, yPoints, xPoints.length);

      return shape;
   }

   /**
    * Created an oval shape object
    * @param x X position to draw the shape
    * @param y Y position to draw the shape
    * @param scaleFactor Relative size of the shape
    * @return The ellipse object containing the shape
    */
   private Ellipse2D.Double drawOval(int x, int y, double scaleFactor){
      Ellipse2D.Double shape = new Ellipse2D.Double(x, y, 80 * scaleFactor, 40 * scaleFactor);

      return shape;
   }

   /**
    * This method adjusts an array of x or y point values. It first adds a specified scale
    * factor to enlarge the shape. And then offsets the points with the originOffset param.
    * This allows the shape to change size and position
    * @param values The values to adjust
    * @param originOffset The new origin value you want for the shape
    * @param scaleFactor The scale factor you multiply the shape size by
    * @return An array of the newly adjusted values
    */
   private int[] adjustValues(int[] values, int originOffset, double scaleFactor){
      int[] result = values;

      for (int index = 0; index < result.length; index++){
         result[index] = (int) Math.round(result[index] * scaleFactor);
         result[index] += originOffset;
      }

      return result;
   }
}
