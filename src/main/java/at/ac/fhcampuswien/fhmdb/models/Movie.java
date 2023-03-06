package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie implements Comparable<Movie>{
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres = new ArrayList<>();


    public Movie(String title, String description, List<String> genre) {
        this.title = title;
        this.description = description;
        for (int i = 0; i < genre.size(); i ++){
            this.genres.add(new Genre(genre.get(i)));
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
        List<String> genres = new ArrayList<>();
        genres.add("DRAMA"); genres.add("HORROR");
        movies.add(new Movie("THe Wahle", "A balde wüdsau", genres ));

        List<String> genreAvengers = new ArrayList<>();
        genreAvengers.add("ACTION"); genreAvengers.add("DRAMA"); genreAvengers.add("FANTASY");
        Movie avengersEndgame = new Movie("Avengers Endgame", "Last Marvel Movie of phase four", genreAvengers);
        movies.add(avengersEndgame);

        return movies;
    }
    @Override
    public int compareTo(Movie o) {
        return String.CASE_INSENSITIVE_ORDER.compare(this.title, o.getTitle());
    }
}
