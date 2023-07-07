import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.statistic.PosterRepository;

public class PosterRepositoryTest {

    @Test
    public void EmptyTest() {
        PosterRepository poster = new PosterRepository();


        String[] expected = {};
        String[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addFilms() {
        PosterRepository poster = new PosterRepository();
        poster.addNewMovie("Movie1");
        poster.addNewMovie("Movie2");
        poster.addNewMovie("Movie3");

        String[] expected = {"Movie1", "Movie2", "Movie3"};
        String[] actual = poster.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void lastFilmsSmallLimit() {
        PosterRepository poster = new PosterRepository();
        poster.addNewMovie("Movie1");
        poster.addNewMovie("Movie2");
        poster.addNewMovie("Movie3");

        String[] expected = {"Movie3", "Movie2", "Movie1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void lastFilmsEqLimit() {
        PosterRepository poster = new PosterRepository();
        poster.addNewMovie("Movie1");
        poster.addNewMovie("Movie2");
        poster.addNewMovie("Movie3");
        poster.addNewMovie("Movie4");
        poster.addNewMovie("Movie5");


        String[] expected = {"Movie5", "Movie4", "Movie3", "Movie2", "Movie1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void lastFilmMoreLimit() {
        PosterRepository poster = new PosterRepository(6);
        poster.addNewMovie("Movie1");
        poster.addNewMovie("Movie2");
        poster.addNewMovie("Movie3");
        poster.addNewMovie("Movie4");
        poster.addNewMovie("Movie5");
        poster.addNewMovie("Movie6");

        String[] expected = {"Movie6","Movie5", "Movie4", "Movie3", "Movie2", "Movie1"};
        String[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);

    }
}
