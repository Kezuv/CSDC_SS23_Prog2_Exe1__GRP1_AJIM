package at.ac.fhcampuswien.fhmdb.utilities;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DummyMovieListGenerator {

    public static List<Movie> execute(String pathWithMovieData){
        List<Movie> finishedList = new ArrayList<>();

        List<String> readData = readFile(pathWithMovieData);

        for (int m = 1; m < readData.size() ; ){
            finishedList.add(generateMovie(readData));
            lineRemover(readData);
        }
        return finishedList;
    }

    /**
     * Read the text file and save every line in a list of strings until line "END"
     * @param pathWithMovieData path of the text file
     * @return List of String where each String is a line from text file (with line "END")
     */
    public static List<String> readFile(String pathWithMovieData) {
        List<String> readData = new ArrayList<>();
        try {
            FileReader fr = new FileReader(pathWithMovieData);
            BufferedReader br = new BufferedReader(fr);
            for (;;){
                String readLine = br.readLine();
                if (readLine.equals("END")){
                    readData.add(readLine);
                    break;
                }
                readData.add(readLine);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return readData;
    }

    /**
     * @param readData = List of Strings from @readFile method.
     * @return List of Strings wich contains all genres of the following movie.
     */
    public static List<String> generateGenreListForMovie(List<String> readData){
        List<String> genreOfThisMovie = new ArrayList<>();

        for (int line = 2; line < readData.size(); line ++) {
            if (readData.get(line).equals("")) {
                break;
            }
            genreOfThisMovie.add(readData.get(line));
        }
        return genreOfThisMovie;
    }

    /**
     * @param readData is the list from @readFile  method.
     * create an Object Movie with the readData data. Removes the used lines with the following blank line from txt.
     * @return generated Movie with the data.
     */
    public static Movie generateMovie(List<String> readData){
        Movie movie;

        List<String> genreOfTheMovie = generateGenreListForMovie(readData);

        movie = new Movie(readData.get(0), readData.get(1),
                genreOfTheMovie);


        return movie;
    }

    public static List<String> lineRemover(List<String> readData){
        int lineCounter = 0;
        for (int l = lineCounter; l < readData.size()+1 ; l ++){
            if (!readData.get(l).equals("")){
                lineCounter++;
            } else {
                lineCounter++;
                for ( int r = 0 ; r < lineCounter ; r ++){
                    readData.remove(0);
                }
                break;
            }
        }
        return readData;
    }
}
