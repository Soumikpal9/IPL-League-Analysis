package IPL.League.Analysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

import com.CSVBuilder.CSVBuilderFactory;
import com.CSVBuilder.CSVException;
import com.CSVBuilder.ICSVBuilder;
import com.google.gson.Gson;

public class BowlingAnalyser {
	ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
	
    public int loadCSVFilePath(Path path) throws LeagueException, CSVException {
    	try(Reader reader = Files.newBufferedReader(path)){
    		List<LeagueBowling> bowlingList = csvBuilder.getCSVFileList(reader, LeagueBowling.class);
    		return bowlingList.size();
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
    
    public String getBowlingAvgWiseSortedData(Path path) throws LeagueException, CSVException{
    	try(Reader reader = Files.newBufferedReader(path)){
    		List<LeagueBowling> bowlingList = csvBuilder.getCSVFileList(reader, LeagueBowling.class);
    		if(bowlingList == null || bowlingList.size() == 0) {
    			throw new LeagueException("No data present", LeagueException.ExceptionType.NO_LEAGUE_DATA);
    		}
    		Comparator<LeagueBowling> bowlingComparator = Comparator.comparing(bowling -> bowling.average);
    		this.sortDesc(bowlingList, bowlingComparator);
    		String sortedBowlingData = new Gson().toJson(bowlingList);
    		return sortedBowlingData;
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
    
    public String getStrikeRateWiseSortedData(Path path) throws LeagueException, CSVException{
    	try(Reader reader = Files.newBufferedReader(path)){
    		List<LeagueBowling> bowlingList = csvBuilder.getCSVFileList(reader, LeagueBowling.class);
    		if(bowlingList == null || bowlingList.size() == 0) {
    			throw new LeagueException("No data present", LeagueException.ExceptionType.NO_LEAGUE_DATA);
    		}
    		Comparator<LeagueBowling> bowlingComparator = Comparator.comparing(bowling -> bowling.strikeRate);
    		this.sortDesc(bowlingList, bowlingComparator);
    		String sortedBowlingData = new Gson().toJson(bowlingList);
    		return sortedBowlingData;
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
    
    private void sortDesc(List<LeagueBowling> bowlingList, Comparator<LeagueBowling> bowlingComparator) {
		for(int i = 0; i < bowlingList.size() - 1; i++) {
			for(int j = 0; j < bowlingList.size() -1 - i; j++) {
				LeagueBowling census1 = bowlingList.get(j);
				LeagueBowling census2 = bowlingList.get(j+1);
				if(bowlingComparator.compare(census1, census2) < 0) {
					bowlingList.set(j,  census2);
					bowlingList.set(j+1, census1);
				}
			}
		}
	}
}
