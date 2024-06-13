import java.io.IOException;

public class Main {
    public static void main(String arg[]) throws IOException {
        introduction(); // start message

        Game player = new Game();

        while(player.getLife() > 0) {
            player.writeManual();
        }

        System.out.println("Your final score is " + player.getScore());
        System.out.println("Thank you for using it.");
    }

    public static void introduction() {
        System.out.println("********************************************");
        System.out.println("Hello! This is the game machine.");
        System.out.println("There are a total of 3 games here.");
        System.out.println("Three lives will be given, and one life will be reduced if you lose each game.");
        System.out.println("However, if you win, you will get points for each game.");
        System.out.println("Let's start!, Good Luck!");
    }
}
