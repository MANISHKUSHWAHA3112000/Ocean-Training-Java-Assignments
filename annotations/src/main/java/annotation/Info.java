package annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
public @interface Info {
    String authorID(); // Mandatory Input
    String author() default ""; // Optional Input (default value is an empty string)
    String supervisor() default ""; // Optional Input (default value is an empty string)
    String date(); // Mandatory Input
    String time(); // Mandatory Input
    int version(); // Mandatory Input
    String description() default ""; // Optional Input (default value is an empty string)
}
