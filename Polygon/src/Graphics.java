/*
    Name: Evan Xiang
    Due Date: December 5th, 2023
    Description: This program will draw a polygon each time a user clicks a point up to 20 vertices as defined by the project specifications. 
    Parallel/Partially filled arrays are used here, and a message is displayed upon reaching the 20 vertice limit.
    Tasks:
    1. Make the program protect against array out of bounds errors.  Thus if more than 20 vertices are selected, no new vertices are added and a message appears advising the user that no changes are made. 
    2. Add a "remove" button as a rectangle or an image. If that area is clicked, the most recent point is removed from the list and the polygon is redrawn. Protect against removing a point from an empty polygon.
    3. Add a "save" button as a rectangle or an image. If the user clicks on the “Save” button, the entire list is stored in a file called “polygon.txt,” where the file format is as follows: the first line of the file will be the number of vertices in the polygon and each line afterwards stores one (x,y) vertex pair.
 */
import cs.ssa.SSAWindow;
import java.io.FileWriter;
import java.io.IOException;
public class Graphics extends SSAWindow
{
    static int[] xList;
    static int[] yList;
    static int numVertices;
    static final int MAXVERTICES = 20;
    static final int BUTTON_WIDTH = 70;
    static final int BUTTON_HEIGHT = 35;
    static final int BUTTON_X = 10;
    static final int BUTTON_Y = 10;
    static boolean removeButtonClicked;
    static boolean saveButtonClicked;

    static final int VERTICES_LABEL_X = 10;
    static final int VERTICES_LABEL_Y = 60;

    static public void main(String[] args)
    {
        Graphics window = new Graphics(800, 600);
    }
    // Primary Drawing Function
    void drawAll()
    {
        clear();
        if (numVertices > 1) {
            for (int i = 0; i < numVertices - 1; i++) {
                drawLine(xList[i], yList[i], xList[i + 1], yList[i + 1]);
            }
            drawLine(xList[numVertices - 1], yList[numVertices - 1], xList[0], yList[0]);
        }
        if (numVertices == MAXVERTICES) {
            System.out.println("Maximum number of vertices reached!");
            drawString("MAX STRINGS REACHED, REMOVE TO REDRAW", BUTTON_X + 5, BUTTON_Y + 70);
        }
        drawButtons();
        drawVerticesLabel(); 
    }
    // Draws the buttons
    void drawButtons() {
        drawRect(BUTTON_X, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        drawString("Remove", BUTTON_X + 5, BUTTON_Y + 20);
        drawRect(BUTTON_X + BUTTON_WIDTH + 10, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        drawString("Save", BUTTON_X + BUTTON_WIDTH + 20, BUTTON_Y + 20);
    }
    // Draws the vertices label
    void drawVerticesLabel() {
        drawString("Vertices: " + numVertices, VERTICES_LABEL_X, VERTICES_LABEL_Y);
    }
    // Mouse Pressed Event
    public void mousePressed(int x, int y)
    {
        if (isRemoveButtonClicked(x, y)) {
            if (numVertices > 0) {
                numVertices--;
            }
        } else if (isSaveButtonClicked(x, y)) {
            savePolygonToFile();
        } else {
            xList[numVertices] = x;
            yList[numVertices] = y;
            numVertices++;
        }
        drawAll();
    }
    // Checks if the remove button is clicked
    boolean isRemoveButtonClicked(int x, int y) {
        return x >= BUTTON_X && x <= BUTTON_X + BUTTON_WIDTH && y >= BUTTON_Y && y <= BUTTON_Y + BUTTON_HEIGHT;
    }
    // Checks if the save button is clicked
    boolean isSaveButtonClicked(int x, int y) {
        return x >= BUTTON_X + BUTTON_WIDTH + 10 && x <= BUTTON_X + BUTTON_WIDTH + 10 + BUTTON_WIDTH && y >= BUTTON_Y && y <= BUTTON_Y + BUTTON_HEIGHT;
    }
    // Saves the polygon to a file(polygon.txt)
    void savePolygonToFile() {
        try {
            FileWriter writer = new FileWriter("polygon.txt");
            writer.write(Integer.toString(numVertices) + "\n");
            for (int i = 0; i < numVertices; i++) {
                writer.write(Integer.toString(xList[i]) + " " + Integer.toString(yList[i]) + "\n");
            }
            writer.close();
            System.out.println("Polygon saved to polygon.txt");
        } catch (IOException e) {
            System.out.println("Error saving polygon to file");
            e.printStackTrace();
        }
    }
    Graphics (int width, int height)
    {
        super(width, height);
        xList = new int[MAXVERTICES];
        yList = new int[MAXVERTICES];
        numVertices = 0;
        removeButtonClicked = false;
        saveButtonClicked = false;
    }
}
