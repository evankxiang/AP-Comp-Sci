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
    static final int WIDTH = 600;
    static final int HEIGHT = 600;
    int NUMSEGMENTS = 1200;
    static Scanner input = new Scanner(System.in);
    static final double INCREMENT = 0.1;
    static int aval;
    static int bval;
    static int cval;
    public static void main(String[] args)
    {

        Parabola canvas = new Parabola(WIDTH, HEIGHT);
        canvas.drawAxes();
        canvas.getInput();
        canvas.drawParabola();
    }

    //
    void getInput()
    {
        drawString("Standard form of the Quadratic is " + "ax^2+bx+c", 20,30);
        drawString("Remember to go to console for your inputs!",20,10);
        drawString("A:" + a, 20,50);
        drawString("B: " + b, 50,50);
        drawString("C: " + c, 80,50);
        drawString("Your Equation Is: " + a + "x^2+" + b + "x+" + c,20,70);
        System.out.println("What is your LE?");
        aval = Integer.parseInt(input.nextLine());
        System.out.println("What is your B value?");
        bval = Integer.parseInt(input.nextLine());
        System.out.println("What is your C value?");
        cval = Integer.parseInt(input.nextLine());
    }

    //
    void drawAxes()
    {
        for(int x = 1;x<=10000;x+=20)
            drawLine(x, 300, x+20, 300);
        for(int y = 1;y<=10000;y+=20)
            drawLine(300,y,300,y+20);
    }

    static int worldToScreenX(double x)
    {
        int screenX = (int) (WIDTH/2 * x) + WIDTH/2;
        return screenX;
    }

    static int worldToScreenY(double y)
    {
        int screenY =  (int) (WIDTH/2 * y) + WIDTH/2;
        return screenY;
    }
    static double f1(double x){
        double yval;
        yval = aval*Math.pow(x,2.0)+bval*x+cval;
        return yval;
    }
    void drawParabola()
    {
        for(double i = -1.0;i<=1.0;i+=INCREMENT){
            putPixel(worldToScreenX(i), worldToScreenY(f1(i)));
        }
        }
            
    


    Parabola(int width, int height)
    {
        super(width, height);
    }

    // draw an arc centered at unit (x, y) from angle 0.0 to "angle" (radians)
    void drawArc(double x, double y, double angle, double length)
    {
    }

    // use this for keyPress input
    public void keyPressed(int code)
    {
        if(code==65)
            System.out.println("HELLO");
        else System.out.println(code);
    }

    // use this for mouse input
    public void mousePressed(int x, int y)
    {
        System.out.println("HI");
        if (x >= 200 && x <= 350)
            fillRect(x, y, 25, 15);
    }

}
