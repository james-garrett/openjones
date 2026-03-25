/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.actions;

import main.java.jones.general.PlayerPosition;
import main.java.jones.general.PlayerState;
import main.java.jones.general.Position;
import main.java.jones.map.Building;

/**
 *
 * @author dimid
 */
public class ExitBuildingMovement extends Movement{

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ExitBuildingMovement other = (ExitBuildingMovement) obj;
          
        if (!this._oldPos.equals( other._oldPos)) {
            return false;
        }
        return this._newPos.equals( other._newPos);
    }
    /**
     * The time it takes to exit a building
     */
    public static final int EXIT_BUILDING_DURATION = 0;    
    
    public ExitBuildingMovement (PlayerPosition oldpos, Building build) {
        super(new PlayerPosition(oldpos), new PlayerPosition(oldpos));
        _newPos.exitBuilding();
    }
 
    public ExitBuildingMovement (Position oldpos, Building build) {
//        this(new PlayerPosition(oldpos,true), build);
        super(new PlayerPosition(oldpos,true), new PlayerPosition(oldpos,false));     
    }
   
    @Override
    public int timeEffect(PlayerState playerState) {
            return EXIT_BUILDING_DURATION;
        
    }

     
    @Override
    protected void doAction(PlayerState playerState) {
        playerState.setPos(getNewPos());
        playerState.setActionsTree(null);
        playerState.affectTime(EXIT_BUILDING_DURATION);
        
    }

      
    @Override
    public String toString () {
        return "Exit";
    }

}
