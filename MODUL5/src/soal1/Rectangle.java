package soal1;

public class Rectangle extends Shape {
    private double width;
    private double lenght;

    public Rectangle(double w, double l){
        super("Rectangle");
        width = w;
        lenght = l;
    }

    public double area(){
        return width * lenght;
    }

    public String toString(){
        return super.toString() + " with width " + width + " and lenght " + lenght;
    }
    
}