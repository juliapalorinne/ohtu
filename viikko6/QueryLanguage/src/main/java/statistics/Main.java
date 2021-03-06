package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
          
        
        QueryBuilder query = new QueryBuilder();
 
//        Matcher m1 = query.playsIn("NYR")
//                         .hasAtLeast(5, "goals")
//                         .hasFewerThan(10, "goals").build();
//
//        for (Player player : stats.matches(m1)) {
//            System.out.println( player );
//        }
        
        System.out.println("Matcher 1:");
        Matcher m1 = query.playsIn("PHI")
                  .hasAtLeast(10, "assists")
                  .hasFewerThan(5, "goals").build();
        
        for (Player player : stats.matches(m1)) {
            System.out.println( player );
        } 
        
        QueryBuilder query2 = new QueryBuilder();

        System.out.println("Matcher 2:");
        Matcher m2 = query2.playsIn("EDM")
                  .hasAtLeast(40, "points").build();

        for (Player player : stats.matches(m2)) {
            System.out.println( player );
        } 
        
        System.out.println("Matcher 0:");
        Matcher m = query.oneOf(m1, m2).build();
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }        
        
//        System.out.println("Matcher 3:");
//        Matcher m3 = new And(new PlaysIn("EDM"), 
//                new HasAtLeast(40, "points")                      
//        );
//        for (Player player : stats.matches(m3)) {
//            System.out.println( player );
//        } 
//        
//        System.out.println("Matcher 4:");
//        Matcher m4 = query.oneOf(m1, m3).build();
//        for (Player player : stats.matches(m4)) {
//            System.out.println( player );
//        }  
//      
        
        
//        System.out.println("Matcher 1:");
//        Matcher m1 = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );
//        
//        for (Player player : stats.matches(m1)) {
//            System.out.println(player);
//        }
        
//        System.out.println("Matcher 2:");
//        Matcher m2 = new And( 
//            new Not( new HasAtLeast(1, "goals") ), 
//            new PlaysIn("NYR")
//        );
//        
//        for (Player player : stats.matches(m2)) {
//            System.out.println(player);
//        }
//
//        System.out.println(stats.matches(new All()).size());

//        System.out.println("Matcher 3:");
//        Matcher m3 = new Or( new HasAtLeast(40, "goals"),
//                            new HasAtLeast(60, "assists")
//        );  
//        
//        for (Player player : stats.matches(m3)) {
//            System.out.println(player);
//        }
        
//        System.out.println("Matcher 4:");
//        Matcher m4 = new And(
//            new HasAtLeast(50, "points"),
//            new Or( 
//                new PlaysIn("NYR"),
//                new PlaysIn("NYI"),
//                new PlaysIn("BOS")
//            )
//        );
//        
//        for (Player player : stats.matches(m4)) {
//            System.out.println(player);
//        }

    }
}
        