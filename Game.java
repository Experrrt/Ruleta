import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
    public static final int width =360,height=240,scale=2;
    public static boolean running = false;
    public Thread gameThread;
    private BufferedImage sprite;
    private BufferedImage arrow;
    private Player player;
    private HUD hd;
    public void init(){
        ImageLoader loader = new ImageLoader();
        sprite = loader.load("/ruletka.png");
        arrow = loader.load("/Pointer.png");
        player = new Player();
        player.player(sprite,arrow);
        hd = new HUD();
    }

    public synchronized void start(){
        if(running)return;
        running=true;
        gameThread = new Thread(this);
        gameThread.start();
    }
    public synchronized void stop(){
        if(!running)return;
        running=false;
        try {
            gameThread.join();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
    @Override
    public void run() {
        requestFocus();
        init();
        long lastTime = System.nanoTime();
        final double amoutOfTicks =60D;
        double ns = 1000000000/amoutOfTicks;
            double delta =0;
            while(running){
                long now = System.nanoTime();
                delta+=(now-lastTime)/ns;
                lastTime=now;
                if(delta>=1){
                    tick();
                    render();
                    delta--;
                }
            }
            stop();
        }
    public void tick(){
        player.tick();
        hd.tick();

    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs ==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //
        g.fillRect(0,0,width*scale,height*scale);
        player.render(g);
        hd.render(g);
        //
        g.dispose();
        bs.show();
    }
    public static void main(String[]args){
        Game game = new Game();
        game.setPreferredSize(new Dimension(width*scale,height*scale));
        Window window = new Window();
        window.okno(width,height,scale,game);
        game.start();
    }
}
