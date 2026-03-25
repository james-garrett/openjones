/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.jones.general.Game;
import main.java.jones.general.PlayerPosition;
import main.java.jones.general.Position;
import main.java.jones.map.Building;

/**
 *
 * @author dimid <dimidd@gmail.com>
 */
class GetBetterClothesPlan extends AllOrNothingPlan {
    //private final PlayerState _playerState;

    public GetBetterClothesPlan(Agent agent) {
        super (agent, PlanType.BETTER_CLOTHES);
        //_playerState = playerState;
        build();
    }

    @Override
    public final void build() {
                        
        Game game = _agent.getGame();
        Building clothesStore = game.getMap().getBuildingByName("QT clothing");
        assert (clothesStore != null);
        
        Position clothesStorePos = clothesStore.getPosition();   
        PlayerPosition clothesStorePPos = new PlayerPosition(clothesStorePos, true);
        _actions.add(new MoveMarker(this, null, clothesStorePPos));
        
        //submenu actions of buildings
        //List<Action> buildingSpecificActions = employmentAgency.getPlayerBuildingSpecificActions(player);
        _actions.add(new UpdatePossibleActionsMarker(this, null));       
        _actions.add(new BuyClothesMarker(this, null));
       
    }
    
}
