package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends Peli {
    
    
    @Override
    protected void toisenSiirto() {
        System.out.println("Toisen pelaajan siirto: ");
        tokanSiirto = scanner.nextLine();
    }
    
    @Override
    protected void asetaSiirto() {
        // ei tehd‰ mit‰‰n
    }

}