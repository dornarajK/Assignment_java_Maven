import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

private Image loadPetImage() {
    try {
        // Loads pent.png from the resources folder
        URL resource = getClass().getClassLoader().getResource("pent.png");
        assert resource != null;
        return ImageIO.read(resource);
    } catch (IOException e) {
        System.out.println("Could not load image: " + e.getMessage());
        return null;
    }
}

void main() {
}

