package ui;

import Math.Operation.Linalg;
import Math.Operation.Stats;
import NeuralNet.Layer;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;

public class Controller {
    private static ArrayList<TitledPane> vLayers = new ArrayList<TitledPane>();
    private static ArrayList<Layer> Layers = new ArrayList<Layer>();

    @FXML // fx:id="VBlock"
    private VBox VBlock; // Value injected by FXMLLoader

    @FXML // fx:id="board"
    private AnchorPane board; // Value injected by FXMLLoader

    @FXML // fx:id="layerButton"
    private Button layerButton; // Value injected by FXMLLoader

    @FXML
    void onClick(MouseEvent event) {
        Layer L = new Layer(5, 5, 5, Stats::Tanh, Linalg::lComb);
        L.setaType("Tanh");
        L.setcType("Input x Weight + Bias");
        Layers.add(L);
        HBox hbox = new HBox();
        hbox.getChildren().add(new Text(L.toString()));
        TitledPane pane = new TitledPane("Layer " + (vLayers.size() + 1), hbox);
        hbox.getChildren().add(new TextField("dog"));



        VBlock.getChildren().add(pane);
        vLayers.add(pane);

    }
}

