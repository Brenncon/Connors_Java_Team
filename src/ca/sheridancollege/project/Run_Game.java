/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Connor Brennan
 */
public class Run_Game {
    public static void main(String[] args)
    {
        //The welcome screen which collects the users name
        System.out.println("Welcome to Blackjack!");
        System.out.println("Please enter your name:");
        Scanner sc = new Scanner(System.in);
        String usersName = sc.nextLine();
        
        //Variable and class instance declaration
        Card_Generator cardGen = new Card_Generator();
        GroupOfExtendedCards cardGroup = new GroupOfExtendedCards(10);
        Full_Player fPlayer = new Full_Player(usersName);
        fPlayer.setPlayerName(usersName);
        Blackjack bJack = new Blackjack(usersName+"'s Game");
        boolean endGame = false;
        int storage = 0;
        int counter = 0;
        int counterTwo = 0;
        int[] storageArray = new int[10];
        int[] storageArrayTwo = new int[10];
        String dChoice = "";
        String pChoice = "";
        String result = "";
        int scoreHolder = 0;
        
        //Asks the user to choose between playing or quiting, while addressing 
        //them by their name previously given above.
        System.out.println("Welcome "+fPlayer.getPlayerName()+", What would you like to do?");
        System.out.println("Enter 'play' to play a game of blackjack.");
        System.out.println("Enter 'exit' to exit.");
        String usersChoice = sc.nextLine();
        System.out.println("");
        
        //if the user choose exit, greet the user goodbye by name and 
        //close the program. If the user choose play, generate the 
        //first two cards for the users and dealers hand.
        while(!usersChoice.equals("play") || !usersChoice.equals("exit")){
            if (usersChoice.equals("play")){
            
                    cardGen.fillNumList();
                    
                    storage = cardGen.generateRandomCardNum();
                    storageArray[counter] = storage;
                    counter = counter + 1;
                    storage = cardGen.generateRandomCardNum();
                    storageArray[counter] = storage;
                    counter = counter + 1;
                    cardGroup.setPlayersHand(storageArray);
                    
                    storage = cardGen.generateRandomCardNum();
                    storageArrayTwo[counterTwo] = storage;
                    counterTwo = counterTwo + 1;
                    storage = cardGen.generateRandomCardNum();
                    storageArrayTwo[counterTwo] = storage;
                    counterTwo = counterTwo + 1;
                    cardGroup.setDealersHand(storageArrayTwo);
                    
                //While the user has not typed 'exit' the game will go on 
                //repeatedly until it has been entered.
                while (endGame == false){
                    
                    //Display the current dealer, and users score. As well as 
                    //what cards are in the dealers hand, and what cards are
                    //in the players hand.
                    System.out.println("Dealer's Score:  "+bJack.getDealersScore()+
                            " "+fPlayer.getPlayerName()+"'s Score:  "+bJack.getPlayersScore());
                    System.out.println("");
                    System.out.print("Dealer's Hand: ");
                    storageArrayTwo = cardGroup.getDealersHand();
                    for (int i = 0; i < counterTwo; i++){
                        System.out.print(storageArrayTwo[i]+" ");
                    }
                    System.out.println("");
                    System.out.print(fPlayer.getPlayerName()+"'s Hand: ");
                    storageArray = cardGroup.getPlayersHand();
                    for (int i = 0; i < counter; i++){
                        System.out.print(storageArray[i]+" ");
                    }
                    
                    //Ask the user if they want another card, if they want to 
                    //keep their current hand, or if they wish to exit the 
                    //game and stop playing all together.
                    System.out.println("");
                    System.out.println("Your turn, you may choose to do one of the following:");
                    System.out.println("1. Enter 'hit me' to get another card.");
                    System.out.println("2. Enter 'stay' to keep your hand as is.");
                    System.out.println("3. Enter 'exit' to stop playing.");
                    System.out.println("Your choice: ");
                    usersChoice = sc.nextLine();
                    System.out.println("");
                    
                    //If the user chosoe to eixt, exit the game afetr greeting
                    //the player goodbye by name.
                    if(usersChoice.equals("exit")){
                        endGame = true;
                    }
                    
                    //If the user choose 'hit me'. Then generate a new card
                    //and put it into the players hand. Which will be displayed
                    //screen afterwards.
                    else if(usersChoice.equals("hit me")){
                        pChoice = "hit me";
                        storage = cardGen.generateRandomCardNum();
                        storageArray[counter] = storage;
                        cardGroup.setPlayersHand(storageArray);
                        counter = counter + 1;
                        
                    }
                    
                    //If the user choose to stay, set the pChoice string to 
                    //be 'stay'.
                    else if(usersChoice.equals("stay")){
                        pChoice = "stay";
                    }
                    
                    //If a diffrent answer is given that does not 
                    //fit any of the above options, inform the user
                    //the choice was invalid and to please try again.
                    else{
                        System.out.println("That was not a valid answer, please try again.");
                        System.out.println("Your choice: ");
                        usersChoice = sc.nextLine();
                    }
                    
                    //Call the dealer to make there choice on what to do.
                    dChoice = bJack.dealersChoice();
                    
                    //If both the dealer and user choose to keep there 
                    //current hand of cards, then a face off happens to 
                    //see whether the user, dealer, or neither won. Then a 
                    //message is printed on the screen informing the user
                    //of the result of the face off.
                    if(dChoice.equals("stay") && pChoice.equals("stay")){
                        System.out.println("");
                        System.out.println("The dealer has chosen to stay.");
                        System.out.println("Time to face off!");
                        System.out.println("");
                        result = bJack.faceOff(cardGroup.getPlayersHand(), cardGroup.getDealersHand());
                        
                        if(result.equals("player wins")){
                            System.out.println(fPlayer.getPlayerName()+" Wins!");
                            System.out.println("");
                            scoreHolder = bJack.getPlayersScore();
                            bJack.setPlayersScore(scoreHolder+1);
                        }
                        else if(result.equals("dealer wins")){
                            System.out.println("Dealer Wins :(");
                            System.out.println("");
                            scoreHolder = bJack.getDealersScore();
                            bJack.setDealersScore(scoreHolder+1);
                        }
                        else if(result.equals("It's a draw")){
                            System.out.println("It's a draw, no one wins :/");
                            System.out.println("");
                        }
                        else{
                            System.out.println("Something went wrong in the results.");
                        }
                        
                        //resets the users and dealers hand for the next round.
                        for (int i = 0; i < 10; i++){
                            storageArray[i] = 0;
                            storageArrayTwo[i] = 0;
                        }
                        counter = 0;
                        counterTwo = 0;
                        
                        cardGroup.setPlayersHand(storageArray);
                        cardGroup.setDealersHand(storageArrayTwo);
                        
                        //generates the first two cards for the user and 
                        //dealers hands for the next round.
                        cardGen.fillNumList();
                    
                        storage = cardGen.generateRandomCardNum();
                        storageArray[counter] = storage;
                        counter = counter + 1;
                        storage = cardGen.generateRandomCardNum();
                        storageArray[counter] = storage;
                        counter = counter + 1;
                        cardGroup.setPlayersHand(storageArray);
                    
                        storage = cardGen.generateRandomCardNum();
                        storageArrayTwo[counterTwo] = storage;
                        counterTwo = counterTwo + 1;
                        storage = cardGen.generateRandomCardNum();
                        storageArrayTwo[counterTwo] = storage;
                        counterTwo = counterTwo + 1;
                        cardGroup.setDealersHand(storageArrayTwo);
                    }
                    
                    //If the dealer chooses 'hit me', then a new card is 
                    //generated and added to the dealers hand. A messsage is 
                    //also displayed informing the user of the choice.
                    else if (dChoice.equals("hit me")){
                        System.out.println("");
                        System.out.println("The dealer has decided 'hit me'.");
                        System.out.println("");
                        storage = cardGen.generateRandomCardNum();
                        storageArrayTwo[counterTwo] = storage;
                        cardGroup.setDealersHand(storageArrayTwo);
                        counterTwo = counterTwo + 1;
                    }
                    
                    //If the dealer chooses to stay. A message is shown on
                    //screen informing the user of the dealers choice.
                    else if(dChoice.equals("stay")){
                        System.out.println("");
                        System.out.println("The dealer has chosen to stay.");
                        System.out.println("");
                    }
                    
                    //if somehow a diffrent result is made, an error will be 
                    //shown on screen informing the user of the issue.
                    else{
                        System.out.println("Error: Something went wrong with the dealer.");
                    }
                }
                
                
            }
            //If the user chooses 'exit', the game ends with a goodbye message 
            //referring to the user by name.
            else if (usersChoice.equals("exit")){
                System.out.println("Thank you for playing "+fPlayer.getPlayerName()+", goodbye.");
                break;
            }
            
            //If a diffrent answer not listed is given, the program will inform
            //the user of the issue. Asking the user to enter in a diffrent 
            //choice.
            else{
                System.out.println("That was not a valid answer, please try again.");
                usersChoice = sc.nextLine();
            }
        }
    }
}
