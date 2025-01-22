package edu.uob;

import edu.uob.Triangle;
import edu.uob.Circle;
import edu.uob.Rectangle;


public class Shapes {

  public static void main(String[] args) {
    Triangle testTriangle = new Triangle(5,7,9, Colour.RED);
    long longestSide = testTriangle.getLongestSide();
    //    System.out.println("The longest side of the triangle is " + longestSide);
    String printString = testTriangle.toString();
    System.out.println(printString);
    TwoDimensionalShape shape;
    shape = new Circle(5);
    System.out.println(shape.toString());
    shape = new Rectangle(6,6);
    System.out.println(shape.toString());
    //    shape.SetColor(Colour.RED);
    //    System.out.println(shape.getColor());
    
    //    System.out.println("Hello world!");

  }
}
