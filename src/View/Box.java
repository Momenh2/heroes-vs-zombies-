package View;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Box


  {
    public static void displayGameOver(){
      //block events to other windows
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL); //we are to block input events with other windows

      window.setTitle("Game Over");
      window.setMinWidth(250);

      Label label = new Label();
      label.setText("You have lost....  ");
      Button closeButton = new Button("CLose the Game");
      closeButton.setOnAction(e ->{
        window.close();
        Main.window.close();
      });


      VBox layout = new VBox(10);
      layout.getChildren().addAll(label,closeButton);
      layout.setAlignment(Pos.CENTER);

      Scene scene = new Scene(layout);
      window.setScene(scene);
      //Display Window until it is closed
      window.showAndWait();



    }
    public static void displayWin(){
      //block events to other windows
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL);

      //we are to block input events with other windows

      window.setTitle("Game Over");
      window.setMinWidth(250);

      Label label = new Label();
      label.setText("You WON.... Congrats Good luck in your quiz :) ");
      Button closeButton = new Button("CLose the Game");

      closeButton.setOnAction(e ->{
        window.close();
        Main.window.close();


      });


      VBox layout = new VBox(10);
      layout.getChildren().addAll(label,closeButton);
      layout.setAlignment(Pos.CENTER);

      Scene scene = new Scene(layout);
      window.setScene(scene);
      //Display Window until it is closed
      window.showAndWait();



    }
    public static void displayTrap(){
      //block events to other windows
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL); //we are to block input events with other windows

      window.setTitle("TRAAAPP");
      window.setMinWidth(250);

      Label label = new Label();
      label.setText("Traaap");

      Button closeButton = new Button("close");

      closeButton.setOnAction(e ->{
        window.close();
        Main.window.setFullScreen(true);
          });


      VBox layout = new VBox(10);
      layout.getChildren().addAll(label,closeButton);
      layout.setAlignment(Pos.CENTER);

      Scene scene = new Scene(layout);
      window.setScene(scene);
      //Display Window until it is closed
      window.showAndWait();



    }

    public static void displayMove(String title,String message){
      //block events to other windows
      Stage window = new Stage();
      window.initModality(Modality.APPLICATION_MODAL); //we are to block input events with other windows

      window.setTitle(title);
      window.setMinWidth(250);

      Label label = new Label();

      label.setText(message);

      Button closeButton = new Button("close");

      closeButton.setOnAction(e ->{
        window.close();
        Main.window.setFullScreen(true);
      });


      VBox layout = new VBox(10);
      layout.getChildren().addAll(label,closeButton);
      layout.setAlignment(Pos.CENTER);

      Scene scene = new Scene(layout);
      window.setScene(scene);
      //Display Window until it is closed
      window.showAndWait();



    }




  }