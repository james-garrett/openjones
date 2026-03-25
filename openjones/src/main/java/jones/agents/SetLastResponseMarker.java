/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.actions.Action;
import main.java.jones.actions.ActionResponse;
import main.java.jones.general.PlayerState;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
class SetLastResponseMarker extends PlanMarker {
    private final ActionResponse _lastResp;

    public SetLastResponseMarker(Plan plan, Action action, ActionResponse lastResp) {
        super(plan, action);
       _lastResp = lastResp;
    }

    @Override
    public void changeState(PlayerState playerState) { 
        _plan.setLastResponse(_lastResp);
    }
    
}
