import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
public class Player implements ActionListener {
    private static double speed=-0.01,i=0.0,speed2;
    private BufferedImage sprite;
    private BufferedImage arrow;
    Random rd = new Random();
    Check check = new Check();
    Font myFont = new Font ("Agency FB", 1, 50);
    Font font = new Font("Agency FB",1,30);
    HUD hd = new HUD();
    static JButton btn = new JButton("Spin");
    public void player(BufferedImage img,BufferedImage mig){
        this.sprite=img;
        this.arrow=mig;
    }
    public void btn(JFrame frame){
        btn.setVisible(true);
        btn.setBounds(130,360,0,0);
        btn.setSize(100,40);
        btn.setBackground(Color.RED);
        btn.setFocusable(false);
        btn.setBorderPainted(false);
        btn.setFont(font);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                speed=5.99;
                speed2=0.0;

                btn.setEnabled(false);
                try {
                    Thread.sleep(rd.nextInt(2500)+1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                speed2=0.015;
            }
        });
        frame.add(btn);
    }

    public void tick(){
        if((speed-speed2)>0) {
            i += (speed -= speed2);
            check.tocisSa(true);
            if((Math.round((speed-speed2)*100)/100.0)==-0.01) {
                hd.winScreen();
                btn.setEnabled(true);
                check.tocisSa(false);
            }
        }
    }

    public void render(Graphics g){
        AffineTransform at = AffineTransform.getTranslateInstance(0,0);
        AffineTransform a = AffineTransform.getTranslateInstance(162,-10);
        at.rotate(Math.toRadians(+i),sprite.getWidth()/2,sprite.getHeight()/2);
        a.scale(0.05,0.05);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setColor(Color.RED);
        check.checkC((int)((i/360-((int)i/360))*365));
        g2d.drawImage(sprite,at,null);
        g2d.setColor(Color.WHITE);
        g2d.drawString(("speed: "+(Math.round((speed-speed2+0.01)*100)/100.0)),15,15);
        g2d.setFont(myFont);
        g2d.drawString(""+check.checkC((int)((i/360-((int)i/360))*365)),157,200);
        g2d.drawImage(arrow,a,null);
    }
    @Override
    public void actionPerformed(ActionEvent e) { }
}
