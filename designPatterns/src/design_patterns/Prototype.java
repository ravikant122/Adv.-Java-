package design_patterns;

/*
	prototype - deep clone of object
	
	basic way to deep clone is
	1. create a object using class - MyClass obj2 = new MyClass()
	2. and copy all properties from obj1 to obj2 (like obj2.height = obj1.height)
	
	problem with above approach
	1. we're dependent on MyClass, if something changes in MyClass, we've to change it here also
	2. not all properties of class is accessible outside the class
	
	for this, we can make a interface of MyClass, this interface will have a clone method
	now we will do it like
	MyInterface obj1 = new MyClass();
	MyInterface obj2 = obj1.clone(); - this clone will create a object using copy constructor
*/
abstract class Vehicle {
	private String brand;
	private String model;
	private String color;
	
	protected Vehicle(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;	
	}
	
	protected Vehicle(Vehicle v) {
		this.brand = v.brand;
		this.model = v.model;
		this.color = v.color;
	}
	
	public abstract Vehicle clone();
	
}

class Car extends Vehicle {
	private int topSpeed;
	
	public Car(String brand, String model, String color, int topSpeed) {
		super(brand, model, color);
		this.topSpeed = topSpeed;
	}
	
	public Car(Car c) {
		super(c);
		this.topSpeed = c.topSpeed;
	}

	@Override
	public Vehicle clone() {
		return new Car(this);
	}
}

class Bus extends Vehicle {
	private int doors;
	
	public Bus(String brand, String model, String color, int doors) {
		super(brand, model, color);
		this.doors = doors;
	}
	
	public Bus(Bus b) {
		super(b);
		this.doors = b.doors;
	}

	@Override
	public Vehicle clone() {
		return new Bus(this);
	}
}
public class Prototype {
	public static void main(String[] args) {
		Vehicle v1 = new Car("Maruti", "baleno", "white", 100);
		Vehicle v2 = v1.clone();
		
		System.out.println(v1);
		System.out.println(v2);
	}
}
