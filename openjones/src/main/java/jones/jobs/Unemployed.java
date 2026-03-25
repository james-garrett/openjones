/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.jobs;

/**
 *
 * @author dimid
 */
public class Unemployed extends Job {
    
    public Unemployed () {
        super("unemployed",null,0,0,0,null,0,0,0);
    }
    
    //FIXME: Where are we even using this?? Do we need this?
    @Override
    public String toString() {
        return "unemployed";
    }
}
