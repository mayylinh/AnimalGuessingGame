package hw5;

import TreePackage.DecisionTreeInterface;
import TreePackage.DecisionTree;
import java.util.Scanner;
import java.util.Iterator;

public class GuessingGame
{
    private DecisionTreeInterface<String> tree;
    private Scanner keyboard = new Scanner(System.in);
    private String answer = "";

    public GuessingGame(String question, String noAnswer, String yesAnswer)
    {
        DecisionTree<String> no = new DecisionTree<>(noAnswer);
        DecisionTree<String> yes = new DecisionTree<>(yesAnswer);
        tree = new DecisionTree<>(question, no, yes);
    }

    /* In GuessingGame.play(), the program should ask the root question. When the 
    user answers ‘yes’ or no’, call either tree.advanceToYes() or tree.advanceToNo() 
    which should move the currentNode variable within the DecisionTree either left 
    or right. Keep asking questions at each level until an answer node is reached 
    i.e. a leaf). Finally, guess the ‘answer’ contained at that leaf.
        ● If the user says ‘yes’ print out “I win”
        ● If the user says “no”, call the ‘learn’ method */
    public void play()
    {
        // TODO
        String again = "Y";
        while (again.equals("Y"))
        {
            System.out.println(tree.getRootData());
            while (!tree.isAnswer())
            {
                answer();
                if (answer.equals("yes"))
                {
                    tree.advanceToYes();
                    answer = "";
                    if (!tree.getCurrentData().equals(tree.getRootData()) && !tree.isAnswer())
                        System.out.println("\n" + tree.getCurrentData());
                }
                else 
                {
                    tree.advanceToNo();
                   answer = "";
                    if (!tree.getCurrentData().equals(tree.getRootData()) && !tree.isAnswer())
                        System.out.println("\n" + tree.getCurrentData());
                }
            }
            answer = "";
            System.out.println("\nIs your animal a(n) " + tree.getCurrentData() + "?");
            answer();
            
            if (answer.equals("yes"))
            {
                answer = "";
                System.out.println("\nI win.");
                seeOrder();
            }
            else
            {
                learn();
                answer = "";
                seeOrder();
            }

            /* After each round, the program should ask the user if they want to play 
            again. If the user selects yes, the game should set currentNode to the root 
            of the tree. If the learn method was called at the end of the previous game, 
            the tree should now be bigger. DO NOT stop running the program after each 
            game as we are not backing up the data and your tree will reset each time. */
            answer = "";
            System.out.println("\nWould you like to play again?");
            answer();
            if (answer.equals("yes"))
            {
                tree.resetCurrentNode();
                again = "Y";
                answer = "";
                System.out.println("\n");
            }
            else
            {
                System.out.println("\nThank you for playing Animal Guessing Game.");
                again = "N";
            }
        }
    }

    /* The learn() method should ask the user what animal they were thinking of. 
    Then it should ask the user to give a question for which the answer is “yes” 
    for the animal the user was thinking of and “no” otherwise. It should then 
    properly set the data. */
    public void learn()
    {
        // TODO
        String question, animal, wrong;
        DecisionTree<String> subtree, computer, user;
        
        System.out.println("\nWhat animal were you thinking of?");
        animal = keyboard.nextLine();
        System.out.println("\nPlease provide a question for which the answer yes "
                           + "describes your animal and no describes my guess.");
        question = keyboard.nextLine();
        
        wrong = tree.getCurrentData();
        computer = new DecisionTree<>(wrong);
        user = new DecisionTree<>(animal);
                
        tree.setCurrentData(question);
        tree.setResponses(wrong, animal);
                                
        subtree = new DecisionTree<String>(question, computer, user);
    }
    
    public void answer()
    {
        while (!answer.equals("yes") && !answer.equals("no"))
        {
            System.out.println("Please enter \"yes\" or \"no\"");
            answer = keyboard.nextLine();
        }
    }
    
    /* After each round of the game (and adding to the decision tree with the learn 
    method if necessary) allow the user to print a traversal through your tree with 
    either a PreorderIterator or LevelOrderIterator object. */
    public void seeOrder()
    {
        String view = "";
        System.out.println("\nWould you like to view this Animal Guessing Game's Tree?");
        answer();
        if (answer.equals("yes"))
        {
            System.out.println("\nWould you like the Tree to be in preorder or levelorder?");
            while (!view.equals("preorder") && !view.equals("levelorder"))
            {
                System.out.println("Please enter \"preorder\" or \"levelorder\"");
                view = keyboard.nextLine();
            }
            
            if (view.equals("preorder"))
            {
                System.out.println();
                Iterator<String> preordered = tree.getPreorderIterator();
                while (preordered.hasNext()) 
                    System.out.println(preordered.next());
            }
            else
            {
                System.out.println();
                Iterator<String> levelordered = tree.getLevelOrderIterator();
                while (levelordered.hasNext()) 
                    System.out.println(levelordered.next());
            }
        }
    }
}