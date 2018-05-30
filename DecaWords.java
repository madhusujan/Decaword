import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class DecaWords {

    public static void main(String[] args) throws IOException {
        //System.out.print(new File(".").getAbsoluteFile());

        // get the player name
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your name: ");
        String user_name = input.nextLine();

        // get the file.
        File my_file = new File("engmix.txt");
        Scanner scn = new Scanner(my_file);

        int points = 0;
        for(int i = 0; i < 10; i++){
            int point = runner(scn);
            points += point;
            System.out.printf("Your Total point is %d. \n", points);
        }

        if(points > 50){
            System.out.printf("%s, you are the student of the year. \n", user_name);
        } else {
            System.out.printf("%s, I know you can do better than this. Best of luck for the next time.", user_name);
        }

    }

    private static int runner(Scanner scn) {
        String random_word = get_random_word(scn); // get random word.

        ShuffleString shuffle = new ShuffleString(random_word);
        String shuffled_word = shuffle.getWord(); // get the string with shuffled letters.
        System.out.printf("Guess this word: %s. \n", shuffled_word);

        // take the user input
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Your answer: ");
        String input = keyboard.nextLine();

        // help
        if(Objects.equals(input, "help")){
            System.out.printf("The word starts with %s and ends with %s. \n", random_word.charAt(0), random_word.charAt(random_word.length()-1));
            System.out.print("Want to guess now? Your answer is: ");
            input = keyboard.nextLine();
        }

        // verdict
        int points = 0;
        if(Objects.equals(input, random_word)){
            System.out.print("Oh yeah. That's how we do it. ");
            points += 10;
        } else {
            System.out.printf("Oops. The right word is %s. ", random_word);
            points -= 10;
        }
        System.out.printf("you got %d. \n", points);
        return points;
    }


    private static String get_random_word(Scanner scn) {

        Random rand = new Random();
        int num = rand.nextInt(10000);

        String word ="";
        for (int i = 0; i < num; i++){
            word = scn.nextLine();
        }
        return word;
    }}