import java.awt.*;

public class Character extends GameObject {

    protected int velocityX, velocityY;

    public Character(Image image, int x, int y, int w, int h) {
        super(image, x, y, w, h);
    }

    @Override
    public void move() {
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    // Overloading
    public void setVelocity(int vx) {
        this.velocityX = vx;
    }

    public void setVelocity(int vx, int vy) {
        this.velocityX = vx;
        this.velocityY = vy;
    }
}