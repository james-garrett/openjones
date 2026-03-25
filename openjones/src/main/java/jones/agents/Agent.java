/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import java.util.ArrayList;
import main.java.jones.actions.Action;
import main.java.jones.actions.ActionResponse;
import main.java.jones.general.Game;
import main.java.jones.general.Player;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
public abstract class Agent {
    
    protected final Player _player;
    protected final Game _game;
    
    public Player getPlayer() {
        return _player;
    }

    public Game getGame() {
        return _game;
    }
    
    
    public Agent (Player player, Game game) { 
        assert (null != player);
        _player = player;
        assert (null != game && game.hasStarted());
        _game = game;
    }
    
    /**
     * Notify the agent a new turn has started
     */
    public abstract void notifyOfNewTurn();
   
    /**
     * Notify the agent about the result of an action
     * @param response
     */
    public abstract void notifyOfResult(ActionResponse response);
   
    public abstract int selectAction (ArrayList<? extends Action> actions);
    
    public abstract boolean hasNextAction ();
 
}
