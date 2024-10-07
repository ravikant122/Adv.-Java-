package design_patterns;

class SingletonEager {
	// we've to make this object static because its being used by a static method
	private static SingletonEager instance = new SingletonEager();
	
	// private constructor so that, object cannot be created from outside
	private SingletonEager() {}
	
	// public static method so that it can be called with classname from outside
	public static SingletonEager getInstance() {
		return instance;
	}
	
	// eager initialization is good becuase now we don't care about multiple threads and their
	// synchronization, since the instance is made when the program gets run
	// before any thread tries to get instance, now no matter how many no of threads comes at once
	// they all will get the same instance
	
	// reallife usecases: logging, session, caching
	// beans in spring are singleton by default and they get created beforehand when program get run
	
	// the only problem with eager is we will waste our resource if use don't use it
}

class SingletonLazy {
	
	private static SingletonLazy instance;
	
	private SingletonLazy() {}
	
	// the problem with lazy is if two threads access this method at the same time
	// then for both threads, the instance will be null and we will create two instances
	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}

class SingletonSynchronizedMethod {
	
	private static SingletonSynchronizedMethod instance;
	
	private SingletonSynchronizedMethod() {}
	
	// the problem with lazy is if two threads access this method at the same time
	// then for both threads, the instance will be null and we will create two instances
	
	// this is thread safe, as if two thread come at once then only one can enter in the method
	// and when the first get finished, second thread will find that instance is not null
	public static synchronized SingletonSynchronizedMethod getInstance() {
		if (instance == null) {
			instance = new SingletonSynchronizedMethod();
		}
		return instance;
	}
}

class SingletonSynchronized {
	
	private static SingletonSynchronized instance;
	
	private SingletonSynchronized() {}
	
	// in the above, we make the whole method synchronized this makes the read operation of instance
	// also synchronized, we should not make readability synchronized
	public static SingletonSynchronized getInstance() {
		if (instance == null) {
			// if two threads comes at this, then only one can get enter in synchronized block
			// and it make instance not null, now second thread will enter in sync block
			// and will find that instance is not null, therefor we will have only one objet
			synchronized (SingletonSynchronized.class) {
				if (instance == null) {
					instance = new SingletonSynchronized();
				}
			}
		}
		return instance;
	}
}

public class Singleton {
	public static void main(String[] args) {
		SingletonSynchronized s1 = SingletonSynchronized.getInstance();
		SingletonSynchronized s2 = SingletonSynchronized.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
	}
}
