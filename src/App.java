import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {

        int rowCount = 21;
        int columnCount = 19;
        int tileSize = 32;

        int boardWidth = columnCount * tileSize;
        int boardHeight = rowCount * tileSize;

        JFrame frame = new JFrame("Pac Man");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 🔥 เริ่มที่หน้า Start
        StartScreen start = new StartScreen(frame);
        frame.add(start);

        frame.setVisible(true);
    }
}