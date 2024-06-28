import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager;

    @BeforeEach
    void setUp() {
        manager = new MovieManager();
    }

    @Test
    void shouldAddAndFindAllMovies() {
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");

        String[] expected = {"Фильм 1", "Фильм 2", "Фильм 3"};
        assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void shouldFindLastMoviesWithinLimit() {
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");
        manager.addMovie("Фильм 6");

        String[] expected = {"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldFindLastMoviesBeyondLimit() {
        manager = new MovieManager(3);
        manager.addMovie("Фильм 1");
        manager.addMovie("Фильм 2");
        manager.addMovie("Фильм 3");
        manager.addMovie("Фильм 4");
        manager.addMovie("Фильм 5");

        String[] expected = {"Фильм 5", "Фильм 4", "Фильм 3"};
        assertArrayEquals(expected, manager.findLast());
    }

    @Test
    void shouldHandleEmptyMovieList() {
        String[] expected = {};
        assertArrayEquals(expected, manager.findAll());
        assertArrayEquals(expected, manager.findLast());
    }
}