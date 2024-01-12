package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class Assignment11Q5 {

    private static final Logger logger = Logger.getLogger(Assignment11Q5.class.getName());

    public static int countBudgetMentions(List<News> newsList) {
        int count = 0;

        for (News news : newsList) {
            if (news.getComment() != null && news.getComment().toLowerCase().contains("budget")) {
                count++;
            }
        }

        return count;
    }

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
    
    public static void main(String[] args) {
        // Example usage
        List<News> newsList = List.of(
                new News(1, "User1", "Commenter1", "Great news!"),
                new News(2, "User2", "Commenter2", "Interesting budget article."),
                new News(3, "User1", "Commenter1", "I agree with the budget points mentioned."),
                new News(4, "User3", "Commenter3", "This is helpful.")
        );

        int budgetMentions = countBudgetMentions(newsList);
        logger.info("Number of mentions of 'budget': " + budgetMentions);
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

        public String getComment() {
            return comment;
        }
    }
}
