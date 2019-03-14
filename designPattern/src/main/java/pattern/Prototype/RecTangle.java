package pattern.Prototype;

public class RecTangle extends Shape {
    public RecTangle(){
        type = "Rectangle";
    }
    @Override
    public void draw(){
        System.out.println("Inside Rectangle:draw() method.");
    }
}
