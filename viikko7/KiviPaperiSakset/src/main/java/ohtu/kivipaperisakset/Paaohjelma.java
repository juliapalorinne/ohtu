package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Pelitehdas pelitehdas = new Pelitehdas();
    
    
    public static void main(String[] args) {
        
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmist� vastaan "
                    + "\n (b) teko�ly� vastaan"
                    + "\n (c) parannettua teko�ly� vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            Peli peli = pelitehdas.hae(vastaus);
            peli.pelaa();
        }

    }
}
