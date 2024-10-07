package design_patterns.factory_method;

class BurgerFactory {
	// 1. it also doesn't follow open/close principal as if we add/remove a burger type
	// then we've to modify it - it should've been closed for modification
	// means we still have to decouple things
	public Burger createBurger(String type) {
		Burger burger;
		if (type == "Veg") {
			burger = new VegBurger();
		} else {
			burger = new NonVegBurger();			
		}
		return burger;
	}
}

class NewRestaurant {
	public Burger order (BurgerFactory factory, String type) {
		Burger burger = factory.createBurger(type);
		burger.prepare();
		return burger;
	}
	// 1. it now follows single responsibilty principal because order method only prepares the burger
	// 2. it follows open/closed principal, because it won't change if we add/remove a new burger type
}

public class SecondStep {
	public static void main(String[] args) {
		// make factory object here so that its instance will be create only once, not in NewRestaurant
		BurgerFactory factory = new BurgerFactory();
		NewRestaurant res = new NewRestaurant();
		
		res.order(factory, "Veg");
		res.order(factory, "NonVeg");
	}
}
