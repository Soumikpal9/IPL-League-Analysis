package IPL.League.Analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.CSVBuilder.CSVException;
import com.google.gson.Gson;

public class AllRounderAnalyser {
	List<LeagueAllRounder> allRounderList = new ArrayList<>();
	
	public List<LeagueAllRounder> getAllRounderPlayers(List<LeagueBatting> battingList, List<LeagueBowling> bowlingList) {
		battingList.stream().forEach(batsman -> {
			LeagueBowling bowlers = bowlingList.stream()
					.filter(bowler -> bowler.player.equalsIgnoreCase(batsman.player)).findFirst()
					.orElse(null);
			if (bowlers != null) {
				allRounderList.add(new LeagueAllRounder(batsman.player, batsman.runs, bowlers.noOfWickets,
						batsman.average, bowlers.average));
			}
		});
		return allRounderList;
	}
	
	public String getattingAndBowlingAvgWiseSortedData(List<LeagueAllRounder> allRounderList) throws LeagueException, CSVException {
    	try{
    		if(allRounderList == null || allRounderList.size() == 0) {
    			throw new LeagueException("No data present", LeagueException.ExceptionType.NO_LEAGUE_DATA);
    		}
    		Comparator<LeagueAllRounder> allRounderComparator = Comparator.comparing(player -> player.avgRuns + player.avgWickets);
    		this.sortDesc(allRounderList, allRounderComparator);
    		String sortedAllRounderData = new Gson().toJson(allRounderList);
    		return sortedAllRounderData;
    	}
    	catch(RuntimeException e) {
			throw new LeagueException("File internal data not valid", LeagueException.ExceptionType.WRONG_HEADER);
		}
    }
	
	private void sortDesc(List<LeagueAllRounder> allRounderList, Comparator<LeagueAllRounder> allRounderComparator) {
		for(int i = 0; i < allRounderList.size() - 1; i++) {
			for(int j = 0; j < allRounderList.size() -1 - i; j++) {
				LeagueAllRounder census1 = allRounderList.get(j);
				LeagueAllRounder census2 = allRounderList.get(j+1);
				if(allRounderComparator.compare(census1, census2) < 0) {
					allRounderList.set(j,  census2);
					allRounderList.set(j+1, census1);
				}
			}
		}
	}
}
