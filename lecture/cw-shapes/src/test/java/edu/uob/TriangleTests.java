package edu.uob;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTests {

  private static void assertShapeVariant(TriangleVariant expectedType, Triangle shape) {
    assertEquals(expectedType, shape.getVariant(), "failed to classify " + shape + " as " + expectedType);
  }

  // Equilateral: all equal
  @Test
  void testEquilateral() {
    assertShapeVariant(TriangleVariant.EQUILATERAL, new Triangle(8, 8, 8, Colour.BLUE));
  }

  // Isosceles: any two equal
  @Test
  void testIsosceles() {
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(5, 5, 3, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(5, 3, 5, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(3, 5, 5, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(5, 5, 7, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(5, 7, 5, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ISOSCELES, new Triangle(7, 5, 5, Colour.BLUE));
  }

  // Scalene: all three different (but not special)
  @Test
  void testScalene() {
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(12, 14, 15, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(14, 12, 15, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(12, 15, 14, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(14, 15, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(15, 12, 14, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(15, 14, 12, Colour.BLUE));
  }

  // Right-angled: Pythagoras's theorem
  @Test
  void testRight() {
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(5, 12, 13, Colour.BLUE));
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(12, 5, 13, Colour.BLUE));
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(5, 13, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(12, 13, 5, Colour.BLUE));
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(13, 5, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.RIGHT, new Triangle(13, 12, 5, Colour.BLUE));
  }

  // Flat: two sides add up to the third
  @Test
  void testFlat() {
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(7, 7, 14, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(7, 14, 7, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(14, 7, 7, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(7, 9, 16, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(7, 16, 9, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(9, 16, 7, Colour.BLUE));
    assertShapeVariant(TriangleVariant.FLAT, new Triangle(16, 7, 9, Colour.BLUE));
  }

  // Impossible: two sides add up to less than the third
  @Test
  void testImpossible() {
    assertShapeVariant(TriangleVariant.IMPOSSIBLE, new Triangle(2, 3, 13, Colour.BLUE));
    assertShapeVariant(TriangleVariant.IMPOSSIBLE, new Triangle(2, 13, 3, Colour.BLUE));
    assertShapeVariant(TriangleVariant.IMPOSSIBLE, new Triangle(13, 2, 3, Colour.BLUE));
  }

  // Illegal: a side is zero
  @Test
  void testZero() {
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(0, 0, 0, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(0, 10, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(10, 0, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(10, 12, 0, Colour.BLUE));
  }

  // Illegal: a side is negative
  @Test
  void testNegative() {
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(-1, -1, -1, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(-1, 10, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(10, -1, 12, Colour.BLUE));
    assertShapeVariant(TriangleVariant.ILLEGAL, new Triangle(10, 12, -1, Colour.BLUE));
  }

  // Overflow: check that the program doesn't have overflow problems due to
  // using int, float or double. If there are overflow problems, the program will not say Scalene.
  @Test
  void testOverflow() {
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(1100000000, 1705032704, 1805032704, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(2000000001, 2000000002, 2000000003, Colour.BLUE));
    assertShapeVariant(TriangleVariant.SCALENE, new Triangle(150000002, 666666671, 683333338, Colour.BLUE));
    // data type choose "long" to avoid overflow issue, including condition for IMPOSSIBLE, FLAT and isRightTriangle function!
  }
}
