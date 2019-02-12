package applications;

import implementationClasses.BasicStackImpl;
import implementationClasses.ListStackImpl;
import interfaces.Stack;

public class CardStack {
	
//	static Stack<String> stackObj = new BasicStackImpl<String>();
	static Stack<String> stackObj = new ListStackImpl<String>();
	static int stackSize;


	public static void main(String[] args) {
		
		System.out.println("Loading the Deck...");
		System.out.println("-------------------");
		loadDeck();
		stackSize = checkSize();
		stackObj.printStack();
		
		System.out.println("\n");
		System.out.println("Unloading the Deck...");
		System.out.println("---------------------");
		unloadDeck();
		stackObj.printStack();
		stackSize = checkSize();
		
		System.out.println("\n");
		System.out.println("Reloading the Deck...");
		System.out.println("---------------------");
		loadDeck();
		stackSize = checkSize();
		
		System.out.println("\n");
		System.out.println("Accessing the Queen of Hearts...");
		System.out.println("--------------------------------");
		accessOneParticularCard("Queen of Hearts");
		stackSize = checkSize();
		stackObj.printStack();
		
	}
	
	public static void loadDeck() {
		stackObj.push("Ace of Hearts");
		stackObj.push("2 of Hearts");
		stackObj.push("3 of Hearts");
		stackObj.push("4 of Hearts");
		stackObj.push("5 of Hearts");
		stackObj.push("6 of Hearts");
		stackObj.push("7 of Hearts");
		stackObj.push("8 of Hearts");
		stackObj.push("9 of Hearts");
		stackObj.push("10 of Hearts");
		stackObj.push("Jack of Hearts");
		stackObj.push("Queen of Hearts");
		stackObj.push("King of Hearts");
		
		stackObj.push("Ace of Clubs");
		stackObj.push("2 of Clubs");
		stackObj.push("3 of Clubs");
		stackObj.push("4 of Clubs");
		stackObj.push("5 of Clubs");
		stackObj.push("6 of Clubs");
		stackObj.push("7 of Clubs");
		stackObj.push("8 of Clubs");
		stackObj.push("9 of Clubs");
		stackObj.push("10 of Clubs");
		stackObj.push("Jack of Clubs");
		stackObj.push("Queen of Clubs");
		stackObj.push("King of Clubs");
		
		stackObj.push("Ace of Diamond");
		stackObj.push("2 of Diamond");
		stackObj.push("3 of Diamond");
		stackObj.push("4 of Diamond");
		stackObj.push("5 of Diamond");
		stackObj.push("6 of Diamond");
		stackObj.push("7 of Diamond");
		stackObj.push("8 of Diamond");
		stackObj.push("9 of Diamond");
		stackObj.push("10 of Diamond");
		stackObj.push("Jack of Diamond");
		stackObj.push("Queen of Diamond");
		stackObj.push("King of Diamond");
		
		stackObj.push("Ace of Spade");
		stackObj.push("2 of Spade");
		stackObj.push("3 of Spade");
		stackObj.push("4 of Spade");
		stackObj.push("5 of Spade");
		stackObj.push("6 of Spade");
		stackObj.push("7 of Spade");
		stackObj.push("8 of Spade");
		stackObj.push("9 of Spade");
		stackObj.push("10 of Spade");
		stackObj.push("Jack of Spade");
		stackObj.push("Queen of Spade");
		stackObj.push("King of Spade");
	}
	
	public static void unloadDeck() {
		for (int i=0; i<stackSize; i++) {
			stackObj.pop();
		}
	}
	
	public static int checkSize() {
		int stackSize = stackObj.size();
		System.out.println("Stack Size: " + stackSize);
		return stackSize;
	}
	
	public static boolean checkForCard(String card) {
		boolean found = false;
		if (stackObj.contains(card)) {
			found = true;
		}
		return found;
	}
	
	public static String accessOneParticularCard (String card) {
		String selectedCard = stackObj.access(card);
		return selectedCard;
	}

}
