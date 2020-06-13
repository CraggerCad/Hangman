package HangMan;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class HangManMain {
    public static void main(String[] args) {
        HangMan game = new HangMan();
        Map<Integer,String> wordList = new HashMap();
        Scanner scanObj = new Scanner(System.in);

        wordList.put(1,"hello");
        wordList.put(2,"java");
        wordList.put(3,"classes");
        Random rand  = new Random();
        int a = 1 + rand.nextInt(3);
        String word = wordList.get(a);
        game.makeMap(word);
        System.out.println();

        while(game.status && !game.win) {
            System.out.println();
            System.out.println("Enter the input");
            char input = scanObj.next().charAt(0);
            game.takeInput(input);
        }
        if(!game.status){
            System.out.println();
            System.out.println("You Loose");
        }

    }
}
