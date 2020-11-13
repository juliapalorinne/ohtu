
package ohtu;

public class Player implements Comparable {
    private String name;
    private String team;
    private String nationality;
    private Integer goals;
    private Integer assists;
    private Integer points;

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }    
    
    public void setPoints() {
        this.points = this.assists + this.goals;
    }    
    
    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public Integer getGoals() {
        return goals;
    }

    public Integer getAssists() {
        return assists;
    } 
    
    public Integer getPoints() {
        return points;
    } 
    
    @Override
    public String toString() {
         return name + ", team " + team + 
                 ", goals " + goals + ", assists " + assists;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Player) {
            Player p = (Player) o;
            int comparePoints = p.getPoints();
            return comparePoints-this.points;
        }
        return 0;
    }
      
}
