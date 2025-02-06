package assignment8;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/** 
 * Circle class, used to create, draw and change the color of the circles
 */
public class Circle {
    // x coordinate of the circle
    private double x;
    // y coordinate of the circle
    private double y;
    // size of the circle
    private double size;
    // color of the circle
    private Color color;

    /**
     * Setter for circle color
     * @param color the color of the circle
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter for the circle color
     * @return circle color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Constructor for circle takes:
     * @param x the x position of the circle
     * @param y the y position of the circle
     * @param size the size of the circle
     * @param color the color of the circle
     */
    public Circle(double x, double y, double size, Color color) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    /**
     * draw method to draw the circle of the canvas
     * @param gc Graphic Context
     */
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillOval(x,y,size,size);
    }
}
