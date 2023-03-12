package at.ac.fhcampuswien.fhmdb.utilities;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DummyMovieListGenerator {

    private String pathWithMovieData;
    private List<String> readData = new ArrayList<>();



    private List<Movie> generatedMovieList = new ArrayList<>();


    public DummyMovieListGenerator(String pathWithMovieData) {
            this.pathWithMovieData = pathWithMovieData;
    }

    public void execute() throws IOException {
        readFile();
        for (int m = 1; m < readData.size() ; ){
            generateMovie();
            lineRemover();
        }
    }

    public boolean syntaxCheck() throws IOException {
        if (checkForNull() && checkForEnd() && checkForData()){
            return true;
        } else return false;
    }

    public boolean checkForNull() throws FileNotFoundException {
        FileReader fr = new FileReader(pathWithMovieData);
        BufferedReader br = new BufferedReader(fr);

        try {
            br.readLine().isEmpty();

        } catch (NullPointerException n){
            throw new NullPointerException("Source cannot be Null / Empty!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
    public boolean checkForEnd() throws IOException {
        FileReader fr = new FileReader(pathWithMovieData);
        BufferedReader br = new BufferedReader(fr);

        try {
            for (;;){
                String readLines = br.readLine();

                 if (readLines.equals("END")){
                     return true;
                    }
            }
        } catch (NullPointerException n){
            throw new NullPointerException("ERROR - Source needs to contain \"END\"");
        }
    }



    public boolean checkForData() throws IOException {
        FileReader fr = new FileReader(pathWithMovieData);
        BufferedReader br = new BufferedReader(fr);
        String readAllLines = "";

            for (;;){
                String readLines = br.readLine();

                if (readLines.equals("END")){
                    if (readAllLines.isEmpty()){
                        throw new IllegalArgumentException("Source contains no movie data.");
                    } return true;
                }
                readAllLines = readAllLines + readLines;
            }
    }


    public void readFile() throws IOException {

        if (syntaxCheck()){
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
        }
    }

    private List<String> generateGenreListForMovie(){
        List<String> genreOfThisMovie = new ArrayList<>();

        for (int line = 2; line < readData.size(); line ++) {
            if (readData.get(line).equals("")) {
                break;
            }
            genreOfThisMovie.add(readData.get(line));
        }
        return genreOfThisMovie;
    }

    private void generateMovie(){
        Movie movie;

        List<String> genreOfTheMovie = generateGenreListForMovie();

        movie = new Movie(readData.get(0), readData.get(1),
                genreOfTheMovie);

        generatedMovieList.add(movie);
    }

    private void lineRemover() {
        int lineCounter = 0;
        for (int l = lineCounter; l < readData.size() + 1; l++) {
            if (!readData.get(l).equals("")) {
                lineCounter++;
            } else {
                lineCounter++;
                for (int r = 0; r < lineCounter; r++) {
                    readData.remove(0);
                }
                break;
            }
        }
    }

    public List<Movie> getGeneratedMovieList() throws IOException {
        execute();
        return generatedMovieList;
    }

    public List<String> getReadData() {
        return readData;
    }

}
