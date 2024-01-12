package annotation;

@Info(authorID = "12345", date = "2023-10-22", time = "15:30", version = 1, description = "This is a sample class.")
public class InfoClass {

	@Info(authorID = "67890", date = "2023-10-22", time = "16:00", version = 1, description = "This is a sample method.")
	public void myMethod() {
		// Method implementation
	}

	@Info(authorID = "67890", date = "2023-10-22", time = "16:15", version = 1)
	private String myProperty;
}
