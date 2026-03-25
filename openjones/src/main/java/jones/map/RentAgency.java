/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.map;

import main.java.jones.actions.RentHouseAction;
import main.java.jones.possessions.RentContract;
import main.java.jones.actions.PayRentAction;
import java.util.List;
import main.java.jones.jobs.Job;
import main.java.jones.actions.Action;
import main.java.jones.general.PlayerState;
import main.java.jones.general.Position;
import main.java.jones.possessions.RentPossession;
import main.java.net.vivin.GenericTree;
import main.java.net.vivin.GenericTreeNode;

/**
 *
 * @author dimid
 */
public class RentAgency extends Building {
    private final  List<House> _houses;
     
    /**
     * Number of weeks in a month of rent
     */
    public static final int WEEKS_OF_RENT_IN_A_MONTH = 4;
    
    public static final int GROUNSKEEPER_BASE_WAGE = 5;
    public static final int APARTMENT_MANAGER_BASE_WAGE = 7;
    //public static final int WEEK_OF_RENT;

    public RentAgency(Position pos, String name, List<House> houses) {
        super(pos,name);
        _houses = houses; 
        addJobs();
    }

    @Override
    protected void buildActionsTree(PlayerState player, GenericTree<Action> actionsTree) {
        GenericTreeNode<Action> root = actionsTree.getRoot();
        RentContract rentContract = player.getRentContract();
        if (null != rentContract) {
            root.addChild(new GenericTreeNode<> (new PayRentAction(new RentPossession(rentContract.getPossession()))));
        }
        
        for (House h: _houses) {
            root.addChild(new GenericTreeNode<> (new RentHouseAction(h, WEEKS_OF_RENT_IN_A_MONTH)));
        }                 
    }

    @Override
    protected final void addJobs() {
        getJobs().add(new Job("Groundskeeper", this, 1, GROUNSKEEPER_BASE_WAGE,1));
        getJobs().add(new Job("Apartment Manager", this, 2, APARTMENT_MANAGER_BASE_WAGE,2));
    }
    
}
