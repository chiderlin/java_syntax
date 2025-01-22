package edu.uob;

public enum TriangleVariant {
  EQUILATERAL, // 等邊
  ISOSCELES, // 等腰
  SCALENE, //不等邊
  RIGHT,// 直角
  FLAT, // 平面三角
  IMPOSSIBLE,//不可能組成三角
  ILLEGAL; // 非法三角形(0 or -)
}
