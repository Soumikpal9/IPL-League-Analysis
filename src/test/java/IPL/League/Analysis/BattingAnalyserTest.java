/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package IPL.League.Analysis;

import org.junit.Test;

import com.CSVBuilder.CSVException;

import com.google.gson.Gson;

import junit.framework.Assert;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import org.junit.Before;

public class BattingAnalyserTest {
    public static final String LEAGUE_BATTING_DATA = "Batsman.csv";
    
    private BattingAnalyser battingAnalyser;
    
    @Before
    public void initialize() throws LeagueException, CSVException {
    	battingAnalyser = new BattingAnalyser();
    }
    
    @Test
    public void givenBattingData_EnsureNoOfRecordsMatches() throws LeagueException, CSVException {
    	int records = battingAnalyser.loadCSVFilePath(Paths.get(LEAGUE_BATTING_DATA));
    	Assert.assertEquals(100, records);
    }
    
    @Test
    public void givenBattingData_ShouldReturnTopBattingAverages() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getBattingAvgWiseSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("MS Dhoni", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnTopStrikeRates() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getStrikeRateWiseSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("Ishant Sharma", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnTopSixes() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getHighestSixWiseSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("Andre Russell", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnTopFours() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getHighestFourWiseSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("Shikhar Dhawan", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnHighestStrikeRateTopSixes() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getHighestSixWiseStrikeRateSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("Andre Russell", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnHighestStrikeRateTopFours() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getHighestFourWiseStrikeRateSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("Shikhar Dhawan", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnBattingAveragesTopStrikeRates() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getStrikeRateWiseBattingAverageSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("MS Dhoni", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenBattingData_ShouldReturnMaxRunsTopBattingAverages() throws LeagueException, CSVException {
    	try {
    		String sortedBattingData = battingAnalyser.getBattingAvgWiseMaxRunsSortedData(Paths.get(LEAGUE_BATTING_DATA));
    		LeagueBatting[] battingList = new Gson().fromJson(sortedBattingData, LeagueBatting[].class);
    		Assert.assertEquals("David Warner", battingList[0].player);
    	}
    	catch(LeagueException e) {}
    }
}
