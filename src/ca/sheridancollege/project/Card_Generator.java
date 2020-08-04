/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Random;

/**
 *
 * @author Connor Brennan
 */
public class Card_Generator {
    
    //Variable declaration
    private int[] cardNumsGenerated = new int[10];
    private int counter = 0;
    
    /**
     * A method that generates random numbers between 1 and 11, based on what 
     * numbers have and have not been generated before by checking the cardNumsGenerated
     * array.
     * @return a randomly generated number between 1 and 11
     */
    public int generateRandomCardNum(){
        Random randomNum = new Random();
        int storage = 1+randomNum.nextInt(10);
        boolean matchFound = false;
        while (matchFound = false){
            
            for (counter = 0; counter < 10; counter++){
                if (storage == cardNumsGenerated[counter]){
                    cardNumsGenerated[counter] = 0;
                    matchFound = true;
                    return storage;
                
                }
                else if (counter == 10 && storage != cardNumsGenerated[counter]){
                    storage = 1+randomNum.nextInt(10);
                }
            }
        }
        return storage;
    }
    
    /**
     * This simple method fills an array to let the program check what
     * numbers have been generated or not before. 
     */
    public void fillNumList(){
        for (int i = 1; i < 11; i++){
            cardNumsGenerated[i-1] = i;
        }
    }
}
