
package ohtu.kivipaperisakset;

import java.util.HashMap;

public class Pelitehdas {

    private HashMap<String, Peli> komennot;
    private Peli tuntematon;

    public Pelitehdas() {
        komennot = new HashMap<>();
        komennot.put("a", new KPSPelaajaVsPelaaja());
        komennot.put("b", new KPSTekoaly());
        komennot.put("c", new KPSParempiTekoaly());
        tuntematon = new Lopetus();
    }

    public Peli hae(String peli) {
        return komennot.getOrDefault(peli, tuntematon);
    }
}
