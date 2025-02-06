package assignment8;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class PlaySpace {
    // row of the playspace, used for row comparison in remove feature
    private int row;
    // column of the playspace, used for column comparison in remove feature
    private int column;
    // x position of the playspace
    private double x;
    // y position of the playspace
    private double y;
    // size of the playspace
    private double size;
    // color of the playspace
    private Color color;
    // canvas for the playspace to be clickable
    private Canvas canvas;
    // check for if the playspace contains a circle
    private boolean hasCircle;
    // Circle within the playspace
    private Circle circle;
    // selectNum tracker, used to keep track of what circle is being moved to which square
    public static int selectNum;
    // Graphic context
    private GraphicsContext gc;
    // used to keep track of current turn
    private int turn = 0;

    /**
     * Getter for row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter for column
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * Getter for has circle
     * @return hasCircle
     */
    public boolean HasCircle() {
        return hasCircle;
    }

    /**
     * Getter for color
     * @return color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Getter for canvas
     * @return canvas
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * Setter for has circle
     * @param hasCircle whether the playspace has a circle or not
     */
    public void setHasCircle(boolean hasCircle) {
        this.hasCircle = hasCircle;
    }

    /**
     * Constructor for playspace
     * @param row row of the playspace
     * @param column column of the playspace
     * @param x x position of the playspace
     * @param y y position of the playspace
     * @param size size of the playspace
     * @param color color of the playspace
     */
    public PlaySpace(int row, int column, double x, double y, double size, Color color) {
        this.row = row;
        this.column = column;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.canvas = new Canvas(size,size);
        this.canvas.relocate(x,y);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, this::pressHandler);
    }

    /**
     * Method to handle mouse clicks on a playspace. If select is not toggled on, on click draws a circle corresponding to the current turn.
     * If select is toggled on, the first click while save the circle color, and change the circle color to lime, then the second click while draw a circle with the save color in
     * the clicked playspace.
     * @param me
     */
    private void pressHandler(MouseEvent me) {
        // turn counter
        turn = FXGraphicsTemplate.getTurn();
        // Select Feature
        if (FXGraphicsTemplate.selectAndMove) {
            if (selectNum == 0 && hasCircle) {
                // first click
                FXGraphicsTemplate.psOne = this;
                Color circleColor = FXGraphicsTemplate.psOne.circle.getColor(); // saved color
                FXGraphicsTemplate.psOne.circle.setColor(Color.LIME);
                FXGraphicsTemplate.psOne.circle.draw(gc); // re draw circle with new color
                FXGraphicsTemplate.psOne.circle.setColor(circleColor); // set color back to original
                FXGraphicsTemplate.sMCLabel.setText("First has been selected");
                selectNum++;
            } else if (selectNum > 0 && !hasCircle) {
                // second click
                FXGraphicsTemplate.psTwo = this;
                FXGraphicsTemplate.sMCLabel.setText("First has been moved");
                Color circleColor = FXGraphicsTemplate.psOne.circle.getColor(); // saved color
                FXGraphicsTemplate.psTwo.circle = new Circle(x, y, size, circleColor);
                FXGraphicsTemplate.psTwo.circle.setColor(circleColor);
                FXGraphicsTemplate.psTwo.circle.draw(gc); // redraw circle in new position
                FXGraphicsTemplate.psTwo.setHasCircle(true); // set hasCircle to true
                FXGraphicsTemplate.psOne.draw(gc); // erase circle in old position
                FXGraphicsTemplate.psOne.setHasCircle(false); // set hasCircle to false
                selectNum = 0;
            }
        }
        if (!this.hasCircle && !FXGraphicsTemplate.selectAndMove) {
            if (turn == 0) {
                // player 1
                circle = new Circle(x,y,size,Color.AQUAMARINE);
                circle.draw(gc);
                FXGraphicsTemplate.playSpaces.add(this); // adds playspace to playspace array
                this.hasCircle = true;
                FXGraphicsTemplate.setTurn(1);
            } else if (turn == 1) {
                // player 2
                circle = new Circle(x,y,size,Color.rgb(224,17,95));
                circle.draw(gc);
                FXGraphicsTemplate.playSpaces.add(this); // adds playspace to playspace array
                this.hasCircle = true;
                FXGraphicsTemplate.setTurn(0);
            }
        }
}


    /**
     * draw method for playspace, draws the rectangle shape of the playspace.
     * @param gc Graphics context
     */
    public void draw(GraphicsContext gc) {
        this.gc = gc;
        gc.setFill(color);
        gc.fillRect(x,y,size,size);
    }
}
