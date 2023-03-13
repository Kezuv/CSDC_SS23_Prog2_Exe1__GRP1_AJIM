package at.ac.fhcampuswien.fhmdb.utilities;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.utilities.Filters;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class FiltersTests {
    // Testing cleanString
    @Test
    void cleanString_removes_special_characters_without_Space() {
        String input = "dr\"'?%$§&><am+*!°^@;:a";
        assertEquals("drama", Filters.cleanString(input));
    }

    @Test
    void cleanString_keep_space_character() {
        String input = "i want some coffee";
        assertEquals("i want some coffee", Filters.cleanString(input));
    }

    @Test
    void cleanString_uppercase_to_lowercase(){
        String input = "I WANT SOME COFFEE";
        assertEquals("i want some coffee", Filters.cleanString(input));
    }

    @Test
    void cleanString_keep_numbers(){
        String input = "1354846218462118";
        assertEquals("1354846218462118", Filters.cleanString(input));
    }

    @Test
    void cleanString_filtering_right_with_all_cases(){
        String input = "I%&/ Wa*'`?`=nT 1$%0§\"0\" CéoFfEe$S!!";
        assertEquals("i want 100 coffees", Filters.cleanString(input));
    }

    //Testing filterByString
    @Test
    void filterByString_matches_by_Title(){
        Movie movie1 = new Movie("TestTitle","-", Collections.singletonList("COMEDY"));
        assertTrue(Filters.filterByString(movie1, "stTit"));
    }

    @Test
    void filterByString_matches_by_description(){
        Movie movie1 = new Movie("-","TestDescription", Collections.singletonList("COMEDY"));
        assertTrue(Filters.filterByString(movie1, "stDes"));
    }

    @Test
    void filterByString_matches_not_by_Title(){
        Movie movie1 = new Movie("TestTitle","-", Collections.singletonList("COMEDY"));
        assertFalse(Filters.filterByString(movie1, "no matches"));
    }

    @Test
    void filterByString_matches_not_by_description(){
        Movie movie1 = new Movie("-","TestDescription", Collections.singletonList("COMEDY"));
        assertFalse(Filters.filterByString(movie1, "no matches"));
    }

    @Test
    void filterByString_matches_by_empty_stringToFilter(){
        Movie movie1 = new Movie("TestTitle","TestDescription", Collections.singletonList("COMEDY"));
        assertTrue(Filters.filterByString(movie1, ""));
    }

    //Testing filterByGenre
    @Test
    void filterByGenre_matches_with_empty_searchString() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("DRAMA, COMEDY"));
        assertTrue(Filters.filterByGenre(movie1, ""));
    }

    @Test
    void filterByGenre_matches_by_movie_with_one_genre() {
        Movie movie1 = new Movie("Movie3", "-", Collections.singletonList("COMEDY"));
        String genreToFilter = "COMEDY";
        assertTrue(Filters.filterByGenre(movie1, genreToFilter));
    }

    @Test
    void filterByGenre_no_match_single_genre() {
        Movie movie1 = new Movie("Movie4", "-", Collections.singletonList("ACTION"));
        String genreToFilter = "COMEDY";
        assertFalse(Filters.filterByGenre(movie1, genreToFilter));
    }

    @Test
    void filterByGenre_matches_by_movie_with_more_than_one_genre() {
        Movie movie1 = new Movie("Movie1","-", Collections.singletonList("DRAMA, COMEDY"));
        String genreToFilter = "COMEDY";
        assertTrue(Filters.filterByGenre(movie1, genreToFilter));
    }

    @Test
    void filterByGenre_matches_not_by_movie_with_more_than_one_genre() {
        Movie movie1 = new Movie("Movie2", "-", Collections.singletonList("ACTION, THRILLER"));
        String genreToFilter = "DRAMA";
        assertFalse(Filters.filterByGenre(movie1, genreToFilter));
    }

    @Test
    void FilterByGenre_Null() {
        Movie movie1 = new Movie("Movie1","-", Collections.singletonList("DRAMA, COMEDY"));
        assertTrue(Filters.filterByGenre(movie1, null));
    }
}