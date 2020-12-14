
package ohtu.kivipaperisakset;


public class Lopetus extends Peli{
    
    public Lopetus() {
    }

    @Override
    public void pelaa() {
        System.out.println("Peli suljetaan.");
        System.exit(0);
    }

    
}
