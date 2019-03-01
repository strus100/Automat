import java.util.*;

public class Main {
    public static int[] monety = {10, 6, 7, 0, 0, 0, 0, 0, 0};


    public static void main(String[] args) {
        int[] nominaly = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        Double resztaD;

        Scanner s = new Scanner(System.in);

        while (true) {
            Boolean guard = true;
            System.out.println("Podaj resztę do wydania");
            resztaD = s.nextDouble();
            for (int i = 0; i < nominaly.length; i++) {
                LinkedList sym = symulacja(i, resztaD, nominaly);
                for (int j = 0; j < sym.size(); j++) {
                    if ((int) sym.get(j) <= monety[j + i]) {

                        if (j == sym.size() - 1 && guard == true) {
                            System.out.println("Mamy wynik");
                            wydaj(i,nominaly,resztaD,sym);
guard = false;
                            //tutaj wykonaj wydanie reszty
                        }
                    }
                }
            }
        }

    }

    public static LinkedList symulacja(int j, double resztaD, int[] nominaly) {
        int reszta = (int) (resztaD * 100);
        LinkedList symulacja = new LinkedList<Integer>();
        int i = 0;
        reszta = (int) (resztaD * 100);

        for (i = j; ((i < nominaly.length) && (reszta > 0)); i++) {
            if (reszta >= nominaly[i]) {
                //ilość konkretnych monet
                int temp = (int) Math.floor(reszta / nominaly[i]);
                symulacja.add(temp);

                reszta = Math.round(100 * (reszta - (temp * nominaly[i]))) / 100;
            } else {
                symulacja.add(0);
            }

        }
        return symulacja;
    }

    public static void wydaj(int numerMonety, int[] nominaly, Double resztaD, LinkedList sym) {

        String wynik = "";

        for (int i = 0; i < sym.size(); i++) {

            System.out.println("Ilość monet: " + monety[numerMonety + i] + " Ilość do usunięcia: " + sym.get(i));
               monety[numerMonety + i] = monety[numerMonety + i] - (int)sym.get(i);
                wynik += (nominaly[numerMonety + i] / 100.0) + " PLN x " + sym.get(i) + "\n";


        }
        System.out.println(wynik);
    }
}