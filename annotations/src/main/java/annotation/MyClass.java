package annotation;

import java.util.logging.Logger;

public class MyClass {
	
	private static final Logger logger=Logger.getLogger(MyClass.class.getName());

    @Execute(sequence = 2)
    public void myMethod1() {
        logger.info("Executing myMethod1");
    }

    @Execute(sequence = 1)
    public void myMethod2() {
        logger.info("Executing myMethod2");
    }

    @Execute(sequence = 3)
    public void myMethod3() {
        logger.info("Executing myMethod3");
    }
}
