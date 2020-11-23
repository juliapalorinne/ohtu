package ohtu;

public class TennisGame {
    
    private String player1;
    private int score1 = 0;
    
    private String player2;
    private int score2 = 0;
    

    public TennisGame(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String player) {
        if (player.equals(player1))
            score1 += 1;
        else if (player.equals(player2))
            score2 += 1;
    }
    

    public String getScore() {
        if (score1 == score2)
            return tie();
        
        if (score1 >= 4 || score2 >= 4)
            return moreThanFourPoints();
        
        return scoreToString(score1) + "-" + scoreToString(score2);
    }
    
    
    public String tie() {        
        if (score1 == 0)
            return "Love-All";
         if (score1 == 1)
            return "Fifteen-All";
         if (score1 == 2)
            return "Thirty-All";
         if (score1 == 3)
            return "Forty-All";
         return "Deuce";
    }
    
    public String moreThanFourPoints() {        
        int difference = score1 - score2;
        if (difference == 1)
            return "Advantage " + player1;
        if (difference == -1)
            return "Advantage " + player2;
        if (difference > 1)
            return "Win for " + player1;
        return "Win for " + player2;
    }
    
    public String scoreToString(int thisScore) {        
        if (thisScore == 0)
            return "Love";
        if (thisScore == 1)
            return "Fifteen";
        if (thisScore == 2)
            return "Thirty";
        return "Forty";
    }
}