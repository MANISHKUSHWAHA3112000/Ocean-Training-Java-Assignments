package lambdaexpression;

import java.util.Arrays;
import java.util.List;


/**
 * 
 */
public class Threadlambda {
	 /**
	 * @param args
	 */
	public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

	        Thread thread = new Thread(() -> {
	            numbers.forEach(System.out::println);
	        });

	        thread.start();
	    }
}
