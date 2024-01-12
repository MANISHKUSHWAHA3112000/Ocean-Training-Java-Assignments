package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class News {
    int newsId;
    String postedByUser;
    String commentByUser;
    String comment;

    public News(int newsId, String postedByUser, String commentByUser, String comment) {
        this.newsId = newsId;
        this.postedByUser = postedByUser;
        this.commentByUser = commentByUser;
        this.comment = comment;
    }

    public int getNewsId() {
        return newsId;
    }

    public String getComment() {
        return comment;
    }
}

public class Assignment11Q4 {

    private static final Logger logger = Logger.getLogger(Assignment11Q4.class.getName());
    

    @Test
    void testFindMaxCommentedNewsId() {
        // Create a list of News for testing
        List<News> newsList = List.of(
                new News(1, "User1", "User2", "Nice post!"),
                new News(2, "User2", "User1", "I agree."),
                new News(1, "User3", "User4", "Interesting."),
                new News(3, "User4", "User1", "Well said!")
        );

        // Call the method to be tested
        int result = Assignment11Q4.findMaxCommentedNewsId(newsList);

        // Expected result based on the provided newsList
        int expected = 1;

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }

    public static void main(String[] args) {
        // Create a list of News for testing
        List<News> newsList = List.of(
                new News(1, "User1", "User2", "Nice post!"),
                new News(2, "User2", "User1", "I agree."),
                new News(1, "User3", "User4", "Interesting."),
                new News(3, "User4", "User1", "Well said!")
        );

        // Find the newsId with the maximum comments
        int maxCommentedNewsId = findMaxCommentedNewsId(newsList);
        logger.info("NewsId with Maximum Comments: " + maxCommentedNewsId);
    }

    static int findMaxCommentedNewsId(List<News> newsList) {
        Map<Integer, Long> newsCommentCounts = newsList.stream()
                .collect(Collectors.groupingBy(News::getNewsId, Collectors.counting()));

        return newsCommentCounts.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(-1); // Return -1 when no news are available
    }

}
