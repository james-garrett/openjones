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
class SetRepetetiveMarker extends PlanMarker {
    private final boolean _repetValue;

    public SetRepetetiveMarker(Plan result, Action get, boolean b) {
        super (result, get);
        _repetValue = b;
    }

    @Override
    public void changeState(PlayerState playerState) {
        _plan.setIsRepetetive(_repetValue);
    }
    
}
