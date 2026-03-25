/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.actions.RelaxAction;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
public class RestAllWeekPlan extends WeekPlan {

    public RestAllWeekPlan(Agent agent) {
        super(agent, PlanType.REST_ALL_WEEK);
        build();
    }

    @Override
    public final void build() {
                
        _actions.add( new GoHomeMarker(this, null));
        
        //after the last movement (i.e. enter building), we work repetetively
        _actions.add(new SetRepetetiveMarker(this, null, true));        
        _actions.add(new NoOpMarker(this, new RelaxAction(_lastHome)));

    }
    
    
}
