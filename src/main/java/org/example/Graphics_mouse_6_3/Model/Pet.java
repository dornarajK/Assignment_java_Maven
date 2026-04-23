package org.example.Graphics_mouse_6_3.Model;

public class Pet {
    private double x;
    private double y;
    private static final double Speed = 3.0;


    public Pet (double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX () {
         return x;
    }
    public double getY () {
        return y;
    }
    public void setX(double x) {
        this.x = x;

    }
    public void setY(double y) {
        this.y = y;
    }
    public double getSpeed(){
        return Speed;
    }

}
