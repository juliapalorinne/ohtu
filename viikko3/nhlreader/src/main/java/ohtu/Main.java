package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        
        ArrayList<Player> pelaajat = new ArrayList<>();
        
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                player.setPoints();
                pelaajat.add(player);
            }
        }
        Collections.sort(pelaajat);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        
        System.out.println("Players from FIN " + dtf.format(now));
        String[][] p = new String[pelaajat.size()][3];
        for (int i = 0; i < pelaajat.size(); i++) {
            Player pelaaja = pelaajat.get(i);
            p[i][0] = pelaaja.getName();
            p[i][1] = pelaaja.getTeam();
            p[i][2] = pelaaja.getGoals() + " + " + pelaaja.getAssists()
                    + " = " + pelaaja.getPoints();
            String[] s = p[i];
            System.out.format("%-22s%-8s%-15s\n", s);
        }
        
    }
  
}