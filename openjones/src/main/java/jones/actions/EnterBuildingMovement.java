/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.actions;

import main.java.jones.general.PlayerPosition;
import main.java.jones.general.PlayerState;
import main.java.jones.map.Building;

/**
 *
 * @author dimid
 */
public class EnterBuildingMovement extends Movement {
    
    /**
     * The time it takes to enter a building
     */
    public static final int ENTER_BUILDING_DURATION = 2;    
    
    public EnterBuildingMovement (PlayerPosition oldpos, Building build) {
        super(new PlayerPosition(oldpos), new PlayerPosition(oldpos));
        _newPos.enterBuilding();
    }
              
    @Override
    public int timeEffect(PlayerState playerState) {
            return ENTER_BUILDING_DURATION;
        
    }

     
    @Override
    protected void doAction(PlayerState playerState) {
        playerState.setPos(getNewPos());
        //_build.prepareForPlayerEntrance(playerState);
        playerState.setActionsTree(null);
        //
        playerState.affectTime(ENTER_BUILDING_DURATION);
        
    }
    
    @Override
    public String toString () {
        return "Enter";
    }

}
