package edu.uob;

public abstract class TwoDimensionalShape {
  private Colour colour;

  public Colour getColour(){
    return colour;
  }

  public void setColour(Colour colour){
    this.colour = colour;
  }

  public TwoDimensionalShape() {}

  public abstract double calculateArea();

  public abstract int calculatePerimeterLength();
}
