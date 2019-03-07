import java.util.*;

public class Main {
    public static int[] monety =   {0,    0,    0,    0,   0,   0,   2,  6,  1,  0, 0, 0, 0,0,0};
    public static int[] nominaly = {50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1};

    public static void main(String[] args) {

        Double resztaD;

        Scanner s = new Scanner(System.in);

        while (true) {
            stanKasy();
            System.out.println("\nPodaj resztę do wydania");
            resztaD = s.nextDouble();

            wydajReszte(resztaD);

        }

    }


    public static void wydajReszte(Double resztaD){
//        Double kasa = 0.0;
//        for (int i = 0; i <nominaly.length ; i++) {
//           kasa += (nominaly[i] * monety[i]/100);
//        }

//        if(kasa >= resztaD) {
            Boolean guard = true;
            for (int i = 0; i < nominaly.length; i++) {
                if (guard){
                    LinkedList sym = symulacja(i, resztaD);
                    for (int j = 0; j < sym.size(); j++) {
                        if ((int) sym.get(j) <= monety[j + i]) {
                            if (j == sym.size() - 1) {
                                System.out.println("Mamy wynik");
                                wydaj(i, sym);
                                guard = false;
                                //tutaj wykonaj wydanie reszty
                            }
                        }
                    }
                }
                }
//        }
//        else
//            System.out.println("Brak gotówki przepraszamy");

    }
    public static LinkedList symulacja(int j, double resztaD) {
        int reszta = (int) (resztaD * 100);
        LinkedList symulacja = new LinkedList<Integer>();
        int i = 0;

        for (i = j; ((i < nominaly.length) && (reszta > 0)); i++) {
            if (reszta >= nominaly[i]) {
                //ilość konkretnych monet
                int temp = (int) Math.floor(reszta / nominaly[i]);

                if(temp <= monety[i]){
                    reszta = Math.round(100 * (reszta - (temp * nominaly[i]))) / 100;
                    symulacja.add(temp);
                }else{
                    symulacja.clear();
                    i = nominaly.length - 1;
                }


            } else {
                symulacja.add(0);
            }

        }
        return symulacja;
    }

    public static void wydaj(int numerMonety, LinkedList sym) {

        String wynik = "";

        for (int i = 0; i < sym.size(); i++) {

            System.out.println("Ilość monet: " + monety[numerMonety + i] + " Ilość do usunięcia: " + sym.get(i));
               monety[numerMonety + i] = monety[numerMonety + i] - (int)sym.get(i);
                wynik += (nominaly[numerMonety + i] / 100.0) + " PLN x " + sym.get(i) + "\n";
        }
        System.out.println(wynik);
    }

public static void stanKasy(){
    System.out.println("Stan kasy.");
    for (int i = 0; i <  monety.length; i++) {
        System.out.print("Ilość monet: " +  ((double)nominaly[i]/100) + " x " + monety[i] + " " );
    }
    }

    public static void podajMonety(){
//Dodawanie monet
        System.out.println("Wrzuć monetę lub podaj banknot");
    }
}