package Q3FinalLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import core.data.*;

public class PlayerTester {
	public static void main (String[] args) {
		DataSource ds = DataSource.connect("src/Q3FinalLab/FantasyFootballStats2019.csv"); 
	    ds.setCacheTimeout(15 * 60);  
	    ds.load();
	    ds.printUsageString();
	    
	    ArrayList<Stats> allStats = ds.fetchList(Stats.class, "G", "Pass Yds", "Pass TD", "Int", "Rush Yds", "Rush TD", "Rec", "Rec Yds", "Rec TD", "FL", "2PC");
	    ArrayList<Player> allPlayers = ds.fetchList(Player.class, "Player", "Tm", "FantPos");
	    
	    for (int i=0; i<allPlayers.size(); i++) {
	    	allPlayers.get(i).setStats(allStats.get(i));
	    }
	    
	    for (int j=0; j<5; j++) {
	    	System.out.println(allPlayers.get(j));
	    }
	    
	    
	}
}
