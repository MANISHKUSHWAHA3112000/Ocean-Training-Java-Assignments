package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;



public class Assignment11Q7 {

    private static final Logger logger = Logger.getLogger(Assignment11Q7.class.getName());

    public static Map<String, Integer> countCommentsByUser(List<News> newsList) {
        Map<String, Integer> commentCountMap = new HashMap<>();

        for (News news : newsList) {
            String commentByUser = news.getCommentByUser();
            commentCountMap.put(commentByUser, commentCountMap.getOrDefault(commentByUser, 0) + 1);
        }

        return commentCountMap;
    }


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
    
    public static void main(String[] args) {
        // Example usage
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting article."),
                new News(3, "User1", "Commenter1", "I agree with the points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful.")
        );

        Map<String, Integer> commentCountMap = countCommentsByUser(newsList);

        logger.info("Comment counts by user:");
        for (Map.Entry<String, Integer> entry : commentCountMap.entrySet()) {
            logger.info(entry.getKey() + ": " + entry.getValue() + " comments");
        }
    }

    static class News {
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

        public String getCommentByUser() {
            return commentByUser;
        }
    }
}
