package org.example.Graphics_mouse_6_3;

import org.example.Graphics_mouse_6_3.Controller.PetController;
import org.example.Graphics_mouse_6_3.Model.Pet;
import org.example.Graphics_mouse_6_3.View.PetView;

import javax.swing.*;

public class VirtualPetApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Pet pet = new Pet(300, 200);
            PetController controller = new PetController(pet);
            PetView view = new PetView(pet, controller);

            JFrame frame = new JFrame("🐱 Virtual Pet Walk");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(view);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}