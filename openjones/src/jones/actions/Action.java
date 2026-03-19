/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jones.actions;
import jones.general.PlayerState;

/**
 *
 * @author dimid
 */
public abstract class Action {

    protected Integer _timeEffect = null;
    
    protected abstract ActionResponse checkConditions(PlayerState playerState);

    protected abstract void doAction(PlayerState playerState);

    /**
     * If possible, performs the action.
     * Otherwise, returns an explanation why it can't be performed
     * @param playerState
     * @return Returns null if the action performed.
     *          otherwise returns a String with an explanation
     */
    public final ActionResponse perform(PlayerState playerState) {
        ActionResponse preConditions = checkConditions(playerState);
        if (!preConditions._isPositive) {
            return preConditions;
        }
        doAction(playerState);
        
//        player.getState().affectHealth(healthEffect(player));
//        player.getState().affectHappiness(happinessEffect(player));
//        player.getState().affectCareer(careerEffect(player));
//        player.getState().affectCash(cashEffect(player));
//        player.getState().affectTime(timeEffect(player));
            
        clearCachedValues();
        return getPositiveResponse(playerState);
    }

    public abstract int healthEffect(PlayerState playerState); 

    public abstract int happinessEffect(PlayerState playerState);

    //public abstract int WealthEffect(Player player);

    public abstract int careerEffect(PlayerState playerState);
     
    public abstract int cashEffect(PlayerState playerState);
    
    public abstract int timeEffect(PlayerState playerState);
   
    @Override
    public abstract String toString();

    protected ActionResponse checkTime(PlayerState playerState) {
        if (playerState.timeLeft() >= timeEffect(playerState)) {
            return new ActionResponse(true, null);
        }
        else {
            return new ActionResponse(false,"Not enough time");
        }
    }

    protected abstract ActionResponse getPositiveResponse(PlayerState playerState);
    
    /**
     * Return true iff this action leads to a menu of other actions
     * @return
     */
    public abstract boolean isSubmenu();

    /**
     * Return the max period a player has up to a limit.
     * @param limit The max period
     * @param playerState
     * @return If the player, doesn't have time at all, return Integer.MAX_VALUE.
     *          Otherwise, return the max period the player has up to a limit
     *
     */
    protected int getAvailiableTimeUpto(int limit, PlayerState playerState) {
        if (!playerState.hasTime()) {
            return Integer.MAX_VALUE;
        }
        return Math.min(limit, playerState.timeLeft());
    }

    public abstract void clearCachedValues();

    /**
     * Should building rebuild his actions tree after performing this action
     * @return 
     */
    public boolean shouldRebuildActions () {
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = (obj != null && getClass() == obj.getClass());
        return equals;
    }
    
    
       
}
