import java.util.Scanner;

public class RockScissorsPaper {
    private Game game;
    private int random;
    private int choice;
    private int result;
    private Scanner scn;

    public RockScissorsPaper(Game game) {
        this.game = game;
        this.random = (int) ((Math.random() * 3) + 1);
        this.scn = new Scanner(System.in);
    }

    public void doGame() {
    	
        System.out.println("********************************************");
        System.out.println("This is \"rock scissors paper!\" Game");
        System.out.println("What is your choice?");
        System.out.println("[1:rock 2:scissors 3:paper]");

        while (true) {
            try {
                choice = scn.nextInt();
                if (choice < 1 || choice > 3) {
                    throw new IllegalArgumentException("Invalid input. Please enter a number between 1 and 3.");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scn.nextLine();
            }
        }

        if (random == 1) {
        	
            System.out.println("Computer: rock");
            
            if (choice == 1) {
                System.out.println("Draw!");
                result = 10;
            } 
            else if (choice == 2) {
                System.out.println("You lose...");
                result = 0;
            } 
            else {
                System.out.println("You win!");
                result = 30;
            }
        } 
        
        else if (random == 2) {
        	
            System.out.println("Computer: scissors");
            
            if (choice == 1) {
                System.out.println("You win!");
                result = 30;
            } 
            else if (choice == 2) {
                System.out.println("Draw!");
                result = 10;
            } 
            else {
                System.out.println("You lose...");
                result = 0;
            }
        } 
        
        else if (random == 3) {
        	
            System.out.println("Computer: paper");
            
            if (choice == 1) {
                System.out.println("You lose...");
                result = 0;
            } 
            else if (choice == 2) {
                System.out.println("You win!");
                result = 30;
            } 
            else {
                System.out.println("Draw.");
                result = 10;
            }
        }

        game.setScore(result);
        
        if (result == 0) {
            game.decreaseLife();
        }
    }
}