package edu.uob;

public class Triangle extends TwoDimensionalShape implements MultiVariantShape{
  int sideA;
  int sideB;
  int sideC;
  private TriangleVariant variant;
  int perimeter;
  static int triangleCounter = 0;


  public Triangle(int a, int b, int c, Colour colour) {
    this.sideA = a;
    this.sideB = b;
    this.sideC = c;
    super.setColour(colour);
    this.variant = determineVariant();
    this.perimeter = calculatePerimeterLength();
    Triangle.triangleCounter++;

  }

  public int getPopulation(){
    return Triangle.triangleCounter;
  }


  public int getLongestSide(){
    return Math.max(sideC, Math.max(sideA, sideB));
  }

  public String toString(){
    return "This is a " + super.getColour() +" Triangle with sides of length " + sideA + ", " + sideB + ", " + sideC;
  }


  @Override
  public TriangleVariant getVariant() {
    return this.variant;
  }
  

  private TriangleVariant determineVariant() {
    if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
      return TriangleVariant.ILLEGAL;
    }
    if ((long)sideA + sideB < sideC || (long)sideB + sideC < sideA || (long)sideC + sideA < sideB) {
      return TriangleVariant.IMPOSSIBLE;
    }
    if ((long)sideA + sideB == sideC || (long)sideB + sideC == sideA || (long)sideA + sideC == sideB) {
      return TriangleVariant.FLAT;
    }
    if (sideA == sideB && sideB == sideC) {
      return TriangleVariant.EQUILATERAL;
    }
    if (sideA == sideB || sideB == sideC || sideC == sideA) {
      return TriangleVariant.ISOSCELES;
    }
    if (isRightTriangle()) {
      return TriangleVariant.RIGHT;
    }
    return TriangleVariant.SCALENE;
  }

  private boolean isRightTriangle() {
    int[] sides = {sideA, sideB, sideC};
    java.util.Arrays.sort(sides);
    long aSquared = (long) sides[0] * sides[0];
    long bSquared = (long) sides[1] * sides[1];
    long cSquared = (long) sides[2] * sides[2];

    return aSquared + bSquared == cSquared;
  }



  @Override
  public double calculateArea() {
    return Math.sqrt(perimeter*(perimeter-sideA)*(perimeter-sideB)*(perimeter-sideC));
  }

  @Override
  public int calculatePerimeterLength() {
    return (sideA+sideB+sideC)/2;
  }
}
