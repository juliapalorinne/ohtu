package ohtu.kivipaperisakset;

import java.util.Scanner;

public abstract class Peli {

    protected Scanner scanner;
    protected Tuomari tuomari;
    protected TekoalyIF tekoaly;
    protected String ekanSiirto;
    protected String tokanSiirto;
    
    public Peli() {
        scanner = new Scanner(System.in);
        tuomari = new Tuomari();
    }

    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
    
    
    public void pelaa() {

        System.out.println("Peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s.");
        ensimmaisenSiirto();        
        toisenSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            kirjaaSiirto();
            ensimmaisenSiirto();        
            toisenSiirto();            
            asetaSiirto();
        }

        lopetus();
    }
    
    
    protected void ensimmaisenSiirto() {
        System.out.println("Ensimmäisen pelaajan siirto: ");
        ekanSiirto = scanner.nextLine();
    }
    
    protected void toisenSiirto() {
        tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
    }

    protected void kirjaaSiirto() {
        tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
        System.out.println(tuomari);
        System.out.println();
    }
    
    protected void asetaSiirto() {
        tekoaly.asetaSiirto(ekanSiirto);
    }
    
    protected void lopetus() {
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    

    
}
