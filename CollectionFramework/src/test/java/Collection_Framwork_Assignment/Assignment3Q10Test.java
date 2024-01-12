package Collection_Framwork_Assignment;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Assignment3Q10Test {

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
