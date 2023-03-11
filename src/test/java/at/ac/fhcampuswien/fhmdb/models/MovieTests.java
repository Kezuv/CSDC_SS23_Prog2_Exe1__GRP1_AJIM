package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import java.lang.Throwable;
import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

class MovieTests {



    @Test
    void MovieConstructor_when_title_is_empty_IllegalArgumentException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String action = "ACTION";
            List<String> genre = new ArrayList<>();
            genre.add(action);
            // When
            Movie movie = new Movie("", "This is a test for title 'null'.", genre);
        });
        // Then
        assertEquals("Title cannot be empty!", exception.getMessage());
    }

    @Test
    void MovieConstructor_when_description_is_empty_IllegalArgumentException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            String animation = "ANIMATION";
            List<String> genre = new ArrayList<>();
            genre.add(animation);
            // When
            Movie movie = new Movie("TestMovie", "", genre);
        });
        // Then
        assertEquals("Description cannot be empty!", exception.getMessage());
    }

    @Test
    void MovieConstructor_when_GenreList_is_empty_IllegalArgumentException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            List<String> genres = new ArrayList<>();
            // When
            Movie movie = new Movie("TestMovie", "This is a test movie.", genres);
        });
        // Then
        assertEquals("Genres cannot be empty!", exception.getMessage());
    }



    @Test
    void MovieConstructor_when_title_is_null_NullPointerException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            String action = "ACTION";
            List<String> genre = new ArrayList<>();
            genre.add(action);
            // When
            Movie movie = new Movie(null, "This is a test for title 'null'.", genre);
        });
        // Then
        assertEquals("Title, description or genres cannot be null!", exception.getMessage());
    }

    @Test
    void MovieConstructor_when_description_is_null_NullPointerException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            String action = "ACTION";
            List<String> genre = new ArrayList<>();
            genre.add(action);
            // When
            Movie movie = new Movie("Title", null, genre);
        });
        // Then
        assertEquals("Title, description or genres cannot be null!", exception.getMessage());
    }

    @Test
    void MovieConstructor_when_GenreList_is_null_NullPointerException_should_be_thrown() {
        // Given
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            // When
            Movie movie = new Movie("TestMovie", "This is a test movie.", null);
        });
        // Then
        assertEquals("Title, description or genres cannot be null!", exception.getMessage());
    }





    @Test
    void getGenresToString_with_empty_genreList_returns_empty_String() {
        List<Genre> empty_genres_list = new ArrayList<>();
        String testGenreText = Movie.getGenresToString(empty_genres_list);
        assertEquals("", testGenreText);
    }

    @Test
    void getGenreToString_with_genreList_with_one_entry(){
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre("ACTION"));
        String testGenreText = Movie.getGenresToString(genres);
        assertEquals("ACTION", testGenreText);
    }

    @Test
    void getGenreToString_with_genreList_with_more_than_one_entry(){
        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre("ACTION"));
        genres.add(new Genre("HORROR"));
        genres.add(new Genre("DRAMA"));
        genres.add(new Genre("SPORT"));
        String testGenreText = Movie.getGenresToString(genres);
        assertEquals("ACTION, HORROR, DRAMA, SPORT", testGenreText);
    }

    @Test
    void MovieCompareTo_ascending_by_alphabet(){
        List<String> genre = new ArrayList<>();
        genre.add("ACTION");
        Movie one = new Movie("A", "description", genre );
        Movie two = new Movie("B", "description", genre);
        assertEquals(-1, one.compareTo(two));
    }

    @Test
    void MovieCompareTo_descending_by_alphabet(){
        List<String> genre = new ArrayList<>();
        genre.add("ACTION");
        Movie one = new Movie("A", "description", genre );
        Movie two = new Movie("B", "description", genre);
        assertEquals(1, two.compareTo(one));
    }

    @Test
    void MovieCompareTo_ascending_by_numeric(){
        List<String> genre = new ArrayList<>();
        genre.add("ACTION");
        Movie one = new Movie("1", "description", genre );
        Movie two = new Movie("2", "description", genre);
        assertEquals(-1, one.compareTo(two));
    }

    @Test
    void MovieCompareTo_descending_by_numeric(){
        List<String> genre = new ArrayList<>();
        genre.add("ACTION");
        Movie one = new Movie("1", "description", genre );
        Movie two = new Movie("2", "description", genre);
        assertEquals(1, two.compareTo(one));
    }

    @Test
    void MovieCompareTo_equal_movies(){
        List<String> genre = new ArrayList<>();
        genre.add("ACTION");
        Movie one = new Movie("A", "description", genre );
        Movie two = new Movie("A", "description", genre);
        assertEquals(0, one.compareTo(two));
    }
}