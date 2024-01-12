package streamsassignment;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q6.News;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment11Q6Test {

    @Test
    public void testFindUserWithMaxComments() {
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting article."),
                new News(3, "User1", "Commenter1", "I agree with the points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful."),
                new News(5, "User1", "Commenter1", "Another comment.")
        );

        String result = Assignment11Q6.findUserWithMaxComments(newsList);

        assertEquals("User1", result, "Incorrect user with maximum comments.");
    }
}
