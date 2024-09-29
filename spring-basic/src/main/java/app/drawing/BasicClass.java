package app.drawing;

public class BasicClass implements Shape {
	private String type;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void draw () {
		System.out.println(type + " Triangle drawn");
	}
}
