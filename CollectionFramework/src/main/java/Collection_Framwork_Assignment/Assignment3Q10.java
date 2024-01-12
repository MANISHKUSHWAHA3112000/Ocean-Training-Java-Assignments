package Collection_Framwork_Assignment;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class MovieDetails {
    private String movieName;
    private String actor;
    private String actress;
    private String genre;

    public MovieDetails(String movieName, String actor, String actress, String genre) {
        this.movieName = movieName;
        this.actor = actor;
        this.actress = actress;
        this.genre = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getActor() {
        return actor;
    }

    public String getActress() {
        return actress;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        String newline = System.lineSeparator();
        return newline + "Movie_Details : " + "Movies_Name = " + this.movieName + " , Actor_Name = " + this.actor +
                ", Actress_Name = " + this.actress + ",Movie_genre =" + this.genre + newline;
    }
}

class MovieDetailsList {
    private List<MovieDetails> movies;

    public MovieDetailsList() {
        movies = new ArrayList<>();
    }

    public void addMovie(MovieDetails movie) {
        movies.add(movie);
    }

    public void removeMovie(String movieName) {
        movies.removeIf(movie -> movie.getMovieName().equals(movieName));
    }

    public void removeAllMovies(List<MovieDetails> moviesToRemove) {
        movies.removeAll(moviesToRemove);
    }

    public MovieDetails find_movie_By_mov_Name(String movieName) {
        for (MovieDetails movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<MovieDetails> find_movie_By_Genre(String genre) {
        List<MovieDetails> moviesByGenre = new ArrayList<>();
        for (MovieDetails movie : movies) {
            if (movie.getGenre().equals(genre)) {
                moviesByGenre.add(movie);
            }
        }
        return moviesByGenre;
    }

    public void sort(List<MovieDetails> movieList, Comparator<MovieDetails> movieDetailsComparator) {
        movieList.sort(movieDetailsComparator);
    }

    public void removeAllMovies() {
        movies.clear();
    }

    public static Comparator<MovieDetails> sortAccordingly(String sortBy) {
        Comparator<MovieDetails> movieDetailsComparator;
        switch (sortBy.toLowerCase()) {
            case "name":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getMovieName);
                break;
            case "actor":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getActor);
                break;
            case "actress":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getActress);
                break;
            case "genre":
                movieDetailsComparator = Comparator.comparing(MovieDetails::getGenre);
                break;
            default:
                movieDetailsComparator = null;
        }
        return movieDetailsComparator;
    }
}

public class Assignment3Q10 {

    @Test
    void testPrintSortedMovieList() {
        ArrayList<MovieDetails> movieDetailsList = new ArrayList<>();
        movieDetailsList.add(new MovieDetails("Thor:Rangrok", "Chris Hemsworth", "Natalia Portman", "Superhero-action"));
        movieDetailsList.add(new MovieDetails("KGF-2", "Yash", "Srinidhi Shetty", "Action"));
        movieDetailsList.add(new MovieDetails("3 idiots", "Aamir khan", "Kareena kapoor", "Educational"));
        movieDetailsList.add(new MovieDetails("Hera Pheri", "Akshay Kumar", "Tabu", "Comedy"));
        movieDetailsList.add(new MovieDetails("Shiddat", "Sunny Kaushal", "Radhika Madan", "Romantic"));

        ArrayList<MovieDetails> expectedSortedByName = new ArrayList<>(movieDetailsList);
        expectedSortedByName.sort(MovieDetailsList.sortAccordingly("name"));

        ArrayList<MovieDetails> expectedSortedByActor = new ArrayList<>(movieDetailsList);
        expectedSortedByActor.sort(MovieDetailsList.sortAccordingly("actor"));

        ArrayList<MovieDetails> expectedSortedByActress = new ArrayList<>(movieDetailsList);
        expectedSortedByActress.sort(MovieDetailsList.sortAccordingly("actress"));

        ArrayList<MovieDetails> expectedSortedByGenre = new ArrayList<>(movieDetailsList);
        expectedSortedByGenre.sort(MovieDetailsList.sortAccordingly("genre"));

        MovieDetailsList movieDetailsListObject = new MovieDetailsList();

        // Test Sort by Name
        List<MovieDetails> actualSortedByName = new ArrayList<>(movieDetailsList);
        movieDetailsListObject.sort(actualSortedByName, MovieDetailsList.sortAccordingly("name"));
        assertIterableEquals(expectedSortedByName, actualSortedByName);

        // Test Sort by Actor
        List<MovieDetails> actualSortedByActor = new ArrayList<>(movieDetailsList);
        movieDetailsListObject.sort(actualSortedByActor, MovieDetailsList.sortAccordingly("actor"));
        assertIterableEquals(expectedSortedByActor, actualSortedByActor);

        // Test Sort by Actress
        List<MovieDetails> actualSortedByActress = new ArrayList<>(movieDetailsList);
        movieDetailsListObject.sort(actualSortedByActress, MovieDetailsList.sortAccordingly("actress"));
        assertIterableEquals(expectedSortedByActress, actualSortedByActress);

        // Test Sort by Genre
        List<MovieDetails> actualSortedByGenre = new ArrayList<>(movieDetailsList);
        movieDetailsListObject.sort(actualSortedByGenre, MovieDetailsList.sortAccordingly("genre"));
        assertIterableEquals(expectedSortedByGenre, actualSortedByGenre);
    }
}
