package edu.uob;

import edu.uob.Triangle;
import edu.uob.Circle;
import edu.uob.Rectangle;


public class Shapes {

  public static void main(String[] args) {
    Triangle testTriangle = new Triangle(5,5,5, Colour.RED);
    long longestSide = testTriangle.getLongestSide();
    //    System.out.println("The longest side of the triangle is " + longestSide);
    String printString = testTriangle.toString();
    System.out.println(printString);
    TwoDimensionalShape shape;
    shape = new Circle(5);
    System.out.println(shape.toString());
    if(shape instanceof MultiVariantShape) System.out.println("(shape)The shape has multiple variants");
    else System.out.println("(shape)This shape has only one vavriant");
    

    shape = new Rectangle(6,6);
    System.out.println(shape.toString());
    //    shape.SetColor(Colour.RED);
    //    System.out.println(shape.getColor());

    if(testTriangle instanceof MultiVariantShape) System.out.println("(testTriangle) The shape has multiple variants");
    else System.out.println("(testTriangle)This shape has only one vavriant");

    System.out.println("triangle perimeter length: "+testTriangle.calculatePerimeterLength());
    System.out.println("triangle area: "+testTriangle.calculateArea());


  }
}
