/*
    Name: Evan Xiang 
    Date:9/28/2023
    Description: Parabola Drawing Program - Project #1

*/

package parabola;

import cs.ssa.*;
import java.util.Scanner;

public class Parabola extends SSAWindow
{
    double a, b, c;
    double scale = 1.0/300; // 300 pixels = 1 unit
    int NUMSEGMENTS = 1200;
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    static int aval;
    static int bval;
    static int cval;
    static Scanner input = new Scanner(System.in);
    static final double INCREMENT = 0.001;
    public static void main(String[] args)
    {
        Parabola canvas = new Parabola(WIDTH, HEIGHT);
        canvas.drawParabola();
    }

    //method to get input from the user, intializes static variables(aval, bval, cval), prints/displays equations
    void getInput()
    {
        drawString("Standard form of the Quadratic is " + "ax^2+bx+c", 20,30);
        drawString("Remember to go to console for your inputs!",20,10);
        System.out.println("What is your LE?");
        aval = Integer.parseInt(input.nextLine());
        System.out.println("What is your B value?");
        bval = Integer.parseInt(input.nextLine());
        System.out.println("What is your C value?");
        cval = Integer.parseInt(input.nextLine());
        drawString("A:" + aval, 20,50);
        drawString("B: " + bval, 50,50);
        drawString("C: " + cval, 80,50);
        drawString("Your Equation Is: " + aval + "x^2+" + bval + "x+" + cval,20,70);
    }
    //draws the axes using a for loop for the X-axis and Y-axis
    void drawAxes()
    {
        for(int x = 1;x<=10000;x+=20)
            drawLine(x, 300, x+20, 300);
        for(int y = 1;y<=10000;y+=20)
            drawLine(300,y,300,y+20);
    }
    //converts unit coords on the cartesian plane to screen on X-axis
    static int worldToScreenX(double x)
    {
        int screenX = (int) (WIDTH/2 * x) + WIDTH/2;
        return screenX;
    }
    //converts unit coords on the cartesian plane to screen on Y-axis
    static int worldToScreenY(double y)
    {
        int screenY =  (int) (-HEIGHT/2 * y) + HEIGHT/2;
        System.out.println(screenY);
        return screenY;
    }
    //find the yval of every point using the standard form of the quadratic
    static double f1(double x){
        double yval;
        yval = aval*Math.pow(x,2.0)+bval*x+cval;
        return yval;
    }
    //calls all above methods needed and plots the points according to preset increment variable(0.01)
    void drawParabola()
    {
        drawAxes();
        getInput();
        for(double i = -1.0;i<=1.0;i+=INCREMENT){
            putPixel(worldToScreenX(i), worldToScreenY(f1(i)));
        }
    }
    Parabola(int width, int height)
    {
        super(width, height);
    }
}
