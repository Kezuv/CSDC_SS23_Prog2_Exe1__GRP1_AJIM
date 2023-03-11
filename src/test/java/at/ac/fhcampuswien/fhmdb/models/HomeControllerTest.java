package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeControllerTest {

    @Test
    public void FilterByString_with_Empty_String_To_Search() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("Drama, Comedy"));

        HomeController instance = new HomeController();

        assertTrue(instance.filterByString(movie1, ""));
    }

    @Test
    public void FilterByGenre_match_single_genre() {
        Movie movie1 = new Movie("Movie3", "", Collections.singletonList("Comedy"));


        String genreToFilter = "Comedy";
        HomeController instance = new HomeController();
        assertTrue(instance.filterByGenre(movie1, genreToFilter));
    }
    @Test
    public void FilterByGenre_no_match_single_genre() {
        Movie movie1 = new Movie("Movie4", "", Collections.singletonList("Action"));

        String genreToFilter = "Comedy";
        HomeController instance = new HomeController();
        assertFalse(instance.filterByGenre(movie1, genreToFilter));
    }

    @Test
    public void FilterByGenre_match_double_genre() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));

        String genreToFilter = "Comedy";
        HomeController instance = new HomeController();
        assertTrue(instance.filterByGenre(movie1, genreToFilter));
    }@Test
    public void FilterByGenre_no_match_double_genre() {
        Movie movie1 = new Movie("Movie2", "", Collections.singletonList("Action, Thriller"));

        String genreToFilter = "Drama";
        HomeController instance = new HomeController();

        assertFalse(instance.filterByGenre(movie1, genreToFilter));
    }
    @Test
    public void FilterByGenre_Null() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));

        HomeController instance = new HomeController();

        assertTrue(instance.filterByGenre(movie1, null));
    }
    /*
    @Test
    public void Filter_input_cleanup() {

        HomeController instance = new HomeController();
        String input = "Dr"'? %$§&><am+*!°^@;:a";

        assertEquals(instance.cleanString(input), "Drama"));
    }*/
}
