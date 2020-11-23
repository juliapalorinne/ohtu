
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5,
                            OLETUSKASVATUS = 5;
    
    private int kasvatuskoko;
    private int[] taulukko;
    private int alkioidenLkm;

    
    public IntJoukko() {
        luoUusiTaulukko(KAPASITEETTI);
        this.kasvatuskoko = OLETUSKASVATUS;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        luoUusiTaulukko(kapasiteetti);
        this.kasvatuskoko = OLETUSKASVATUS;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");
        }
        luoUusiTaulukko(kapasiteetti);
        this.kasvatuskoko = kasvatuskoko;
    }
    
    private void luoUusiTaulukko(int kapasiteetti) {
        taulukko = new int[kapasiteetti];
        for (int i = 0; i < taulukko.length; i++) {
            taulukko[i] = 0;
        }
        alkioidenLkm = 0;
    }

    public boolean lisaa(int luku) {
        if (alkioidenLkm == 0) {
            taulukko[0] = luku;
            alkioidenLkm++;
            return true;
        }
        if (!lukuOnTaulukossa(luku)) {
            taulukko[alkioidenLkm] = luku;
            alkioidenLkm++;
            if (alkioidenLkm == taulukko.length) {
                int[] uusiTaulukko = new int[taulukko.length+kasvatuskoko];
                kopioiTaulukko(taulukko, uusiTaulukko);
                taulukko = uusiTaulukko;
            }
            return true;
        }
        return false;
    }

    public boolean lukuOnTaulukossa(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                return true;
            }
        }
        return false;
    }

    
    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == taulukko[i]) {
                for (int j = i; j < alkioidenLkm-1; j++) {
                    taulukko[j] = taulukko[j+1];
                }
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int alkioidenLukumaara() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + taulukko[0] + "}";
        } else {
            String tulostus = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tulostus += taulukko[i];
                tulostus += ", ";
            }
            tulostus += taulukko[alkioidenLkm - 1];
            tulostus += "}";
            return tulostus;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = taulukko[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            yhdiste.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdiste.lisaa(bTaulu[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkaus.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            erotus.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotus.poista(bTaulu[i]);
        }
 
        return erotus;
    }
        
}
