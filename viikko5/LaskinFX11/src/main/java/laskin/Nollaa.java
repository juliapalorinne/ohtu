
package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Nollaa extends Komento {
    private int edellinen;
    
    
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    
    @Override
    public void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        edellinen = sovellus.tulos();
        sovellus.nollaa();

        int laskunTulos = sovellus.tulos();
        
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }  

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
    }
}