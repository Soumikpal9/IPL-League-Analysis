/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package IPL.League.Analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import com.google.gson.Gson;

import com.CSVBuilder.CSVBuilderFactory;
import com.CSVBuilder.CSVException;
import com.CSVBuilder.ICSVBuilder;

public class BattingAnalyser {
	ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
	
    public int loadCSVFilePath(Path path) throws LeagueException, CSVException {
    	try(Reader reader = Files.newBufferedReader(path)){
    		List<LeagueBatting> battingList = csvBuilder.getCSVFileList(reader, LeagueBatting.class);
    		return battingList.size();
    	}
    	catch(IOException e) {
			throw new LeagueException("File not found", LeagueException.ExceptionType.WRONG_CSV); 
		}
		catch(RuntimeException e) {
			throw new LeagueException("File internal data not valid", LeagueException.ExceptionType.WRONG_HEADER);
		}
		catch(CSVException e) {
			throw new LeagueException("Unable to parse", LeagueException.ExceptionType.UNABLE_TO_PARSE);
		}
    }
    
    public String getBattingAvgWiseSortedData(Path path) throws LeagueException, CSVException{
    	try(Reader reader = Files.newBufferedReader(path)){
    		List<LeagueBatting> battingList = csvBuilder.getCSVFileList(reader, LeagueBatting.class);
    		if(battingList == null || battingList.size() == 0) {
    			throw new LeagueException("No data present", LeagueException.ExceptionType.NO_LEAGUE_DATA);
    		}
    		Comparator<LeagueBatting> battingComparator = Comparator.comparing(batting -> batting.average);
    		this.sortDesc(battingList, battingComparator);
    		String sortedBattingData = new Gson().toJson(battingList);
    		return sortedBattingData;
    	}
    	catch(IOException e) {
			throw new LeagueException("File not found", LeagueException.ExceptionType.WRONG_CSV); 
		}
		catch(RuntimeException e) {
			throw new LeagueException("File internal data not valid", LeagueException.ExceptionType.WRONG_HEADER);
		}
		catch(CSVException e) {
			throw new LeagueException("Unable to parse", LeagueException.ExceptionType.UNABLE_TO_PARSE);
		}
    }

	private void sortDesc(List<LeagueBatting> battingList, Comparator<LeagueBatting> battingComparator) {
		for(int i = 0; i < battingList.size() - 1; i++) {
			for(int j = 0; j < battingList.size() -1 - i; j++) {
				LeagueBatting census1 = battingList.get(j);
				LeagueBatting census2 = battingList.get(j+1);
				if(battingComparator.compare(census1, census2) < 0) {
					battingList.set(j,  census2);
					battingList.set(j+1, census1);
				}
			}
		}
	}
}
