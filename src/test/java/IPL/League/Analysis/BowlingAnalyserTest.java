package IPL.League.Analysis;

import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.CSVBuilder.CSVException;
import com.google.gson.Gson;

import junit.framework.Assert;

public class BowlingAnalyserTest {
	public static final String LEAGUE_BOWLING_DATA = "Bowler.csv";
    
    private BowlingAnalyser bowlingAnalyser;
    
    @Before
    public void initialize() throws LeagueException, CSVException {
    	bowlingAnalyser = new BowlingAnalyser();
    }
    
    @Test
    public void givenBowlingData_EnsureNoOfRecordsMatches() throws LeagueException, CSVException {
    	int records = bowlingAnalyser.loadCSVFilePath(Paths.get(LEAGUE_BOWLING_DATA));
    	Assert.assertEquals(99, records);
    }
    
    @Test
    public void givenBowlingData_ShouldReturnTopBowlingAverages() throws LeagueException, CSVException {
    	try {
    		String sortedBowlingData = bowlingAnalyser.getBowlingAvgWiseSortedData(Paths.get(LEAGUE_BOWLING_DATA));
    		LeagueBatting[] bowlingList = new Gson().fromJson(sortedBowlingData, LeagueBatting[].class);
    		Assert.assertEquals("Krishnappa Gowtham", bowlingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBowlingData_ShouldReturnTopStrikeRates() throws LeagueException, CSVException {
    	try {
    		String sortedBowlingData = bowlingAnalyser.getStrikeRateWiseSortedData(Paths.get(LEAGUE_BOWLING_DATA));
    		LeagueBatting[] bowlingList = new Gson().fromJson(sortedBowlingData, LeagueBatting[].class);
    		Assert.assertEquals("Krishnappa Gowtham", bowlingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBowlingData_ShouldReturnTopEconomy() throws LeagueException, CSVException {
    	try {
    		String sortedBowlingData = bowlingAnalyser.getEconomyWiseSortedData(Paths.get(LEAGUE_BOWLING_DATA));
    		LeagueBatting[] bowlingList = new Gson().fromJson(sortedBowlingData, LeagueBatting[].class);
    		Assert.assertEquals("Ben Cutting", bowlingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
}
