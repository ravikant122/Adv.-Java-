package design_patterns.factory_method;

// factory method design pattern
// 1. separate the creation logic of object from user/client code
// 2. provides encapsulation since user doesn't need to know how the object is being created and what
// 	  its dependencies are, we just provide user a factory that's gonna create object for user
// 3. helps in reduce tight coupling because we gonna use interfaces to create object and user
// 	  won't be dependent on classes
// 4. help in acheiving single responsiblity and open/closed principal
// 	  minimum modification in the future with better extensibility
// 5. used in spring to create bean

// we had to make this interface because order method can only return sinlg type
// and if we want to create multiple types of order then we have to use interface(rutime polymorphism)
interface Burger {
	public void prepare();
}

class VegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing VegBurger");
	}
}

class NonVegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing NonVegBurger");
	}
}

class Restaurant {
	public Burger order (String type) {
		Burger burger;
		if (type == "Veg") {
			burger = new VegBurger();
		} else {
			burger = new NonVegBurger();			
		}
		burger.prepare();
		return burger;
	}
	// 1. it doesn't follow single responsibilty principal because order method create an object
	// and also prepares it - there are two jobs
	
	// 2. it also doesn't follow open/close principal as if we add/remove a burger type
	// then we've to modify it - it should've been closed for modification
}

public class FirstStep {
	
}
