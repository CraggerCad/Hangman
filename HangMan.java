package HangMan;

import java.util.*;


public class HangMan {

    public boolean win = false;
    private Map<Integer,Character> jumbleMap = new HashMap();
    private Map<Integer,Character> originalWord = new HashMap();
    private List<Character> guessedLetters = new ArrayList<>();
    char[] data;
    private int guesses = 0;
    public boolean status = true;

    public void makeMap(String input){
        Random rand = new Random();
        int size = input.length();
        data = input.toCharArray();
        for(int i = 0;i<size;i++){
              originalWord.put(i,data[i]);
          }
        for(int i=0;  i<size; i++){
            int a2 = 1 + rand.nextInt(6);
            if(a2%3 == 0){
                System.out.println("a2="+a2);
                jumbleMap.put(i,data[i]);
            }
            else{
                jumbleMap.put(i,'_');
                guesses++;
            }
              }
        for(Map.Entry<Integer,Character> entry:jumbleMap.entrySet()){
                  System.out.print(entry.getValue()+" ");
              }
        System.out.println();
        System.out.println("Guesses = "+guesses);
    }

    public void takeInput(char input){
        boolean letterStatus = false;
        int i = -1;
        if (guessedLetters.contains(input)) {
            System.out.println("Guesses left = "+guesses);
            System.out.println("Already Guessed");
            return;
        }
        for (Map.Entry<Integer, Character> entry : originalWord.entrySet()) {
                i++;
                if (input == entry.getValue()) {
                    System.out.println("Correct Guess");
                    System.out.println("Guesses = "+guesses);
                    jumbleMap.put(i, input);
                    letterStatus = true;
                }
            }
        if(!letterStatus && !guessedLetters.contains(input)){
                System.out.println("Wrong guess");
                guesses--;
                System.out.println("Guesses = "+guesses);
            if(guesses == 0){
                status = false;
            }
            }
        guessedLetters.add(input);
        displayGame();
        winStatus();
    }

    public void winStatus(){
        if(jumbleMap.equals(originalWord)){
            System.out.println();
            System.out.println("You Win");
            win = true;
        }
    }

    public void displayGame(){
        for(Map.Entry<Integer,Character> entry:jumbleMap.entrySet()){
            System.out.print(entry.getValue()+" ");
        }
    }
}
