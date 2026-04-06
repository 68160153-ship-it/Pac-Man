import java.awt.Image;
import java.util.Random;

public class Ghost extends Character {

    private char direction;
    private Random rand = new Random();

    public Ghost(Image img, int x, int y, int w, int h) {
        super(img, x, y, w, h);
    }

    @Override
    public void move() {
        // Polymorphism (behavior ต่างจาก Character)
        if (rand.nextInt(10) < 2) {
            int r = rand.nextInt(4);
            if (r == 0) setVelocity(2, 0);
            if (r == 1) setVelocity(-2, 0);
            if (r == 2) setVelocity(0, 2);
            if (r == 3) setVelocity(0, -2);
        }
        super.move();
    }
}