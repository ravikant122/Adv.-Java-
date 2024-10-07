package solid;

// a class should have one job or purpose, it should change because of one reason
// benifit of this is, the class will have less dependecies
// and the code will not be a mess because it has all the code for the things that its doing
// and the testing will be easy to test each functionality separately

class Book {
    private String name;
    private String author;
    private String text;

    public Book(String name, String author, String text) {
		this.name = name;
		this.author = author;
		this.text = text;
	}
	
	// methods that directly relate to the book properties
    public String replaceWordInText(String word, String replacementWord){
        return text.replaceAll(word, replacementWord);
    }

    public boolean isWordInText(String word){
        return text.contains(word);
    }
    
//    void printTextToConsole(String text){
//        //our code for formatting and printing the text
//    }
//    void printTextToAnotherMedium(String text){
//        // code for writing to any other location..
//    }
    // if we define these methods here then we are not following SRP since the book should be 
    // concerned with only book fields, it should not be related to printing
    // if we put all functionality in this class then the code won't be well-organized
    // and if in future Printing changes and it uses some other dependencies
    // then this class is also gonna change
    
    // and if we defined different class - BookPrinter - then the code looks well-organized
    // and for printing - Book class doesn't have any dependencies, means for future printing
    // enhancements, Book class won't be changed
    
    // SRP is Book class shouldn't change because of printing, it should change because of Book
    // properties like if we are gonna add price of book, then it can change
    // but it shouldn't change becuase of some other thing like delivery/printing etc.
}

class BookPrinter {
    // methods for outputting text
    void printTextToConsole(String text){
        //our code for formatting and printing the text
    }
    void printTextToAnotherMedium(String text){
        // code for writing to any other location..
    }
}

public class SingleResponsibility {

}