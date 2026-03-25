/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import java.util.List;
import java.util.Random;
import main.java.jones.general.Game;
import main.java.jones.general.Player;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
public class RandomOnDemandPlanner extends RandomPlanner{

    public RandomOnDemandPlanner(Player p1, Game g) {
        super(p1, g);
    }
    
      
    @Override
    protected Plan getRandomPlan() {
        List<Plan> neededPlans = getNeededPlans(_player.getState());
        Random random = new Random();
        int choice = random.nextInt(neededPlans.size());
        return neededPlans.get(choice);

          
      }
}
