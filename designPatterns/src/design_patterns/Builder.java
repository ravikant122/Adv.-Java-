package design_patterns;

/*
	lets say, we are house with some basic features(four walls, ceiling, door, windows)
	and some extra features(like swimming pool, garage, garden etc.)
	
	we can create a class with the basic features and then we can make other classes with extra
	features and these classes will extend the basic house class
	
	this way is not good because we gonna create a lot of sub-classes
	
	what we can do is, create a house with basic(compulsory) and extra features(optional)
	now we can initialize basic features using constructor and extra features using setters
	this way we have only one class and users can create house with basic features and
	provide the extra features as per their needs
	
	this is called Builder pattern - building step by step
	
	adv of this:
	1. when you have many parameters in constructor but some of them are optinal
	2. when we want to create diff representations of same product like house with garden and no garden
	
	used in
	1. java.lang.StringBuilder
	2. java.lang.StringBuffer
*/

public class Builder {

	public static void main(String[] args) {

	}

}
