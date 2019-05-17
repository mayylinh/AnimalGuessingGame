package hw5;

//Design a Guessing game where the computer tries to determine what type of 
//animal the user is thinking of.

public class HW5 
{
    public static void main(String[] args) 
    {
        //In Main.java, create a new instance of GuessingGame, passing in a root 
        //question and two root answers.
        GuessingGame game = new GuessingGame("Does your animal live in the water?",
                                             "elephant", "shark");
        game.play();        
    }
}
