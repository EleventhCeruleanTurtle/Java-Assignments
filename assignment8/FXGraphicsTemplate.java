package assignment8;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

import static javafx.application.Application.launch;

/**
 * Use this template to create drawings in FX. Change the name of the class and
 * put your own name as author below. Change the size of the canvas and the
 * window title where marked and add your drawing code where marked.
 *
 * @author Jack White, from template
 */
public class FXGraphicsTemplate extends Application {
    // Instance variables for view components and model
    private TextField row;
    private TextField column;
    public static Label sMCLabel;
    // turn counter for the game
    private static int turn = 0;
    // graphics context to create shapes
    private GraphicsContext gc;
    // toggle tracker for selectAndMove feature
    public static boolean selectAndMove = false;
    // selected playspace one
    public static PlaySpace psOne;
    // selected playspace two
    public static PlaySpace psTwo;
    // playspace array
    public static ArrayList<PlaySpace> playSpaces = new ArrayList<>();

    /**
     * Getter for turn
     * @return turn
     */
    public static int getTurn() {
        return turn;
    }

    /**
     * Setter for turn, used to change from 0 to 1 and vice-versa
     * @param newNum the new turn number
     */
    public static void setTurn(int newNum) {
        turn = newNum;
    }

    /**
     * remove circle method, on button press, gets row and column from text fields, checks values with playspace variables and if the same, redraws the playspace and
     * sets has circle variable to false.
     * @param e Action Event
     */
    public void removeCircle(ActionEvent e) {
        int rowNum = 0;
        int columnNum = 0;
        try {
            rowNum = Integer.parseInt(row.getText());
            columnNum = Integer.parseInt(column.getText());
        }
        catch (Exception error) {
            new Alert(Alert.AlertType.WARNING, "Invalid row or column, numbers 0-2 are accepted.").showAndWait();
        }
        row.setText("");
        column.setText("");
        for (PlaySpace ps: playSpaces) {
            if (ps.getRow() == rowNum && ps.getColumn() == columnNum && ps.HasCircle()) {
                ps.draw(gc);
                ps.setHasCircle(false);
            }
        }
    }

    /**
     * Select and move circle toggle, when not on the button press sets text to indicate that the toggle is enabled, when on the button press sets text to be blank
     * @param e Action Event
     */
    public void selectAndMoveCircleToggle(ActionEvent e) {
        if (selectAndMove) {
            sMCLabel.setText("");
            selectAndMove = false;
        } else {
            sMCLabel.setText("Select and Move is now enabled.");
            selectAndMove = true;

        }
        
    }
    /**
     * Start method
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(400, 300); // Set canvas Size in Pixels
        stage.setTitle("Assignment 8"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        gc = canvas.getGraphicsContext2D();

        // Create the GUI components
        Label rowLabel = new Label("Row");
        row = new TextField();
        Label columnLabel = new Label("Column");
        column = new TextField();
        Button btn = new Button("Remove Circle");
        Button selectBtn = new Button("Select and Move Circle");
        sMCLabel = new Label("");
        

        // Add components to the root
        root.getChildren().addAll(rowLabel, row, columnLabel, column, btn, selectBtn, sMCLabel);

        // Configure the components
        rowLabel.relocate(225,70);
        row.relocate(225,90);
        columnLabel.relocate(225,120);
        column.relocate(225,140);
        btn.relocate(225,170);
        selectBtn.relocate(225, 200);
        sMCLabel.relocate(225, 225);

        // Using a for loop in a for loop, create the 3x3 grid to play on
        double x = 0;
        double y = 0;
        gc.setFill(Color.BLACK);
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                PlaySpace ps = new PlaySpace(i,j,x,y,60,Color.BLACK);
                root.getChildren().add(ps.getCanvas());
                x += 70;
                ps.draw(gc);
            }
            y+= 70;
            x = 0;
        }

        // Add event handlers and do final setup
        btn.setOnAction(this::removeCircle);
        selectBtn.setOnAction(this::selectAndMoveCircleToggle);
        // Show the stage
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
