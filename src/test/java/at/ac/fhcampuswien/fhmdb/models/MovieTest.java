package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MovieTest {

    @Test
    void getGenresToString_emptyList() {
        List<Genre> empty_genres_list = new ArrayList<>();
        String testGenreText = Movie.getGenresToString(empty_genres_list);
        assertEquals("",testGenreText);

    }

    @Test
    void getGenresToString_wrongList() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre ("actioN"));
        genres.add(new Genre ("Comedy"));
        genres.add(new Genre ("thriller"));
        String testGenreText = Movie.getGenresToString(genres);
        assertNotEquals("ACTION, COMEDY, THRILLER",testGenreText);
        //assertEquals();
    }

    @Test
    void getGenresToString_normalCase() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre ("ACTION"));
        genres.add(new Genre ("HORROR"));
        genres.add(new Genre ("DRAMA"));
        String testGenreText = Movie.getGenresToString(genres);
        assertEquals("ACTION, HORROR, DRAMA",testGenreText);
    }

    @Test
    void getGenresToString_oneGenre() {
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre ("ACTION"));
        String testGenreText = Movie.getGenresToString(genres);
        assertEquals("ACTION",testGenreText);
    }


    @Test
    void initializeMovies() {

    }
}