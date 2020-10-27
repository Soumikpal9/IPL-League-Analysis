package IPL.League.Analysis;

public class LeagueException extends Exception {
	enum ExceptionType{
		WRONG_CSV, WRONG_TYPE, WRONG_HEADER, UNABLE_TO_PARSE, NO_LEAGUE_DATA;
	}
	
	ExceptionType type;
	
	public LeagueException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}
}
