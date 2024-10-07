package solid;

// Dependency Inversion - high level classes/modules shouldn't depend on low level classes/modules
// instead they should depend on abstraction

class StandardKeyboard {
	
}

class StandardMonitor {
	
}
class Windows98 {
	private StandardKeyboard keyboard;
	private StandardMonitor  monitor;
	
	public Windows98 () {
		this.keyboard =  new StandardKeyboard();
		this.monitor = new StandardMonitor();
	}
}
// in this, Windows98 is tightly coupled with StandardKeyboard and Monitor class
// in future if we want to change the keyboard/monitor, we've to change Windows98 code also
// also there's only class for Windows98, in future if we want to create new windows then
// we've to create a new class and copy all the properties of windows98 in that
// meaning too much redundancy

// what we can do is, create a keyboard/monitor interface and Windows98 will use these interface
// and in future, if our keyboard/monitor changes, then we don't have to change Windows98's code

interface Keyboard {}

class NewKeyboard implements Keyboard{}

interface Monitor {}

class NewMonitor implements Monitor{}

abstract class Windows {
	private Keyboard keyboard;
	private Monitor monitor;
	
	Windows (Keyboard k, Monitor m) {
		this.keyboard = k;
		this.monitor = m;
	}
}

// we didn't have to repeat the keyboard/monitor code/constructor for every windows
class Windows2000 extends Windows{
	// here we can pass any keyboard/monitor
	Windows2000(Keyboard k, Monitor m) {
		super(k, m);
	}
}


public class DependencyInversion {

}
