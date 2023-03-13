package at.ac.fhcampuswien.fhmdb.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenreTests {
    //Testing the case sensitivity in the constructor;
    @Test
    void GenreConstructor_lowercase_entry_correctly_changed_to_uppercase(){
        String input = "action";
        assertEquals("ACTION", new Genre(input).getKindOfGenre());
    }

    @Test
    void GenreConstructor_mixed_letters_entry_correctly_changed_to_uppercase() {
        String input = "SpoRT";
        assertEquals("SPORT", new Genre(input).getKindOfGenre());
    }

    @Test
    void GenreConstructor_keeps_uppercase_entry_as_uppercase(){
        String input = "DRAMA";
        assertEquals("DRAMA", new Genre(input).getKindOfGenre());
    }
}