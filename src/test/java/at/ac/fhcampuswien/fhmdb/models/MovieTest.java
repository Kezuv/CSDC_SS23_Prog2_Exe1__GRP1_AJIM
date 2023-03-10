package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testFilterByGenre() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));
        Movie movie2 = new Movie("Movie2", "", Collections.singletonList("Action, Thriller"));
        Movie movie3 = new Movie("Movie3", "", Collections.singletonList("Comedy"));
        Movie movie4 = new Movie("Movie4", "", Collections.singletonList("Action"));

        String genreToFilter = "Comedy";
        HomeController instance = new HomeController();
        assertTrue(instance.filterByGenre(movie1, genreToFilter));
        assertFalse(instance.filterByGenre(movie2, genreToFilter));
        assertTrue(instance.filterByGenre(movie3, genreToFilter));
        assertFalse(instance.filterByGenre(movie4, genreToFilter));
    }

    @Test
    public void testFilterByGenreNull() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));

        HomeController instance = new HomeController();

        assertTrue(instance.filterByGenre(movie1, null));
    }

    @Test
    public void testFilterByString() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("Drama, Comedy"));
        Movie movie2 = new Movie("Movie2", "An edge-of-your-seat adventure", Collections.singletonList("Action, Thriller"));
        Movie movie3 = new Movie("Movie3", "A laugh-out-loud comedy", Collections.singletonList("Comedy"));
        Movie movie4 = new Movie("Movie4", "An action-packed blockbuster", Collections.singletonList("Action"));

        String stringToFilter = "heart";
        HomeController instance = new HomeController();

        assertTrue(instance.filterByString(movie1, stringToFilter));
        assertFalse(instance.filterByString(movie2, stringToFilter));
        assertFalse(instance.filterByString(movie3, stringToFilter));
        assertFalse(instance.filterByString(movie4, stringToFilter));
    }

    @Test
    public void testFilterByStringEmpty() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("Drama, Comedy"));

        HomeController instance = new HomeController();

        assertTrue(instance.filterByString(movie1, ""));
    }

    /*
    @Test
    void movieListObject_descriptionCheck(){

    }

    @Test
    void movieListObject_titleCheck(){

    }

    @Test
    void movieListObject_genreCheck(){

    }



    @Test
    void filterByGenre() {
        List<Movie> inputList = new ArrayList<>();


    }
    */

    @Test
    void initializeMovies() {

    }
}