package IPL.League.Analysis;

public class LeagueAllRounder {
	public static String player;
	public static int runs;
	public static int wickets;
	public static String avgRuns;
	public static String avgWickets;
	
	public LeagueAllRounder() {}
	
	public LeagueAllRounder(String player, int runs, int wickets, String average, String average2) {
		this.player = player;
		this.runs = runs;
		this.wickets = wickets;
		this.avgRuns = average;
		this.avgWickets = average2;
	}
}
