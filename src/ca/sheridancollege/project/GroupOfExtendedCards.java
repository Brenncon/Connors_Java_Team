/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * @author Connor Brennan
 */
public class GroupOfExtendedCards extends GroupOfCards{
    
    //Variable declaration
    private int[] playersHand = new int[10];
    private int[] dealersHand = new int[10];
    private Card_Generator cardGen = new Card_Generator();
    
    /**
     * The constructor inherited from the super class GroupOfCards
     * @param givenSize the specified size of the group of cards
     */
    public GroupOfExtendedCards(int givenSize) {
        super(givenSize);
    }

    /**
     * The getter method for the playersHand array.
     * @return the the playersHand array.
     */
    public int[] getPlayersHand() {
        return playersHand;
    }

    /**
     * The setter method for the playersHand array.
     * @param playersHand set the playerHand array to be equal
     * to the incoming array.
     */
    public void setPlayersHand(int[] playersHand) {
        this.playersHand = playersHand;
    }

    /**
     * The getter method for the dealerHand array.
     * @return the dealerHand array.
     */
    public int[] getDealersHand() {
        return dealersHand;
    }

    /**
     * The setter method for the dealerHand array.
     * @param dealersHand set the dealerHand array to be equal
     * to the incoming array.
     */
    public void setDealersHand(int[] dealersHand) {
        this.dealersHand = dealersHand;
    }
}
