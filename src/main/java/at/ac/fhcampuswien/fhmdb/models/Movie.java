package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.utilities.DummyMovieListGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.IllegalArgumentException;

public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
    private List<Genre> genres = new ArrayList<>();


    public Movie(String title, String description, List<String> genre) {
        try {
            if (!title.equals("")) {
                this.title = title;
            } else {
                throw new IllegalArgumentException("Title cannot be empty!");
            }
            if (!description.equals("")) {
                this.description = description;
            } else {
                throw new IllegalArgumentException("Description cannot be empty!");
            }
                if (!genre.isEmpty()) {
                    for (int i = 0; i < genre.size(); i++) {
                        this.genres.add(new Genre(genre.get(i)));
                    }
                } else {
                    throw new IllegalArgumentException("Genres cannot be empty!");
                }
        } catch (NullPointerException n){
            throw new NullPointerException("Title, description or genres cannot be null!");
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

    public static List<Movie> initializeMovies() throws IOException {

        List<Movie> movies = new ArrayList<>();
        DummyMovieListGenerator generator = new DummyMovieListGenerator("src/main/resources/at/ac/fhcampuswien/fhmdb/DummyData/DummyMovies");
        movies.addAll(generator.getGeneratedMovieList());

        return movies;
    }
    @Override
    public int compareTo(Movie o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.title, o.getTitle());
    }
}
