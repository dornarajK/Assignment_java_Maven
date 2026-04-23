package org.example.Graphics_mouse_6_3.View;

import org.example.Graphics_mouse_6_3.Controller.PetController;
import org.example.Graphics_mouse_6_3.Model.Pet;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

public class PetView extends JPanel {
    private final Pet pet;
    private final Image petImage;
    private static final int PET_SIZE = 64;

    public PetView(Pet pet, PetController controller) {
        Image petImage1;
        this.pet = pet;
        setPreferredSize(new Dimension(700, 500));
        setBackground(new Color(210, 240, 220));


        petImage1 = loadPetImage();

        this.petImage = petImage1;
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                controller.setTarget(e.getX() - PET_SIZE / 2.0, e.getY() - PET_SIZE / 2.0);
            }
            @Override
            public void mouseDragged(MouseEvent e) {
                controller.setTarget(e.getX() - PET_SIZE / 2.0, e.getY() - PET_SIZE / 2.0);
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                controller.mouseExited();
            }
        });

        Timer timer = new Timer(16, e -> {
            controller.update();
            repaint();
        });
        timer.start();
    }

    private Image loadPetImage() {
        try {
            URL resource = getClass().getClassLoader().getResource("pent.png");
            if (resource == null) {
                System.err.println("pent.png not found on classpath.");
                return null;
            }
            return ImageIO.read(resource);
        } catch (IOException e) {
            System.err.println("Failed to load pent.png: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        drawBackground(g2);
        g2.setFont(new Font("SansSerif", Font.ITALIC, 13));
        g2.setColor(new Color(80, 120, 80));
        g2.drawString("Move your mouse to walk your pet!", 10, 20);

        g2.drawImage(petImage, (int) pet.getX(), (int) pet.getY(), PET_SIZE, PET_SIZE, this);
    }

    private void drawBackground(Graphics2D g2) {
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, new Color(220, 245, 225),
                0, h, new Color(180, 225, 190));
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);

        g2.setColor(new Color(160, 210, 170, 120));
        for (int x = 30; x < w; x += 60) {
            for (int y = 30; y < h; y += 60) {
                g2.fillOval(x, y, 8, 8);
            }
        }
    }


}