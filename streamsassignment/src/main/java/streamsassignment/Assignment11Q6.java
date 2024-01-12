package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;



public class Assignment11Q6 {

    private static final Logger logger = Logger.getLogger(Assignment11Q6.class.getName());

    public static String findUserWithMaxComments(List<News> newsList) {
        Map<String, Integer> commentCountByUser = new HashMap<>();

        for (News news : newsList) {
            String postedByUser = news.getPostedByUser();
            commentCountByUser.put(postedByUser, commentCountByUser.getOrDefault(postedByUser, 0) + 1);
        }

        // Find user with maximum comments
        int maxComments = 0;
        String userWithMaxComments = null;

        for (Map.Entry<String, Integer> entry : commentCountByUser.entrySet()) {
            if (entry.getValue() > maxComments) {
                maxComments = entry.getValue();
                userWithMaxComments = entry.getKey();
            }
        }

        return userWithMaxComments;
    }

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
    
    public static void main(String[] args) {
        // Example usage
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting article."),
                new News(3, "User1", "Commenter1", "I agree with the points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful."),
                new News(5, "User1", "Commenter1", "Another comment.")
        );

        String userWithMaxComments = findUserWithMaxComments(newsList);
        logger.info("User with maximum comments: " + userWithMaxComments);
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

        public String getPostedByUser() {
            return postedByUser;
        }
    }
}
