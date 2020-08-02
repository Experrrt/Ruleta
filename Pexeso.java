import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pexeso {

    Scanner sc = new Scanner(System.in);
    int rozmer=4;
    int uhadnute =0;
    int [][] original = new int[rozmer][rozmer];
    int [][] pracovna = new int [rozmer][rozmer];
    String [] celyInput = new String[4];
    int pocetParov = rozmer*rozmer/2;

    private List<Integer> karty = new ArrayList<Integer>();

    public void generuj(){
        for (int i = 1; i < pocetParov+1; i++) {
            karty.add(i);
            karty.add(i);
        }
        Collections.shuffle(karty);
        int index=0;
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {

                original[i][j]=karty.get(index);
                index++;
            }
        }
    }
    public void hraciePole(){
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original.length; j++) {
                if (pracovna[i][j]==0){
                    System.out.print("#♦/");
                }
                else if(pracovna[i][j]==-1){
                    System.out.print(original[i][j]+"♦/");
                }
                else if(pracovna[i][j]==1){
                    System.out.print(original[i][j]+"♦/");
                }
            }
            System.out.println();
        }
    }
    public void hra(){
        this.generuj();
        hraciePole();
        while(uhadnute!=pocetParov){
            System.out.println("Zadajte hodnoty: ");
            String input = sc.nextLine();
            celyInput = input.split(",");
            if(celyInput.length==4){
                if(original[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])]==original[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])]){
                    if((Integer.parseInt(celyInput[0])!=Integer.parseInt(celyInput[2]))||(Integer.parseInt(celyInput[1])!=Integer.parseInt(celyInput[3]))) {
                        if ((pracovna[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])]!=1)&&(pracovna[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])]!=1)){
                            uhadnute++;
                            pracovna[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])] = 1;
                            pracovna[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])] = 1;
                        }
                    }
                    else{
                        System.out.println("Nemozes pouzit ten isty koordinat");
                    }
                    hraciePole();
                }
                else{
                    if((pracovna[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])]) !=1&& (pracovna[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])])!=1) {
                        pracovna[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])] = -1;
                        pracovna[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])] = -1;
                        hraciePole();
                        pracovna[Integer.parseInt(celyInput[0])][Integer.parseInt(celyInput[1])] = 0;
                        pracovna[Integer.parseInt(celyInput[2])][Integer.parseInt(celyInput[3])] = 0;
                    }
                    else{
                        System.out.println("Dane miesto si uz uhadol");
                    }
                }
                System.out.println("Uhadnute: "+uhadnute);
            }else{
                System.out.println("Nebol zadany spravny pocet koordinatov");
            }
        }
        System.out.println("Vyhral si");
    }

    public static void main(String[] args) {
        Pexeso px = new Pexeso();
        px.hra();
    }
}