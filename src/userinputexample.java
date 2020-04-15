import java.util.Scanner;  // Import the Scanner class

public class userinputexample {


        public static void main(String[] args) {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Do you want to play one player or two player");

            String userName = myObj.nextLine();  // Read user input
            System.out.println("Game setting: " + userName);  // Output user input

    }
}
