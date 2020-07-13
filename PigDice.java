import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PigDice {
    final String [] diceVal ={null,"1","2","3","4","5","6"};

    private String genVal(){
        /*
        Fen
         */
        Random randVal =new Random();
        return diceVal[randVal.nextInt(6)+1];
    }

    private boolean validate(String val,People player){
        int turnScore =Integer.parseInt(val);
        if(turnScore!=1){
            player.addScore(turnScore);
            return true;
        }else {
            player.setUserScore(0);
            System.out.println("Don't Be So greedy You will lose !");
            return false; // Round Termination
        }
    }


    public static void main(String[]args){
        PigDice dice =new PigDice();
        System.out.println("Welcome to Pig Dice Game !");
        System.out.println("Let's begin the gameplay ...");
        People player1 =new People();
        while (player1.getUserScore()<100) {
            System.out.printf("Player 1 Score %d%n", player1.getUserScore());
            System.out.println("Would you Like to ROll the Dice ?");
            Scanner sc = new Scanner(System.in);
            String userOpt = sc.next();
            if (player1.userOptValidation(userOpt)) {
                boolean flag =dice.validate(dice.genVal(), player1);
                if(flag){
                    continue;
                }else
                    player1.setRoundScore();
                    break;
            }
            else {
                player1.setRoundScore();
                System.out.println("You passed your turn !");
                break;
            }
        }


    }

}
class People{
    private int userScore =0;
    private ArrayList <Integer> roundScore =new ArrayList<Integer>();


    public int getUserScore(){
        /*
        Accessing the Intermediate score of the user
         */
        return this.userScore;
    }
    public void setUserScore(int userScore){
        /*
        used when needed to zero out the score EG:- when 1 is rolled
         */
        this.userScore=userScore;
    }
    public void addScore(int userScore){
        /*
        incrementing the intermediate user score
         */
        this.userScore=this.userScore+userScore;
    }
    public void setRoundScore(){
        /*
        Storing the final score of the user turn called in if user decides to not to
        roll or when turn exists
         */
        this.roundScore.add(this.userScore);
    }

    public boolean userOptValidation(String userOpt){
        /*
        Prompt validation
         */
        if (userOpt.toLowerCase().equals("y")){
            return true;
        }else{
            return false;
        }
    }

}
