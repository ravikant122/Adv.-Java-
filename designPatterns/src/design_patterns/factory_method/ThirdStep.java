package design_patterns.factory_method;

abstract class ImprovedRestaurant {
	// this method follows single responsibility principal
	public Burger order() {
		Burger burger = this.createBurger();
		burger.prepare();
		return burger;
	}
	
	public abstract Burger createBurger();
}

class VegBurgerRestaurant extends ImprovedRestaurant {
	
	@Override
	public Burger createBurger() {
		return new VegBurger();
	}
}

class NonVegBurgerRestaurant extends ImprovedRestaurant {
	
	@Override
	public Burger createBurger() {
		return new NonVegBurger();
	}
}

// this program follows the open/closed principal
// if a new burger type gets removed/created, then we just have to remove/create class for that burger
// type, means we don't have to change anything, we can just extend already created ImprovedRestaurant

public class ThirdStep {
	public static void main(String[] args) {
		ImprovedRestaurant resVeg = new VegBurgerRestaurant();
		resVeg.order();
		
		ImprovedRestaurant resNonVeg = new NonVegBurgerRestaurant();
		resNonVeg.order();
	}
}
