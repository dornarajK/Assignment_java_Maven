package org.example.Graphics_mouse_6_3.Controller;

import org.example.Graphics_mouse_6_3.Model.Pet;

public class PetController {
    private final Pet pet;
    private double targetX = -1;
    private double targetY = -1;
    private boolean mouseOnCanvas = false;

    public PetController(Pet pet) {
        this.pet = pet;
    }

    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
        this.mouseOnCanvas = true;
    }

    public void mouseExited() {
        this.mouseOnCanvas = false;
    }

    public void update() {
        if (!mouseOnCanvas || targetX < 0) return;

        double dx = targetX - pet.getX();
        double dy = targetY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance < pet.getSpeed()) {
            pet.setX(targetX);
            pet.setY(targetY);
        } else {
            double ratio = pet.getSpeed() / distance;
            pet.setX(pet.getX() + dx * ratio);
            pet.setY(pet.getY() + dy * ratio);
        }
    }

    public boolean isMouseOnCanvas() { return mouseOnCanvas; }
    public double getTargetX() { return targetX; }
    public double getTargetY() { return targetY; }
}