package solid;

// a class should be open for extension but not for modification
// means you should write the code in such a way that there's should be no modification

class Guitar {
    private String make;
    private String model;
    private int volume;

    //Constructors, getters & setters
}

class SuperCoolGuitarWithFlames extends Guitar {
    private String flameColor;
    //constructor, getters + setters
}

public class OpenClosed {

}