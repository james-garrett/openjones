/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.map;

import java.util.ArrayList;
import main.java.jones.actions.Action;
import main.java.jones.general.Position;

/**
 *
 * @author dimid
 */
public class SecurityHousing extends House{

    public SecurityHousing(Position pos, String name, int pricePerMonth) {
        super(pos, name, pricePerMonth);
        
    }

 
    @Override
    public int getRelaxHealthEffect() {
        return 7;
    }

    @Override
    public int getRelaxHappinessEffect() {
        return 7;
    }

      
}
