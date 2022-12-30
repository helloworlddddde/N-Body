package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import Math.Data.Matrix;
import Math.Operation.Linalg;
import Math.Operation.Stats;
import NeuralNet.Layer;
import NeuralNet.MLP;


public class Main extends Application{


    public static void main(String args[]) throws Exception {
        launch(args);



    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 0, 0));
        primaryStage.show();


    }




}