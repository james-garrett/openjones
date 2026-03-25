/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.external;

import main.java.jones.agents.Plan;
import main.java.jones.general.AbstractPlayerState;
import main.java.jones.general.PlayerState;

/**
 * Container for an AbstractPlayer and a Plan
 * @author dimid
 */
public class PlayerStatePlan {
    private  PlayerState _playerState;
    private  Plan _plan;

    public void setPlayerState(PlayerState playerState) {
        this._playerState = playerState;
    }

    public void setPlan(Plan _plan) {
        this._plan = _plan;
    }

    public PlayerState getPlayerState() {
        return _playerState;
    }

    public Plan getPlan() {
        return _plan;
    }
    
    public  PlayerStatePlan(PlayerState playerState, Plan plan) {
        _playerState = playerState;
        _plan = plan;
    }

    @Override
    public String toString() {
        return "PlayerStatePlan{" + "_playerState=" + _playerState + ", _plan=" + _plan + '}';
    }
    
    
}
