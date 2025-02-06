package assignment5;


import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sam.scott1
 * Modified for Assignment 5
 */
public class FXGUITemplate extends Application {

    // TODO: Instance Variables for View Components and Model
    private Canvas c;
    private GraphicsContext gc;
    private int currency = 0;
    private Label outputLabel;
    private Label pageLabel;
    private Label nextClickLabel;
    private Button firstButton;
    private Button secondButton;
    private Button thirdButton;
    private Assignment5 model = new Assignment5();
    private Image image;
    private Image image2;
    private Image image3;
    private Label firstCountLabel;
    private Label secondCountLabel;
    private Label thirdCountLabel;
    // TODO: Private Event Handlers and Helper Methods
    /**
     * On button click currency is increased by set amount, first, second, and third count are used in amount calculations. 
     * Also displays next click value and checks to see if user has enough currency to buy any of the buildings
     * @param event clicking the mainButton
     */
    public void buttonClick(ActionEvent event) {
        int firstCount = model.getFirstCount();
        int secondCount = model.getSecondCount();
        int thirdCount = model.getThirdCount();
        currency = currency + 1 + (firstCount*1) + (secondCount*10) + (thirdCount*100);
        outputLabel.setText(""+currency);
        int clickValue = 1 + (firstCount*1) + (secondCount*10) + (thirdCount*100);
        nextClickLabel.setText("Next Click: " + clickValue);
        if (currency >= 10) {
            firstButton.setDisable(false);
        }
        if (currency >= 200) {
            secondButton.setDisable(false);
        }
        if (currency >= 5000) {
            thirdButton.setDisable(false);
        }
    }

    /**
     * subtracts 10 currency, if currency is lower than 10 it disables the button, displays currency and page number
     * @param event clicking the firstButton
     */
    public void buyFirst(ActionEvent event) {
        currency = currency - 10;
        if (currency < 10) {
            firstButton.setDisable(true);
        }
        if (currency < 200) {
            secondButton.setDisable(true);
        }
        if (currency < 5000) {
            thirdButton.setDisable(true);
        }
        outputLabel.setText(""+currency);
        model.drawFirst(gc,image);
        int firstCount = model.getFirstCount();
        firstCountLabel.setText(""+firstCount);
        int pageNumber = model.getPage();
        pageLabel.setText("Page "+pageNumber);
        
    }

    /**
     * subtracts 200 currency, if currency is lower than 200 it disables the button, displays currency and page number
     * @param event clicking the secondButton
     */
    public void buySecond(ActionEvent event) {
        currency = currency - 200;
        if (currency < 10) {
            firstButton.setDisable(true);
        }
        if (currency < 200) {
            secondButton.setDisable(true);
        }
        if (currency < 5000) {
            thirdButton.setDisable(true);
        }
        outputLabel.setText(""+currency);
        model.drawSecond(gc, image2);
        int secondCount = model.getSecondCount();
        secondCountLabel.setText(""+secondCount);
        int pageNumber = model.getPage();
        pageLabel.setText("Page "+pageNumber);
    }

    /**
     * subtracts 5000 currency, if currency is lower than 5000 it disables the button, displays currency and page number
     * @param event clicking the thirdButton
     */
    public void buyThird(ActionEvent event) {
        currency = currency - 5000;
        if (currency < 10) {
            firstButton.setDisable(true);
        }
        if (currency < 200) {
            secondButton.setDisable(true);
        }
        if (currency < 5000) {
            thirdButton.setDisable(true);
        }
        outputLabel.setText(""+currency);
        model.drawThird(gc, image3);
        int thirdCount = model.getThirdCount();
        thirdCountLabel.setText(""+thirdCount);
        int pageNumber = model.getPage();
        pageLabel.setText("Page "+pageNumber);
    }

    /**
     * This is where you create your components and the model and add event
     * handlers.
     *
     * @param stage The main stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 400, 225); // set the size here
        stage.setTitle("Assignment 5"); // set the window title here
        stage.setScene(scene);
        // TODO: Add your GUI-building code here

        // 1. Create the model
        // 2. Create the GUI components
        c = new Canvas(200,200);
        gc = c.getGraphicsContext2D();
        Button mainButton = new Button("Click");
        firstButton = new Button("Buy 1 for 10 currency");
        Label firstLabel = new Label("First Building +1 to click");
        secondButton = new Button("Buy 1 for 200 currency");
        Label secondLabel = new Label("Second Building +10 to click");
        thirdButton = new Button("Buy 1 for 5000 currency");
        Label thirdLabel = new Label("Third Building +100 to click");
        outputLabel = new Label(""+currency);
        nextClickLabel = new Label("Next Click: 1");
        firstCountLabel = new Label("");
        secondCountLabel = new Label("");
        thirdCountLabel = new Label("");
        pageLabel = new Label("Page 1");
        FileInputStream inputstream = new FileInputStream("week7/src/assignment5/assets/cat1-10px.gif"); 
        image = new Image(inputstream);
        FileInputStream inputstream2 = new FileInputStream("week7/src/assignment5/assets/cat2-10px.gif"); 
        image2 = new Image(inputstream2);
        FileInputStream inputstream3 = new FileInputStream("week7/src/assignment5/assets/cat3-10px.gif"); 
        image3 = new Image(inputstream3);
        // 3. Add components to the root
        root.getChildren().addAll(mainButton, outputLabel, nextClickLabel, pageLabel, firstLabel, firstButton, secondLabel, secondButton, thirdLabel, thirdButton, firstCountLabel, secondCountLabel, thirdCountLabel, c);
        // 4. Configure the components (colors, fonts, size, location)
        gc.setFill(Color.LIGHTBLUE);
        gc.fillRect(0,0,200,200);
        outputLabel.relocate(235, 155);
        nextClickLabel.relocate(265, 180);
        mainButton.relocate(220, 175);
        firstLabel.relocate(220, 10);
        firstButton.relocate(220, 25);
        firstCountLabel.relocate(350, 30);
        secondLabel.relocate(220, 50);
        secondButton.relocate(220, 65);
        secondCountLabel.relocate(357, 70);
        thirdLabel.relocate(220, 90);
        thirdButton.relocate(220, 105);
        thirdCountLabel.relocate(364, 110);
        pageLabel.relocate(75, 200);
        firstButton.setDisable(true);
        secondButton.setDisable(true);
        thirdButton.setDisable(true);
        // 5. Add Event Handlers and do final setup
        mainButton.setOnAction(this::buttonClick);
        firstButton.setOnAction(this::buyFirst);
        secondButton.setOnAction(this::buySecond);
        thirdButton.setOnAction(this::buyThird);
        // 6. Show the stage
        stage.show();
    }

    /**
     * Make no changes here.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
