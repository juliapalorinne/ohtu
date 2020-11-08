package ohtu.verkkokauppa;
import org.springframework.stereotype.Component;

@Component //("viitegeneraattori")
public class Viitegeneraattori implements ViitegeneraattoriIO {
    
    private int seuraava;
    
    public Viitegeneraattori(){
        seuraava = 1;    
    }
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
