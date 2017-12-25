public class Triangle extends Shape {
  public double length=super.length;
  public double height;
  public Triangle() {
    this.length=0;
    this.height=0;
  }
  public Triangle(double length, double height) {
    this.length=length;
    this.height=height;
  }
  public void changeHeight(double height) {
    this.height=height;
  }
  public double getHeight() {
    return height;
  }
  public double getArea() {
    return 0.5*length*height;
  }
  //pre:equilateral triangle
  //post:returns perimeter
  public double getPerimeter() {
    return length*3;
  }
  public static void main(String[]args) {
    Triangle t=new Triangle(10,5);
    System.out.println("Height: "+t.getHeight());
    System.out.println("Area: "+t.getArea());
    System.out.println("Perimeter: "+t.getPerimeter());
  }
}