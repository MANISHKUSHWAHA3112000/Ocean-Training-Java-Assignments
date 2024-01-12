package String_StringBuffer_String_Builder;

public class Assignment6Q3 {

    public String toLowercase(String input) {
        return input.toLowerCase();
    }

    public String toUppercase(String input) {
        return input.toUpperCase();
    }

    public String replaceCharacter(String input, char target, char replacement) {
        return input.replace(target, replacement);
    }

    public boolean containsWord(String input, String word) {
        return input.contains(word);
    }

    public boolean stringsMatch(String input1, String input2) {
        return input1.equals(input2);
    }


    public boolean stringsEqual(String input1, String input2) {
        return input1.contentEquals(input2);
    }
}
