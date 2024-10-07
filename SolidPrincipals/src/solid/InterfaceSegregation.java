package solid;

/*
	Interface segregation - larger interfaces should be divide into smaller one so that they have
	when classes implement them, that classes follows SRP
*/

interface BearKeeper {
    void washTheBear();
    void feedTheBear();
    void petTheBear();
}
// instead of above interface, we can divide them
interface BearCleaner {
    void washTheBear();
}

interface BearFeeder {
    void feedTheBear();
}

interface BearPetter {
    void petTheBear();
}

class BearCarer implements BearCleaner, BearFeeder {

    public void washTheBear() {
        //I think we missed a spot...
    }

    public void feedTheBear() {
        //Tuna Tuesdays...
    }
}

class CrazyPerson implements BearPetter {

    public void petTheBear() {
        //Good luck with that!
    }
}

// above classes follows SRP with the help of dividing the interface into smaller interfaces

public class InterfaceSegregation {

}
