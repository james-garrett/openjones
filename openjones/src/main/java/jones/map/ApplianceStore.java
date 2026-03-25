/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.map;

import main.java.jones.actions.Action;
import main.java.jones.general.PlayerState;
import main.java.jones.general.Position;
import main.java.net.vivin.GenericTree;

/**
 *
 * @author dimid
 */
class ApplianceStore extends Building {

    public ApplianceStore(Position pos, String name) {
        super(pos,name);
        addJobs();
    }

	@Override
	protected void buildActionsTree(PlayerState player, GenericTree<Action> actionsTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected final void addJobs() {
		// TODO Auto-generated method stub
		
	}

}
   