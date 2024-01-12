package String_StringBuffer_String_Builder;

public class Assignment6Q4 {
    public String buildString() {
        // Create a StringBuffer
        StringBuffer stringBuffer = new StringBuffer();

        // Append strings to the StringBuffer
        stringBuffer.append("StringBuffer")
                     .append(" is a peer class of String")
                     .append(" that provides much of ")
                     .append("the functionality of strings");

        // Return the final result
        return stringBuffer.toString();
    }
}
