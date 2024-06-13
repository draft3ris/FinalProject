import java.util.Random;
import java.util.Scanner;

public class Arrow {
	private Game game;
	private Scanner scn;
	private String list;
	private char [] array_word;
	private long startTime;
	private long endTime;
	private Random rand = new Random();
	
	public Arrow(Game game) {
		this.game = game;
		this.scn = new Scanner(System.in);
		this.list = "wsad";
		this.array_word = new char[15];
		generateRandomArray();
	}
	  
	private void generateRandomArray() {
		for(int i=0;i<15;i++){ 
			  char temp = list.charAt(rand.nextInt(4));
			  this.array_word[i]=temp;
		}
	}
	  
	public void doGame() {
		System.out.println("Enter letters corresponding to the arrows as fast as possible.");
		System.out.println("==============================");
		  
		for(int i=0; i<15; i++){
		    if(array_word[i]=='w'){
		        System.out.print("↑ ");
		    }
		    else if(array_word[i]=='s'){
		      	System.out.print("↓ ");
		    }
		    else if(array_word[i]=='a'){
		    	System.out.print("← ");
		    }
		    else if(array_word[i]=='d'){
		    	System.out.print("→ ");
		    }
		}
		  
		  
		System.out.println();
		System.out.println("==============================");
		System.out.println("(→:d , ←:a , ↑:w, ↓: s)");
		String answer= new String(array_word);
	    System.out.println("input your answer : ");
	    
	    startTime = System.nanoTime(); //Time before starting the input
	    String student_answer= scn.next();
	    
	    if(answer.equals(student_answer)){
	      endTime = System.nanoTime(); //Time after ending input
	      double secDiffTime = (endTime - startTime)/1000000000.0; //Time difference between start and end time
	      
			System.out.println("Time Taken (s) : "+secDiffTime);
			System.out.println("==============================");
			
			if(secDiffTime<5.0) {
				game.setScore(150);
			}
			else if(secDiffTime<10.0) {
				game.setScore(100);
			}
			else if(secDiffTime<15.0) {
				game.setScore(50);
			}
			else {
				System.out.println("Too much Time...");
				game.decreaseLife();
			}
	    }
	    else {
	    	System.out.println("Wrong answer!!");
	    	game.decreaseLife();
	    }
		
		
	}
}
