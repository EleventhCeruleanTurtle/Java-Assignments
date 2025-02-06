package assignment5;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Assignment5 {
    // counter for x coordinate, used to draw new buildings at different x coordinates
    private int xcount = 0;
    // counter for y coordinate, used to draw new buildings at different y coordinates
    private int ycount = 0;
    // page number to keep track of how many pages have been created
    private int pageNumber = 1;
    // number of first buildings
    private int firstCounter= 0;
    // number of second buildings
    private int secondCounter = 0;
    // number of third buildings
    private int thirdCounter = 0;

    /**
     * getter for page number
     * @return pageNumber current page number
     */
    public int getPage() {
        return pageNumber;
    }

    /**
     * getter for number of first buildings
     * @return firstCounter number of first buildings
     */
    public int getFirstCount() {
        return firstCounter;
    }

    /**
     * getter for number of second buildings
     * @return secondCounter number of second buildings
     */
    public int getSecondCount() {
        return secondCounter;
    }

    /**
     * getter for number of third buildings
     * @return thirdCounter number of third buildings
     */
    public int getThirdCount() {
        return thirdCounter;
    }

    


    /**
     * draws the first building, checks if reached max x value, goes to new line in true, checks if reached max y value, created new page if true
     * @param gc graphics context
     * 
     */
    public void drawFirst(GraphicsContext gc, Image img) {
        if (xcount < 18) {
            gc.drawImage(img, 10*xcount+1*xcount, ycount);
            xcount++;
            firstCounter++;
        } else {
            if (ycount < 180) {
                ycount = ycount + 15;
                xcount = 0;
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                firstCounter++;
            } else {
                pageNumber++;
                ycount = 0;
                xcount = 0;
                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(0,0,200,200);
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                firstCounter++;
            }
            
        }
        
    }

    /**
     * draws the second building, checks if reached max x value, goes to new line in true, checks if reached max y value, created new page if true
     * @param gc graphics context
     */
    public void drawSecond(GraphicsContext gc, Image img) {
        if (xcount < 18) {
            gc.drawImage(img, 10*xcount+1*xcount, ycount);
            xcount++;
            secondCounter++;
        } else {
            if (ycount < 180) {
                ycount = ycount + 15;
                xcount = 0;
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                secondCounter++;
            } else {
                pageNumber++;
                ycount = 0;
                xcount = 0;
                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(0,0,200,200);
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                secondCounter++;
            }
            
        }
        
    }

    /**
     * draws the third building, checks if reached max x value, goes to new line in true, checks if reached max y value, created new page if true
     * @param gc graphics context
     */
    public void drawThird(GraphicsContext gc, Image img) {
        if (xcount < 18) {
            gc.drawImage(img, 10*xcount+1*xcount, ycount);
            xcount++;
            thirdCounter++;
        } else {
            if (ycount < 180) {
                ycount = ycount + 15;
                xcount = 0;
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                thirdCounter++;
            } else {
                pageNumber++;
                ycount = 0;
                xcount = 0;
                gc.setFill(Color.LIGHTBLUE);
                gc.fillRect(0,0,200,200);
                gc.drawImage(img, 10*xcount+1*xcount, ycount);
                xcount++;
                thirdCounter++;
            }
            
        }
        
    }

}
