package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.lang.Throwable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

import at.ac.fhcampuswien.fhmdb.HomeController;

class MovieTest {

    @Test
    void when_title_is_null_IllegalArgumentException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String action = "ACTION";
            List<String> genre = new ArrayList<>();
            genre.add(action);
            // When
            Movie movie = new Movie(null, "This is a test for title 'null'.", genre);
        } );
        // Then
        assertEquals("Title cannot be null!", exception.getMessage());
    }

    @Test
    void when_description_is_null_IllegalArgumentException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String animation = "ANIMATION";
            List<String> genre = new ArrayList<>();
            genre.add(animation);
            // When
            Movie movie = new Movie("TestMovie", null, genre);
        } );
        // Then
        assertEquals("Description cannot be null!", exception.getMessage());
    }

    @Test
    void when_List_genre_is_null_NullPointerException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            // When
            Movie movie = new Movie("TestMovie", "This is a test movie.", null);
        } );
        // Then
        assertEquals("List cannot be null!", exception.getMessage());
    }

    @Test
    void when_List_genre_is_empty_NullPointerException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            List<String> genre = new ArrayList<>();
            // When
            Movie movie = new Movie("TestMovie", "This is a test movie.", genre);
        } );
        // Then
        assertEquals("List cannot be empty!", exception.getMessage());
    }

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