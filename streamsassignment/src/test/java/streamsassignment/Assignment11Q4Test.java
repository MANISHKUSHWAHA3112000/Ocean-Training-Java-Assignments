package streamsassignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class Assignment11Q4Test {

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

    @Test
    void testFindMaxCommentedNewsId_NoNews() {
        // Create an empty list of News for testing
        List<News> newsList = List.of();

        // Call the method to be tested
        int result = Assignment11Q4.findMaxCommentedNewsId(newsList);

        // No news available, so the result should be -1 (or any other sentinel value)
        int expected = -1;

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }

    @Test
    void testFindMaxCommentedNewsId_EqualComments() {
        // Create a list of News with equal comments for testing
        List<News> newsList = List.of(
                new News(1, "User1", "User2", "Nice post!"),
                new News(2, "User2", "User1", "I agree."),
                new News(3, "User3", "User4", "Interesting."),
                new News(4, "User4", "User1", "Well said!")
        );

        // Call the method to be tested
        int result = Assignment11Q4.findMaxCommentedNewsId(newsList);

        // All news have equal comments, so the result could be any of the newsId values
        int expected = 1;

        // Assert that the result is one of the expected values
        assertEquals(expected, result);
    }

    @Test
    void testFindMaxCommentedNewsId_SingleNews() {
        // Create a list with a single News for testing
        List<News> newsList = List.of(new News(1, "User1", "User2", "Nice post!"));

        // Call the method to be tested
        int result = Assignment11Q4.findMaxCommentedNewsId(newsList);

        // Only one news is available, so the result should be its newsId
        int expected = 1;

        // Assert that the result matches the expected value
        assertEquals(expected, result);
    }
}
