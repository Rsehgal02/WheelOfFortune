import java.util.*;
public class WheelOfFortune {
	private static String chosenCategory;
	private static String difficulty;
	private static ArrayList<String> guessedLetters;
	public static String word() {
		ArrayList<String> subset = new ArrayList<String>();
		String chosenSubset = "";
		String randomlygeneratedWord = "";
		String[] category = {"Sports" , "Movies" , "Animals", "Food" , "Nature"};
		int choose = (int) (Math.random() * 5);
		chosenCategory = category[choose];
		if(difficulty.equals("easy")) {
			if(chosenCategory.equals("Sports")) { 
				subset.add("cricket");
				subset.add("tennis");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			if(chosenCategory.equals("Movies")) { 
				subset.add("titanic");
				subset.add("gravity");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Animals")) { 
				subset.add("dog");
				subset.add("cat");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Food")) { 
				subset.add("chips");
				subset.add("pizza");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Nature")) { 
				subset.add("sun");
				subset.add("water");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
		}
		else if(difficulty.equals("medium")) {
			if(chosenCategory.equals("Sports")) { 
				subset.add("basketball");
				subset.add("football");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Movies")) { 
				subset.add("martian");
				subset.add("rocky");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Animals")) { 
				subset.add("bird");
				subset.add("sheep");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Food")) { 
				subset.add("noodles");
				subset.add("banana");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Nature")) { 
				subset.add("trees");
				subset.add("oxygen");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
		}
		else if(difficulty.equals("hard")) {
			if(chosenCategory.equals("Sports")) { 
				subset.add("lacrosse");
				subset.add("archery");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Movies")) { 
				subset.add("rambo");
				subset.add("interstellar");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Animals")) { 
				subset.add("koala");
				subset.add("ostrich");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Food")) { 
				subset.add("paneer");
				subset.add("kebab");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
			else if(chosenCategory.equals("Nature")) { 
				subset.add("minerals");
				subset.add("chlorophyll");
				int nextChoose = (int) (Math.random() * 2);
				chosenSubset += subset.get(nextChoose);
			}
		}
		randomlygeneratedWord += chosenSubset;
		return randomlygeneratedWord;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Wheel of Fortune.");
		guessedLetters = new ArrayList<String>();
		int guesses = 10;
		ArrayList<String> words = new ArrayList<String>();
		WheelOfFortune i = new WheelOfFortune();
		System.out.println("What should the difficulty be? easy,medium, or hard?");
		Scanner newInput = new Scanner(System.in);
		String chosenDifficulty = newInput.nextLine().toLowerCase();
		if(chosenDifficulty.equals("easy")) {
			difficulty = "easy";
		}
		else if(chosenDifficulty.equals("medium")) {
			difficulty = "medium";
		}
		else if(chosenDifficulty.equals("hard")) {
			difficulty = "hard";
		}
		String randomlyMadeWord = i.word();
		words.add(randomlyMadeWord);
		ArrayList<String> display = new ArrayList<String>();
		for(int j = 0 ; j<randomlyMadeWord.length(); j++) {
			display.add("_ ");
		}
		System.out.println("Guesses left:" + guesses);
		System.out.println("The category is " + chosenCategory);
		System.out.println(display);
	    while(guesses > 0) {
	    	System.out.println("Guess a letter in the hidden word");
	    	boolean isGuessed = false;
	    	Scanner input = new Scanner(System.in);
	    	String guessedLetter = input.nextLine().toLowerCase();
	    	if(randomlyMadeWord.indexOf(guessedLetter) > -1) {
	    		for(int j = 0; j<randomlyMadeWord.length();j++) {
	    			if(randomlyMadeWord.substring(j, j+1).equals(guessedLetter)) {
	    				display.set(j, guessedLetter);
	    			}
	    		}
	    		
	    	}
	    	if(randomlyMadeWord.indexOf(guessedLetter) == -1 || randomlyMadeWord.indexOf(guessedLetter) > -1){
	    		for(int k = 0; k < guessedLetters.size(); k++) {
	    			if(guessedLetters.get(k).equals(guessedLetter)) {
	    				isGuessed = true;
	    				System.out.println("This letter has already been guessed.");
	    			}
	    		}
	    		if(randomlyMadeWord.indexOf(guessedLetter)==-1 && isGuessed==false)
                {
	    			guesses--;
	    		}
	    	}
	    	
	    	guessedLetters.add(guessedLetter);
	    	System.out.println(display);
	    	boolean isWon = true;
	    	for(int j = 0; j < display.size(); j++) {
	    		if(isWon && display.get(j) == "_ ") {
	    			isWon = false;
	    		}
	    	}
	    	if(isWon == true) {
	    		guesses = -1;
	    		System.out.println("Win! ");
	    	}
	    	else {
	    		System.out.println("Guesses left:" + guesses);
	    	}
	    }
	    if(guesses == 0) {
	    	System.out.println("Game over! ");
	    	System.out.println("The word was " + randomlyMadeWord);
	    }

	}

}
