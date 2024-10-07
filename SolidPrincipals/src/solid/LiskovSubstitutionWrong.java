package solid;

// Liskov substitution - you should create child classes in such a way that they should be able to
// replace their parent classes

abstract class Employee {
	private int id;
	Employee(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Emp id is " + this.id;
	}
	public abstract int calculateBonus(int salary) throws NotImplementedException;
}

class PermanentEmployee extends Employee {
	PermanentEmployee(int id) {
		super(id);
	}
	@Override
	public int calculateBonus(int salary) {
		return salary / 2;
	}
}

// when we created this class then we didn't have to change existing interface/classes
// means till here, we are following Liskov
class TempEmployee extends Employee {
	TempEmployee(int id) {
		super(id);
	}
	@Override
	public int calculateBonus(int salary) {
		return salary / 4;
	}
}

class ContractEmployee extends Employee {
	ContractEmployee(int id) {
		super(id);
	}
	@Override
	public int calculateBonus(int salary) throws NotImplementedException {
		throw new NotImplementedException();
	}
	// when we added this class
	// we had to throw a new exception
	// we had to change interface
	// means the ContractEmployee cannot replace abstract class Employee 
	// we have to change this
}


class NotImplementedException extends Exception{
	private static final long serialVersionUID = 1L;	
}

public class LiskovSubstitutionWrong {
	public static void main(String[] args) {
	}
}
