import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.io.IOException;

public class Window extends JFrame {
    public void okno(int width, int height, int scale, Game game) {
        HUD hud = new HUD();
        Player pl = new Player();
        JFrame frame = new JFrame("Ruletka");
        try { frame.setIconImage(ImageIO.read(getClass().getResource("/ruleta.png")));
        } catch (IOException e) { e.printStackTrace(); }
        frame.setSize(width * scale, height * scale);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        hud.Buttony(frame);
        pl.btn(frame);
        frame.add(game);
        frame.setVisible(true);
    }
}

