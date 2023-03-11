package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenreTests {

    @Test
    void GenreConstructor_lowercase_correctly_changed_to_uppercase(){
        String input = "action";
        assertEquals("ACTION", new Genre(input).getKindOfGenre());
    }

    @Test
    void GenreConstructor_mixed_letters_correctly_changed_to_uppercase() {
        String input = "SpoRT";
        assertEquals("SPORT", new Genre(input).getKindOfGenre());
    }

    @Test
    void GenreConstructor_keeps_uppercase_as_uppercase(){
        String input = "DRAMA";
        assertEquals("DRAMA", new Genre(input).getKindOfGenre());
    }
}