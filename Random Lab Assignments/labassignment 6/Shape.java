public abstract class Shape {
  public double length;
  public Shape() {
    this.length=0;
  }
  public Shape(double length) {
    this.length=length;
  }
  public void changeLength(double length) {
    this.length=length;
  }
  public double getLength() {
    return length;
  }
  public abstract double getArea();
  public abstract double getPerimeter();
}