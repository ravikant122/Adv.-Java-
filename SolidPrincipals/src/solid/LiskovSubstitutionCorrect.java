package solid;

interface IEmp {
	public String toString();
}
interface IEmpBonus {
	public int calculateBonus(int salary);
}

abstract class NewEmployee implements IEmp, IEmpBonus {
	private int id;
	NewEmployee(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Emp id is " + this.id;
	}
}

class NewPermanentEmployee extends NewEmployee {
	NewPermanentEmployee(int id) {
		super(id);
	}
	@Override
	public int calculateBonus(int salary) {
		return salary / 2;
	}
}
class NewTempEmployee extends NewEmployee {
	NewTempEmployee(int id) {
		super(id);
	}
	@Override
	public int calculateBonus(int salary) {
		return salary / 4;
	}
}

// since contract employee doesn't get bonus, we don't need to implement bonus interface
class NewContractEmployee implements IEmp {
	private int id;
	
	NewContractEmployee(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Emp id is " + this.id;
	}
}

// one more thing about Liskov, it says child class should replace their parent interface/class
// in loose coupling, we create obj like this - MyInterface obj = new MyClass();
// now we can only access the method define in the interface, therefor if MyClass create some methods
// which are not in MyInterface, we can't access them using obj and here MyClass can't replace
// MyInterface - that's another reason to follow Liskov
interface MyInter {
	public void printMe();
}
class MyClass implements MyInter {
	@Override
	public void printMe() {
		System.out.println("me");
	}
	// this method can't be access by obj of MyInter
	public void printYou() {
		System.out.println("you");
	}
}
public class LiskovSubstitutionCorrect {

}
