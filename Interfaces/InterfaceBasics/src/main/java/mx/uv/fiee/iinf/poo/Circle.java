package mx.uv.fiee.iinf.poo;

public class Circle implements Draw, Calculate, Comparable<Circle> {

    private final double radius;
    private int fillColor;
    private int drawColor;

    public Circle(double radius, int fillColor, int drawColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.drawColor = drawColor;
    }


    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void draw(int color) {
        drawColor = color;
    }

    @Override
    public void fill(int color) {
        fillColor = color;
    }

    @Override
    public int compareTo(Circle obj) {
        return Double.compare(this.calculateArea(), obj.calculateArea());
    }
}
