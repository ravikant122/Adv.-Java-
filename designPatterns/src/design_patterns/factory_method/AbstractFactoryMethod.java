package design_patterns.factory_method;

/*
	now lets say, we've to implement two types of veg burger - indian, american
	
	if we do like this

	abstract class ImprovedRestaurant {
		// this method follows single responsibility principal
		public Burger order(String type) {
			Burger burger = this.createBurger(type);
			burger.prepare();
			return burger;
		}
		public abstract Burger createBurger(String type);
	}
	
	class VegBurgerRestaurant extends ImprovedRestaurant {		
		@Override
		public Burger createBurger(String type) {
			if (type == "Indian") {
				return new IndianVegBurger();
			} else {
				return new AmericanVegBurger();
			}
		}
		// above method doesn't follow open/closed principal
	}
*/

abstract class ImprovedAbstractRestaurant {
	// this method follows single responsibility principal
	public Burger order(Burger burger) {
		burger.prepare();
		return burger;
	}
	
	public abstract Burger createIndianBurger();
	public abstract Burger createAmericanBurger();
}

class IndianVegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing IndianVegBurger");
	}
}

class AmericanVegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing AmericanVegBurger");
	}
}

class IndianNonVegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing IndianNonVegBurger");
	}
}

class AmericanNonVegBurger implements Burger{
	@Override
	public void prepare () {
		System.out.println("Preparing AmericanNonVegBurger");
	}
}

class NewVegBurgerRestaurant extends ImprovedAbstractRestaurant {
	
	@Override
	public Burger createIndianBurger() {
		return new IndianVegBurger();
	}
	@Override
	public Burger createAmericanBurger() {
		return new AmericanVegBurger();
	}
}

class NewNonVegBurgerRestaurant extends ImprovedAbstractRestaurant {
	
	@Override
	public Burger createIndianBurger() {
		return new IndianNonVegBurger();
	}
	@Override
	public Burger createAmericanBurger() {
		return new AmericanNonVegBurger();
	}
}

public class AbstractFactoryMethod {
	public static void main(String[] args) {
		ImprovedAbstractRestaurant res = new NewVegBurgerRestaurant();
		res.order(res.createIndianBurger());
		res.order(res.createAmericanBurger());
		
		ImprovedAbstractRestaurant res1 = new NewNonVegBurgerRestaurant();
		res1.order(res1.createIndianBurger());
		res1.order(res1.createAmericanBurger());
	}
}
