package at.ac.fhcampuswien.fhmdb.models;

import at.ac.fhcampuswien.fhmdb.HomeController;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeControllerTest {

    @Test
    public void FilterByString_with_Empty_String_To_Search() {
        Movie movie1 = new Movie("Movie1",  "A heartwarming story", Collections.singletonList("Drama, Comedy"));

        HomeController instance = new HomeController();

        assertTrue(instance.filterByString(movie1, ""));
    }
}
