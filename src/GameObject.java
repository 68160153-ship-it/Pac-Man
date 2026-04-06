import java.awt.Image;

public abstract class GameObject implements Movable {
    protected int x, y, width, height;
    protected Image image;

    public GameObject(Image image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(java.awt.Graphics g);

    // Encapsulation (getter)
    public int getX() { return x; }
    public int getY() { return y; }
}