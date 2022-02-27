package mx.uv.fiee.iinf.poo;

public class Rectangle implements Draw, Calculate, Comparable<Rectangle> {

    private final double height;
    private final double length;
    private int fillColor;
    private int drawColor;

    public Rectangle(double height, double length, int fillColor, int drawColor) {
        this.height = height;
        this.length = length;
        this.fillColor = fillColor;
        this.drawColor = drawColor;
    }

    @Override
    public double calculateArea() {
        return this.height * this.length;
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
    public int compareTo(Rectangle obj) {
        return Double.compare(this.calculateArea(), obj.calculateArea());
    }
}
