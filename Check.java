import java.util.Vector;
public class Check {
    int hodnota =0;
    static int hodnota2=0;
    static boolean tocisa =false;
    private static Vector vc = new Vector();
    public int checkC(int uhol){
        uhol+=0.20*(uhol/10);
        switch((uhol+5)/10){
            case(0):
                hodnota=0;
                break;
            case(1):
                hodnota=26;
                break;
            case(2):
                hodnota=3;
                break;
            case(3):
                hodnota=35;
                break;
            case(4):
                hodnota=12;
                break;
            case(5):
                hodnota=28;
                break;
            case(6):
                hodnota=7;
                break;
            case(7):
                hodnota=29;
                break;
            case(8):
                hodnota=18;
                break;
            case(9):
                hodnota=22;
                break;
            case(10):
                hodnota=9;
                break;
            case(11):
                hodnota=31;
                break;
            case(12):
                hodnota=14;
                break;
            case(13):
                hodnota=20;
                break;
            case(14):
                hodnota=1;
                break;
            case(15):
                hodnota=33;
                break;
            case(16):
                hodnota=16;
                break;
            case(17):
                hodnota=24;
                break;
            case(18):
                hodnota=5;
                break;
            case(19):
                hodnota=10;
                break;
            case(20):
                hodnota=23;
                break;
            case(21):
                hodnota=8;
                break;
            case(22):
                hodnota=30;
                break;
            case(23):
                hodnota=11;
                break;
            case(24):
                hodnota=36;
                break;
            case(25):
                hodnota=13;
                break;
            case(26):
                hodnota=27;
                break;
            case(27):
                hodnota=6;
                break;
            case(28):
                hodnota=34;
                break;
            case(29):
                hodnota=17;
                break;
            case(30):
                hodnota=25;
                break;
            case(31):
                hodnota=2;
                break;
            case(32):
                hodnota=21;
                break;
            case(33):
                hodnota=4;
                break;
            case(34):
                hodnota=19;
                break;
            case(35):
                hodnota=15;
                break;
            case(36):
                hodnota=32;
                break;

        }
        hodnota2=hodnota;
        return hodnota;
    }

    public void vect(Vector vc){ this.vc=vc;dajFarbu(); }
    public Vector dajFarbu(){ return vc; }
    public int dajHonodtu(){
        return hodnota2;
    }
    public void tocisSa(boolean tocisa){
        this.tocisa=tocisa;
    }
    public boolean onSaToci(){
        return tocisa;
    }
}
