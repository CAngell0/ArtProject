package drawingproject.controller;

public class Controller {
   public Controller(){

   }

   public void start(){

   }

   public void handleError(Error error){
      System.err.println(error.getMessage() + error.getStackTrace());
   }
}
