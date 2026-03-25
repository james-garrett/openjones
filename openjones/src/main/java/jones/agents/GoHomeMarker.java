/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.actions.Action;
import main.java.jones.general.PlayerPosition;
import main.java.jones.general.PlayerState;
import main.java.jones.map.House;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
class GoHomeMarker extends PlanMarker {

    public GoHomeMarker(Plan plan, Action action) {
        super(plan, action);
    }

    @Override
    public void changeState(PlayerState playerState) {
                
        //Player player = _plan.getAgent().getPlayer();
        House home = playerState.getRentContract().getHouse();
        _plan.setLastHome(home);
        
        PlayerPosition homePpos = new PlayerPosition(home.getPosition(), true);
        _plan.getActions().push(new MoveMarker(this._plan, null, homePpos));

    }

    
}
