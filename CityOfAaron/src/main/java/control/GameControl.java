/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.Random;
import model.*;

/**
 *
 * @author Andrea Rochira
 */

public class GameControl {
    
    private static Random randValue = new Random();
    
    /** Hint from Brother Anderson
     *  Protected setter for tests to inject a mock random number
     * @param random
     */ 
    protected static void setRandValue(Random random){
        randValue = random;
    }
    
    public static int getRandomValue(int lowValue, int highValue){
    
        if( lowValue < 0 || highValue < 0 ) {
            return -1;
        } 

        if( highValue <= lowValue ){
            return -2;
        }

        if ( highValue == Integer.MAX_VALUE){
            return -3;
        }

        return randValue.nextInt(highValue + 1 - lowValue) + lowValue;
    } 
    
    /**
     * Process the current year's results and update the Game object.
     * 
     * @param game The current Game object (pass by reference)
     * @param tithesPercent The percentage of tithing selected for the year
     * @param bushelsForFood The number of bushels of wheat allocated as food for the year
     * @param acresToPlant The number of acres to be used for planing
     * 
     * @return The year's Annual Report data
     */
    
    public static AnnualReport liveTheYear(
           Game game, int tithesPercent, int bushelsForFood, int acresToPlant) {
        
        //if(game == null || tithesPercent < 0 || tithesPercent > 100 || bushelsForFood < 0 || acresToPlant < 0){
            //return null;
        //}
        
        AnnualReport report = new AnnualReport();
        //report.setLandPrice(LandControl.getCurrentLandPrice());
        
        //int totalWheat = game.getWheatInStorage();
        
        //int harvested = WheatControl.calculateHarvest(tithesPercent, acresToPlant);
        //int tithingAmount = (int)(double)((tithesPercent/100.0) * harvested);
        //int lostToRats = WheatControl.calculateLossToRats(wheatIn, tithesPercent);
       
        return report;     
    }
}
