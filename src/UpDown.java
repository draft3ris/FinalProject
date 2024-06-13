import java.util.Scanner;

public class UpDown {
    private final Game game;
    private final int random;
    private int count;
    private final Scanner scn;

    public UpDown(Game game) {
        this.game = game;
        this.random = (int) ((Math.random() * 100) + 1);
        this.count = 7;
        this.scn = new Scanner(System.in);
    }

    public void doGame() {
        System.out.println("Number Up and Down Game");

        while (count > 0) {
            System.out.print("Input number (1~100) > ");
            int num = scn.nextInt();

            if (num < 1 || num > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }

            if (num > random) {
                System.out.println("Down");
            } else if (num < random) {
                System.out.println("Up");
            } else {
                System.out.println("Congratulations!");
                break;
            }
            
            count--;
        }

        System.out.println("Right answer: " + random);
        int result;
        if (count > 5){
            result = 50;
        }
        else if (count == 5){
            result = 40;
        }
        else if (count == 4) {
            result = 30;
        } 
        else if (count == 3){
            result = 20;
        }
        else if (count == 2) {
            result = 10;
        } else if (count == 1) {
            result = 5;
        } else {
            result = 0;
            game.decreaseLife();
        }

        game.setScore(result);
    }
}
