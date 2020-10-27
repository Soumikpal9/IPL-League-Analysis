package IPL.League.Analysis;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.CSVBuilder.CSVBuilderFactory;
import com.CSVBuilder.CSVException;
import com.CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;

import junit.framework.Assert;

public class AllRounderAnalyserTest {
	public static final String LEAGUE_BATTING_DATA = "Batsman.csv";
	public static final String LEAGUE_BOWLING_DATA = "Bowler.csv";
	
	ICSVBuilder csvBuilder;
	private AllRounderAnalyser allRounderAnalyser;
	private List<LeagueAllRounder> allRounderList;
	private List<LeagueBatting> battingList;
	private List<LeagueBowling> bowlingList;
	
    @Before
    public void initialize() throws LeagueException, CSVException, IOException {
    	csvBuilder = CSVBuilderFactory.createCSVBuilder();
    	allRounderAnalyser = new AllRounderAnalyser();
    	battingList = csvBuilder.getCSVFileList(Files.newBufferedReader(Paths.get(LEAGUE_BATTING_DATA)), LeagueBatting.class);
    	bowlingList = csvBuilder.getCSVFileList(Files.newBufferedReader(Paths.get(LEAGUE_BOWLING_DATA)), LeagueBowling.class);
    	allRounderList = allRounderAnalyser.getAllRounderPlayers(battingList, bowlingList);
    }
    
    @Test
    public void givenAllRounderData_ShouldReturnTopBattingAndBowlingAverages() throws LeagueException, CSVException, IOException {
    	try {
    		List<LeagueAllRounder> sortedAllRounderList = allRounderAnalyser.getBattingAndBowlingAvgWiseSortedData(allRounderList);
    		Assert.assertEquals("Harpreet Brar", sortedAllRounderList.get(0).player);
    	}
    	catch(LeagueException e) {}
    }
    
    @Test
    public void givenAllRounderData_ShouldReturnTopRunsAndWickets() throws LeagueException, CSVException, IOException {
    	try {
    		List<LeagueAllRounder> sortedAllRounderList = allRounderAnalyser.getRunsAndWicketsWiseSortedData(allRounderList);
    		Assert.assertEquals("Andre Russell", sortedAllRounderList.get(99).player);
    	}
    	catch(LeagueException e) {}
    }
}
