import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends JPanel {

    private Image bg;
    private JFrame frame;

    // 🎯 พื้นที่ปุ่ม (ปรับได้)
    private Rectangle startArea = new Rectangle(195, 390, 196, 60);

    public StartScreen(JFrame frame) {
        this.frame = frame;

        setFocusable(true);

        // โหลดรูป
        bg = new ImageIcon(getClass().getResource("/start_bg.png")).getImage();

        // 🖱️ คลิก
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (startArea.contains(e.getPoint())) {
                    startGame();
                }
            }
        });

        // 🖱️ hover + เปลี่ยน cursor + repaint
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

        // 🖼️ วาด background
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), null);

        // ✨ hover effect
        Point mouse = getMousePosition();
        if (mouse != null && startArea.contains(mouse)) {
            g.setColor(new Color(255, 255, 255, 60));
            g.fillRect(startArea.x, startArea.y, startArea.width, startArea.height);
        }

        // 🔴 DEBUG (เปิดไว้ก่อน ปรับตำแหน่งให้ตรงแล้วค่อยลบ)
        g.setColor(Color.RED);

    }
}