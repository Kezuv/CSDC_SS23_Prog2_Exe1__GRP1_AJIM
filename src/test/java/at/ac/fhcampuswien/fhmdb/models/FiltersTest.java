package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import at.ac.fhcampuswien.fhmdb.utilities.Filters;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class FiltersTest {

    @Test
    public void FilterByString_with_Empty_String_To_Search() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("Drama, Comedy"));
        assertTrue(Filters.filterByString(movie1, ""));
    }

    @Test
    public void FilterByGenre_match_single_genre() {
        Movie movie1 = new Movie("Movie3", "", Collections.singletonList("Comedy"));
        String genreToFilter = "Comedy";
        assertTrue(Filters.filterByGenre(movie1, genreToFilter));
    }
    @Test
    public void FilterByGenre_no_match_single_genre() {
        Movie movie1 = new Movie("Movie4", "", Collections.singletonList("Action"));
        String genreToFilter = "Comedy";
        assertFalse(Filters.filterByGenre(movie1, genreToFilter));
    }

    @Test
    public void FilterByGenre_match_double_genre() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));
        String genreToFilter = "Comedy";
        assertTrue(Filters.filterByGenre(movie1, genreToFilter));
    }@Test
    public void FilterByGenre_no_match_double_genre() {
        Movie movie1 = new Movie("Movie2", "", Collections.singletonList("Action, Thriller"));
        String genreToFilter = "Drama";
        assertFalse(Filters.filterByGenre(movie1, genreToFilter));
    }
    @Test
    public void FilterByGenre_Null() {
        Movie movie1 = new Movie("Movie1","", Collections.singletonList("Drama, Comedy"));
        assertTrue(Filters.filterByGenre(movie1, null));
    }
    @Test
    public void Filter_input_cleanup() {
        String input = "Dr\"'?%$§&><am+*!°^@;:a";
        assertEquals("drama", Filters.cleanString(input));
    }
    @Test
    public void Filter_input_two_words() {
        String input = "Action";
        assertEquals("drama", Filters.cleanString(input));
    }
}
