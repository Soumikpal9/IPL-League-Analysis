package IPL.League.Analysis;

public class LeagueBatting {
	public static String pos;
	public static String player;
	public static int noOfMatches;
	public static int noOfInnings;
	public static int notOut;
	public static int runs;
	public static String highestScore;
	public static String average;
	public static int ballsFaced;
	public static double strikeRate;
	public static int century;
	public static int halfCentury;
	public static int noOfFours;
	public static int noOfSixes;
	
	public LeagueBatting() {}
	
	public LeagueBatting(String pos, String player, int noOfMatches, int noOfInnings, int notOut, int runs, String highestScore, String average, int ballsFaced, double strikeRate, int century, int halfCentury, int noOfFours, int noOfSixes) {
		this.pos = pos;
		this.player = player;
		this.noOfMatches = noOfMatches;
		this.noOfInnings = noOfInnings;
		this.notOut = notOut;
		this.runs = runs;
		this.highestScore= highestScore;
		this.average = average;
		this.ballsFaced = ballsFaced;
		this.strikeRate = strikeRate;
		this.century = century;
		this.halfCentury = halfCentury;
		this.noOfFours = noOfFours;
		this.noOfSixes = noOfSixes;
	}
}
