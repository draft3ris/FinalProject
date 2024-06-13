import java.util.Scanner;

public class NumberBaseball {
    private Game game;
    private int chance;
    private int num;
    private int[] randomList;
    private int random;

    public NumberBaseball(Game game) {
        this.game = game;
        this.chance = 10;
        this.randomList = new int[3];
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        for (int i = 0; i < 3; i++) {
            random = (int) ((Math.random() * 10));
            randomList[i] = random;
            for (int j = i - 1; j >= 0; j--) {
                if (randomList[i] == randomList[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    public void doGame() {
        System.out.println("============== Number baseball game ==============");
        System.out.println("You must guess the 3 randomly generated digits in 10 tries!\nDigits are in range of 0~9.");
        System.out.println("Example: Generated numbers: [ ? ] [ ? ] [ ? ]\nPlayer's guess: [ 3 ] [ 6 ] [ 7 ]");
        System.out.println("Chances left: 9, Strike: 1, Ball : 1\n==================================================");
        Scanner scn = new Scanner(System.in);

        while (chance > 0) {
            int ball = 0;
            int strike = 0;
            int[] user = new int[3];
            System.out.print("Enter your guess: ");

            for (int i = 0; i < 3; i++) {
                try{
                    num = scn.nextInt();
                    if(num<0 || num>9){
                        System.out.println("Error! Enter a number between 0 and 9!");
                        i--; continue;
                    }
                    user[i] = num;
                }
                catch (Exception e){
                    System.out.println("Error! Invalid input!");
                    i--;
                    scn.nextLine();
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (randomList[i] == user[j]) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }

            if (strike == 3) {
                System.out.println("Congratulations! You have won " + ((chance) * 10) + " points!");
                System.out.println("==================================================");
                game.setScore((chance) * 10);
                return;
            } else {
                chance--;
                System.out.println("\nChance left: " + chance + ", Strike: " + strike + ", Ball: " + ball);
                System.out.println("==================================================");
            }
        }
        System.out.println("You lose!");
        game.decreaseLife();
    }
}