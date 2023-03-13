package at.ac.fhcampuswien.fhmdb.utilities;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DummyMovieListGeneratorTests {
    @Test
    void checkForNull_with_empty_Source(){
        Throwable exception = assertThrows(NullPointerException.class, () -> {
            DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/emptySource");
            generator.checkForNull();
        });
        assertEquals("Source cannot be Null / Empty!", exception.getMessage());
    }

    @Test
    void checkForNull_with_non_empty_Source() throws FileNotFoundException {
        DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/onlyEnd");
        assertTrue(generator.checkForNull());
    }

    @Test
    void checkForEnd_with_without_END_in_Source(){
        Throwable exception = assertThrows(NullPointerException.class, () -> {
                    DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/withoutEND");
                    generator.checkForEnd();
                });
        assertEquals("ERROR - Source needs to contain \"END\"", exception.getMessage());
    }

    @Test
    void checkForEnd_with_END_in_Source() throws IOException {
        DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/onlyEND");
        assertTrue(generator.checkForEnd());
    }

    @Test
    void checkForData_without_Data() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/onlyEND");
            generator.checkForData();
        });
        assertEquals("Source contains no movie data.", exception.getMessage());
    }

    @Test
    void checkForData_with_Data_in_Source() throws IOException {
        DummyMovieListGenerator generator = new DummyMovieListGenerator("src/test/java/at/ac/fhcampuswien/fhmdb/recourcesForTest/correctSyntax");
        assertTrue(generator.checkForData());
    }
}