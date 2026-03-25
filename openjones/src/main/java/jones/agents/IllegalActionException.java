/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import java.util.ArrayList;
import main.java.jones.actions.Action;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
public class IllegalActionException extends Exception {
    private static final long serialVersionUID = 1L;

    public IllegalActionException(Action nextAction, ArrayList<? extends Action> actions) {
        System.err.println("Action:"+nextAction+" is not in possible actions:"+actions);
    }
    
}
