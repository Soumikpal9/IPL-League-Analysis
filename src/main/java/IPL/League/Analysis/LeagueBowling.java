package IPL.League.Analysis;

public class LeagueBowling {
	public static String pos;
	public static String player;
	public static int noOfMatches;
	public static int noOfInnings;
	public static double overs;
	public static int runs;
	public static int noOfWickets;
	public static int bbi;
	public static String average;
	public static double economy;
	public static String strikeRate;
	public static int fourWickets;
	public static int fiveWickets;
	
	public LeagueBowling() {}
	
	public LeagueBowling(String pos, String player, int noOfMatches, int noOfInnings, double overs, int runs, int noOfWickets, int bbi, String average, double economy, String strikeRate, int fourWickets, int fiveWickets) {
		this.pos = pos;
		this.player = player;
		this.noOfMatches = noOfMatches;
		this.noOfInnings = noOfInnings;
		this.overs = overs;
		this.runs =runs;
		this.noOfWickets = noOfWickets;
		this.bbi = bbi;
		this.average = average;
		this.economy = economy;
		this.strikeRate = strikeRate;
		this.fourWickets = fourWickets;
		this.fiveWickets = fiveWickets;
	}
}
