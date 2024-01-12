package annotation;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


import org.junit.jupiter.api.Test;

class InfoClassTest {

	@Test
	void testAnnotationMethod() throws Exception {
		String expectedOutput = "@annotation.Info";
		
		InfoClass infoClass = new InfoClass();
		Method []methods = infoClass.getClass().getDeclaredMethods();
		
		String output = "";
		
		for(Method method: methods) {
			if(method.getName().equals("myMethod")) {
				for(Annotation annotation:  method.getDeclaredAnnotations()) {
					output = annotation.toString();
				}
			}
		}
		
		assertTrue(output.contains(expectedOutput));
	}

}
