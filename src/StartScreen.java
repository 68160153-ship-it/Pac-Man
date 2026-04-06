import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JPanel {

    private Image bg;
    private JFrame frame;

    private Rectangle startArea = new Rectangle(195, 390, 196, 60);

    public StartScreen(JFrame frame) {
        this.frame = frame;

        setFocusable(true);

        // โหลดรูป
        bg = new ImageIcon(getClass().getResource("/images/start_bg.png")).getImage();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startArea.contains(e.getPoint())) {
                    startGame();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (startArea.contains(e.getPoint())) {
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
                } else {
                    setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }
                repaint(); // สำคัญมาก!
            }
        });
    }

    private void startGame() {
        frame.getContentPane().removeAll();

        pacman game = new pacman();
        frame.add(game);

        frame.revalidate();
        frame.repaint();
        game.requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);

        Point mouse = getMousePosition();
        if (mouse != null && startArea.contains(mouse)) {
            g.setColor(new Color(255, 255, 255, 60));
            g.fillRect(startArea.x, startArea.y, startArea.width, startArea.height);
        }

        g.setColor(Color.RED);

    }
}