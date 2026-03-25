/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.actions.Action;
import main.java.jones.general.PlayerState;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
class UpdateJobMarker extends PlanMarker {

    public UpdateJobMarker(Plan plan, Action action) {
        super(plan, action);
    }

    @Override
    public void changeState(PlayerState playerState) {
        _plan.setLastJob(playerState.getJob());
    }

    
}
