/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Connor Brennan
 */
public class Blackjack extends Game{
    
    //Variable declaration
    private int playersScore = 0;
    private int dealersScore = 0;
    
    /**
     * The constructor inherited from the super class Game.
     * @param givenName the name for the game.
     */
    public Blackjack(String givenName) {
        super(givenName);
    }
    
    /**
     * The method that allows the dealer to make decisions on
     * rather to stay or to get another card during the game.
     * @return what the dealer decided to do.
     */
    public String dealersChoice(){
        Random randomNum = new Random();
        int dChoice = randomNum.nextInt(2);
        if (dChoice == 1){
            return "hit me";
        }
        else{
            return "stay";
        }
    }
    
    /**
     * Accepts the players hand and dealers hand, and checks to see
     * if the player won, the dealer won or if it is a draw. Then returns
     * the result.
     * @param playerHand the array that holds the players cards.
     * @param dealerHand the array that holds the dealers cards.
     * @return the result of who won the round.
     */
    public String faceOff(int[] playerHand, int[] dealerHand){
        int playerTotal = 0;
        int dealerTotal = 0;
        for (int i = 0; i < 10; i++){
            playerTotal = playerTotal + playerHand[i];
            dealerTotal = dealerTotal + dealerHand[i];
        }
        
        if(playerTotal > 21 && dealerTotal > 21 && playerTotal < dealerTotal){
            return "player wins";
        }
        else if(playerTotal > 21 && dealerTotal > 21 && playerTotal > dealerTotal){
            return "dealer wins";
        }
        else if(playerTotal > 21 && dealerTotal > 21 && playerTotal == dealerTotal){
            return "It's a draw";
        }
        else if(playerTotal <= 21 && dealerTotal <= 21 && playerTotal < dealerTotal){
            return "dealer wins";
        }
        else if(playerTotal <= 21 && dealerTotal <= 21 && playerTotal > dealerTotal){
            return "player wins";
        }
        else if(playerTotal <= 21 && dealerTotal <= 21 && playerTotal == dealerTotal){
            return "It's a draw";
        }
        else if(playerTotal <= 21 && dealerTotal > 21){
            return "player wins";
        }
        else if(playerTotal > 21 && dealerTotal <= 21){
            return "dealer wins";
        }
        else{
            return "Something went wrong in the face off.";
        }
    }

    /**
     * The getter method for the playerScore int.
     * @return the playerScore int.
     */
    public int getPlayersScore() {
        return playersScore;
    }

    /**
     * The setter method for the playerScore int.
     * @param playersScore the incoming int that the playerScore 
     * will be set to.
     */
    public void setPlayersScore(int playersScore) {
        this.playersScore = playersScore;
    }

    /**
     * The getter method for the dealersScore int.
     * @return the dealersScore int.
     */
    public int getDealersScore() {
        return dealersScore;
    }

    /**
     * The setter method for the dealersScore int.
     * @param dealersScore the int that the dealersScore will 
     * be set to be equal to.
     */
    public void setDealersScore(int dealersScore) {
        this.dealersScore = dealersScore;
    }
    
    /**
     * Implements the play method inherited from the super class Game.
     */
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Implements the declareWinner method inherited from the super class Game.
     */
    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
