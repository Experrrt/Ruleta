import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
public class HUD implements ActionListener{
    Check check = new Check();
    static JButton cervena = new JButton("RED");
    static JButton cierna = new JButton("BLACK");
    static JButton zelena = new JButton("Cigaretka");
    TextField tf = new TextField();
    private static Vector vc = new Vector();
    private static boolean vyhra =false;
    private static boolean vyhraZ =false;
    private static boolean koniec =false;
    private static int penaze =500;
    private static String bet;
    private static int lastBet;
    private static int betFinal;
    static int y;
     static int a;
    Font font = new Font ("TimesRoman", 1, 20);
    Font penazky = new Font ("Agency FB", 1, 25);
    Font win = new Font ("Agency FB", 1, 50);
    Color c = new Color(51, 51, 51);
    Color ciga = new Color(0xBA8A4D);
    ArrayList<Integer> VsetkyB = new ArrayList<>(Arrays.asList(26,35,28,29,22,31,20,33,24,10,8,11,13,6,17,2,4,15));
    ArrayList<Integer> VsetkyR = new ArrayList<>(Arrays.asList(3,12,7,18,9,14,1,16,5,23,30,36,27,34,25,21,19,32));

    public void Buttony(JFrame frame){
        cervena.setVisible(true);
        cervena.setBounds(550,300,0,0);
        cervena.setSize(100,40);
        cervena.setBackground(Color.RED);
        cervena.setBorderPainted(false);
        cervena.setFocusable(false);

        cervena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet =tf.getText();

                if(!bet.equals("")) {
                    vc.add('r');
                    check.vect(vc);
                    try {
                        if(Integer.parseInt(bet)>=0&&Integer.parseInt(bet)+betFinal<=penaze){betFinal += Integer.parseInt(bet);}
                    }catch (Exception ex){}
                    vyhra = false;
                    koniec = false;
                }
                }
        } );
        //
        cierna.setBounds(440,300,0,0);
        cierna.setSize(100,40);
        cierna.setBackground(Color.BLACK);
        cierna.setBorderPainted(false);
        cierna.setFocusable(false);

        cierna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet =tf.getText();
                if(!bet.equals("")) {
                    vc.add('b');
                    check.vect(vc);
                    try {
                        if(Integer.parseInt(bet)>=0&&Integer.parseInt(bet)+betFinal<=penaze){betFinal += Integer.parseInt(bet);}
                    }catch (Exception ex){}
                }
                }

        } );
        //
        zelena.setBounds(495,350,0,0);
        zelena.setSize(100,40);
        zelena.setBackground(ciga);
        zelena.setBorderPainted(false);
        zelena.setFocusable(false);

        zelena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bet =tf.getText();
                if(!bet.equals("")) {
                    vc.add('g');
                    check.vect(vc);
                    try {
                        if(Integer.parseInt(bet)>=0&&Integer.parseInt(bet)+betFinal<=penaze){betFinal += Integer.parseInt(bet);}
                    }catch (Exception ex){}
                }
            }

        } );
        //
        tf.setBounds(490,250,0,0);
        tf.setSize(50,23);
        tf.setBackground(Color.BLACK);
        tf.setForeground(Color.WHITE);
        tf.setBackground(c);
        //
        frame.add(cervena);
        frame.add(cierna);
        frame.add(tf);
        frame.add(zelena);
    }
    public void winScreen(){
        a=120;
        y=50;
        if(vc.size()>0&&betFinal>0) {
            if (VsetkyR.contains(check.dajHonodtu())&&vc.lastElement().equals('r')) {vyhra=true;koniec=true;}
            else if (VsetkyB.contains(check.dajHonodtu())&&vc.lastElement().equals('b')) {vyhra=true;koniec=true; }
            else if(check.dajHonodtu()==0&&vc.lastElement().equals('g')){vyhraZ=true;koniec=true;}
            else {vyhra=false;koniec=true;}
        }
        penaze();
    }
    public void penaze(){
            if (vyhra) {
                penaze+=betFinal;
            }
            else if(vyhraZ){
                penaze+=betFinal*13;
            }
            if (!vyhra) {
                penaze-=betFinal;
            }
            lastBet=betFinal;
            betFinal=0;
    }
    public void tick(){
        if(check.onSaToci()){cervena.setEnabled(false);cierna.setEnabled(false);zelena.setEnabled(false);vyhra = false;koniec = false;}else{cervena.setEnabled(true);cierna.setEnabled(true);zelena.setEnabled(true);}
    }
    public void render (Graphics g){
       Graphics2D g2d = (Graphics2D)g;
       g2d.setFont(font);

       g2d.setColor(Color.WHITE);
        g2d.setFont(font);
        g2d.drawString("Balance: "+penaze,565,30);
        g2d.drawString("Bet: "+betFinal,550,270);

        if(koniec) {
            if (vyhra) {
               g2d.setColor(Color.green);
               g2d.setFont(win);
               g2d.drawString("Win", 500, 175);
               if(a>=2){a-=2;}else{g2d.dispose();}
               if(y<=200){y++;}
                g2d.setFont(penazky);
               Color color = new Color(0,255,0,a);
               g2d.setColor(color);
               g2d.drawString("+$"+lastBet,640,y);

           }
           if (!vyhra) {
               g2d.setColor(Color.red);
               g2d.setFont(win);
               g2d.drawString("Loss", 500, 175);
               if(a>=2){a-=2;}else{g2d.dispose();}
               if(y<=200){y++;}
               g2d.setFont(penazky);
               Color color = new Color(255,0,0,a);
               g2d.setColor(color);
               g2d.drawString("-$"+lastBet,640,y);
           }

       }

    }
        @Override
    public void actionPerformed(ActionEvent e) {
    }
}
