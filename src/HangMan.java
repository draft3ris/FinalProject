import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HangMan {
    private Game game;
    private int correctCount;
    private int choiceCount;
    private int wrongCount;
    private int state;
    private Scanner scn;
    
    public HangMan(Game game) {
        this.game = game;
        this.correctCount = 0;
        this.choiceCount = 0;
        this.wrongCount = 0;
        this.state = 0;
        this.scn = new Scanner(System.in);
    }
    
    public void doGame() throws IOException {
        ArrayList<String> word = new ArrayList<>();
		Scanner fileReader = new Scanner(new File("word.txt"));
		while(fileReader.hasNextLine()){
			word.add(fileReader.nextLine());
		}
		int random_index = (int) (Math.random() * word.size());
        String[] word2 = word.get(random_index).split("");
        String[] dash = new String[word2.length];
	    System.out.println("Welcome to the Hangman game.");
	    
	    for(int i=0;i<word2.length; i++){
	      dash[i] = "-";
	    }
	    
	    while(true){
	    	state = correctCount;
	    	System.out.print("Word to guess => ");
	    	for(int i=0;i<word2.length; i++){
	    		System.out.print(dash[i]);
	    	}
	    	System.out.println();
	    	System.out.print("Please enter an alphabet character (Tries: "+choiceCount+", Wrong count: "+wrongCount+") > ");
	    	String select = scn.nextLine();
	
	    	for(int i=0;i<word2.length;i++){
	    		if(word2[i].equals(select)){
	    			dash[i] = select;
	    			correctCount++;
	    		}
	    	}
	    	if(correctCount==state){
	    		wrongCount++;
	    		System.out.println("Incorrect letter. Wrong count: "+wrongCount);
	    		picture(wrongCount);    
	    	}
	
	    	System.out.println();
	    	if(wrongCount==7 || correctCount == word2.length){
	    		break;
	    	}
	    	choiceCount++;
	    }
	    
	    System.out.println();
	    choiceCount++;
	    System.out.print("Answer:");
	    for(int i=0;i<word2.length;i++){
	      System.out.print(word2[i]);
	    }
	    System.out.println(" (Attempts: "+choiceCount+")");
	    if(wrongCount >= 7){
            game.decreaseLife();
            game.setScore(0);
        }
        else if(correctCount >= word2.length){
	      System.out.println("Congratulations!!! Hangman lived.");
          System.out.println("You've earned 100 points!");
	      game.setScore(100);
	    }
	    fileReader.close();
    }
    
	 public static void picture(int wrongCount){
		switch(wrongCount){
			case 0:
				System.out.println("┌──────┬──────┐");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 1:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 2:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│      ┼      │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 3:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│     ─┼      │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 4:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│     ─┼─     │");
				System.out.println("│             │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 5:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│     ─┼─     │");
				System.out.println("│      ┴      │");
				System.out.println("│             │");
				System.out.println("└─────────────┘");
				break;
			case 6:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│     ─┼─     │");
				System.out.println("│      ┴      │");
				System.out.println("│     |       │");
				System.out.println("└─────────────┘");
				break;
			case 7:
				System.out.println("┌──────┬──────┐");
				System.out.println("│      O      │");
				System.out.println("│     ─┼─     │");
				System.out.println("│      ┴      │");
				System.out.println("│     | |     │");
				System.out.println("└─────────────┘");
				System.out.println("Hangman died. ᅲᅲ");
				break;
		}
	}
}
