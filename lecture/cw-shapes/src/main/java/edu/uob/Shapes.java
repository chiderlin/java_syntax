package edu.uob;

import edu.uob.Triangle;
import edu.uob.Circle;
import edu.uob.Rectangle;
import java.util.Random;


public class Shapes {

  private static int genRandomInt(){
    return new Random().nextInt(11); // range:0-10
  }

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

    TwoDimensionalShape[] shapes = new TwoDimensionalShape[100];
    Random random = new Random();
    int triangleCounter = 0;
    for(int i=0; i<shapes.length; i++){
      double rand = Math.random(); // generate random number between 0.0 and 1.0
      if(rand < 0.33){
        // create a Circle with a random radius between 1 and 10
        shapes[i] = new Circle(genRandomInt());
      } else if( rand < 0.66){
        // create a rectangle
        shapes[i] = new Rectangle(genRandomInt(), genRandomInt());
      } else {
        // create triangle
        shapes[i] = new Triangle(genRandomInt(),genRandomInt(),genRandomInt(), Colour.BLUE);
      }
//      System.out.println(shapes[i].toString());
      if(shapes[i] instanceof Triangle) triangleCounter++;
    }
    System.out.println("Total number of triangles:  " + triangleCounter);
    System.out.println("(Static) Total number of triangles:  " + (Triangle.getPopulation()-1)); // 一開始創的testTriangle不要算進來

    TwoDimensionalShape firstShape = shapes[0];
    System.out.println("original type: " + firstShape.toString());
    if(firstShape instanceof Triangle){ // using instanceof to avoid down-casting error
      Triangle firstTriangle = (Triangle) firstShape;
      TriangleVariant variant = (TriangleVariant) firstTriangle.getVariant();
      System.out.println("assume it's triangle: " + variant.toString());
    }

  }
}
