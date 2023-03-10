package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.utilities.DummyMovieListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres = new ArrayList<>();


    public Movie(String title, String description, List<String> genre) {
        if (title != null) {
            this.title = title;

        } else {
            throw new IllegalArgumentException("Title cannot be null!");
        }

        if (description != null) {
            this.description = description;

        } else {
            throw new IllegalArgumentException("Description cannot be null!");
        }

        if (genre.isEmpty() || genre != null) {
            for (int i = 0; i < genre.size(); i ++){
                this.genres.add(new Genre(genre.get(i)));
            }
        } else {
            throw new NullPointerException("List cannot be null or empty!");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }



    public static String getGenresToString(List<Genre> genres){

        String genresTotal = "";

        for (int g = 0 ; g < genres.size() ; g ++){
            if (genres.get(g) == genres.get(genres.size()-1)){
                genresTotal = genresTotal + genres.get(g).getKindOfGenre();
            } else {
                genresTotal = genresTotal + genres.get(g).getKindOfGenre() + ", ";
            }
        }
        return genresTotal;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();

        // Movie The Wahle
        /*List<String> genres = new ArrayList<>();
        genres.add("DRAMA"); genres.add("HORROR");
        movies.add(new Movie("THe Wahle", "A balde wüdsau", genres ));

        List<String> genreAvengers = new ArrayList<>();
        genreAvengers.add("ACTION"); genreAvengers.add("DRAMA"); genreAvengers.add("FANTASY");
        Movie avengersEndgame = new Movie("Avengers Endgame", "Last Marvel Movie of phase four", genreAvengers);
        movies.add(avengersEndgame);*/

        movies.addAll(DummyMovieListGenerator.execute("src/main/resources/at/ac/fhcampuswien/fhmdb/DummyData/DummyMovies"));

        return movies;
    }
    @Override
    public int compareTo(Movie o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.title, o.getTitle());
    }
}
