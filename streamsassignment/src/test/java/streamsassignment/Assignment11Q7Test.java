package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import streamsassignment.Assignment11Q7.News;

public class Assignment11Q7Test {

    @Test
    public void testCountCommentsByUser() {
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting article."),
                new News(3, "User1", "Commenter1", "I agree with the points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful.")
        );

        Map<String, Integer> commentCountMap = Assignment11Q7.countCommentsByUser(newsList);

        assertEquals(2, commentCountMap.get("Commenter1"));
        assertEquals(1, commentCountMap.get("Commenter2"));
        assertEquals(1, commentCountMap.get("Commenter3"));
    }
}
