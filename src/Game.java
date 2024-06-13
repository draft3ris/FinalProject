import java.io.IOException;
import java.util.Scanner;

public class Game {
    private int score;
    private int life;
    private int choose;
    private Scanner scn;
    private UpDown game1;
    private RockScissorsPaper game2;
    private NumberBaseball game3;
    private HangMan game4;
    private Arrow game5;

    public Game() {
        score = 0;
        life = 3;
        scn = new Scanner(System.in);
    }

    public void writeManual() throws IOException {
        System.out.println("********************************************");
        System.out.println("Your life: " + life);
        System.out.println("Your score is " + score);
        System.out.println("What do you want?");
        System.out.println("Game: 1:Up-Down, 2:Rock-Scissors-Paper, 3:Number Baseball, 4:Hangman, 5:WASD / end: any other number");

        choose = scn.nextInt();
        
        System.out.println("********************************************");

        switch(choose) {
        	case 1:
        		game1 = new UpDown(this);
                game1.doGame();
                break;
                
        	case 2:
        		game2 = new RockScissorsPaper(this);
                game2.doGame();
                break;
                
        	case 3:
        		game3 = new NumberBaseball(this);
                game3.doGame();
                break;
                
        	case 4:
        		game4 = new HangMan(this);
            	game4.doGame();
            	break;
            	
        	case 5:
        		game5 = new Arrow(this);
            	game5.doGame();
            	break;
            	
            default:
            	life = 0;
        }
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void decreaseLife() {
        life--;
    }

    public int getLife() {
        return life;
    }
}
