package streamsassignment;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q5.News;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment11Q5Test {

    @Test
    public void testCountBudgetMentions() {
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting budget article."),
                new News(3, "User1", "Commenter1", "I agree with the budget points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful.")
        );

        int result = Assignment11Q5.countBudgetMentions(newsList);

        assertEquals(2, result, "Incorrect number of mentions of the word 'budget'.");
    }
}

