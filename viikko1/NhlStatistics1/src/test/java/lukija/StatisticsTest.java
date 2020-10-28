package lukija;


import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    
    
    @Test
    public void teamPalauttaaOikeanListan() {
        List<Player> edm = new ArrayList<>();
        edm.add(new Player("Semenko", "EDM", 4, 12));
        edm.add(new Player("Kurri",   "EDM", 37, 53));
        edm.add(new Player("Gretzky", "EDM", 35, 89));
        
        String e = edm.toString();        
        assertEquals(e, stats.team("EDM").toString());
    }
    
    
    @Test
    public void topScorersPalauttaaOikeanListan() {
        ArrayList<Player> top = new ArrayList<>();
        top.add(new Player("Gretzky", "EDM", 35, 89));
        top.add(new Player("Lemieux", "PIT", 45, 54));
        
        String t = top.toString();        
        assertEquals(t, stats.topScorers(2).toString());
    }
    
    @Test
    public void searchPalauttaaOikeanPelaajan() {
        Player pelaaja = new Player("Yzerman", "DET", 42, 56);
        
        String p = pelaaja.toString();        
        assertEquals(p, stats.search("Yzerman").toString());
    }
    
    
    @Test
    public void searchEiPalautaMitaanVaarallaNimella() {    
        assertEquals(null, stats.search("Carlson"));
    }
}
