package app.drawing;

public class ConstructorInitialization {
	private String type;
	private String height;

	ConstructorInitialization (String type, int height) {
		System.out.println("height of int recieved");
		this.type = type;
		this.height = Integer.toString(height);
	}
	
	ConstructorInitialization (String type, String height) {
		System.out.println("height of string recieved");
		this.type = type;
		this.height = height;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public void draw () {
		System.out.println(type + " Triangle drawn of height " + height);
	}
}
