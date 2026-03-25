/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.map;

import main.java.jones.general.Position;

/**
 *
 * @author dimid
 */
public class LowCostHousing extends House {

    /** Create a new Building
    *
    * @param pos
    */
    public LowCostHousing (Position pos, String name, int pricePerMonth) {
        super(pos, name, pricePerMonth);
        
    }


    @Override
    public int getRelaxHealthEffect() {
        return 3;
    }

    @Override
    public int getRelaxHappinessEffect() {
        return 3;
    }

  
    
}
