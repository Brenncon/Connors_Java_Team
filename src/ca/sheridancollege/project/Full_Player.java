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
public class Full_Player extends Player {

    //Variable declaration
    private String playerName;
    
    /**
     * The constructor inherited from the super class Player.
     * @param name the name of the player.
     */
    public Full_Player(String name) {
        super(name);
    }

    /**
     * The getter method for the playerName string.
     * @return the playerName string.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * The setter method for the playerName string.
     * @param playerName set the playerName string to be equal 
     * to the incoming string.
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     * Implements the play method inherited from the super class Player
     */
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
