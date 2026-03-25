/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.actions.Action;
import main.java.jones.actions.SubMenuAction;
import main.java.jones.general.PlayerPosition;
import main.java.jones.general.PlayerState;
import main.java.jones.map.Building;
import main.java.net.vivin.GenericTreeNode;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
class BackInMenuMarker extends PlanMarker {

    public BackInMenuMarker(Plan plan, Action action) {
        super(plan, action);
    }

    @Override
    public void changeState(PlayerState playerState) {

        PlayerPosition src = playerState.getPos();
        //MoveToPlan move = new MoveToPlan(_plan.getAgent(), src, _dest);

 
        if (src.isInBuilding()) {
            Building build = (Building) _plan.getAgent().getGame().getMap().getTile(src);
            GenericTreeNode<Action> root = playerState.getActionsTree().getRoot();
            if (playerState.getPlayerActionsParent() != root) {
                _plan.getActions().push(new BackInMenuMarker(_plan, new SubMenuAction(0, "back", playerState.getPlayerActionsParent().getParent(), build)));
            } else {
                _action = null;
            }
        }




    }
}
