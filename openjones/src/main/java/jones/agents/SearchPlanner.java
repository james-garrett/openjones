/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.agents;

import main.java.external.AStarPlayer;
import java.util.List;
import static main.java.jones.agents.Plan.PlanType.BETTER_CLOTHES;
import static main.java.jones.agents.Plan.PlanType.BETTER_JOB;
import static main.java.jones.agents.Plan.PlanType.REST_ALL_WEEK;
import static main.java.jones.agents.Plan.PlanType.STUDY_ALL_WEEK;
import static main.java.jones.agents.Plan.PlanType.WORK_ALL_WEEK;
import main.java.jones.general.Game;
import main.java.jones.general.Player;
import main.java.jones.measures.Goals;

/**
 *
 * @author dimid
 */
public class SearchPlanner extends PlannerAgent {

    public SearchPlanner(Player p1, Game g) {
        super(p1, g);
    }

    @Override
    public boolean hasNextAction() {
        while (!_schedule.isEmpty()) {
            if (getCurPlan().size() > 0) {
                return true;
            } else {
                _schedule.remove();
            }
        }

        List<Plan.PlanType> foundPlansTypes = AStarPlayer.findPlan(_player.getState(), Goals.MAX_TOTAL_SCORE, this, _game.getMap(), false);
        // TODO: this is a duplicate code chunk as SearchOnDemandPlanner.hasNextAction. We could simplify both blocks
        for (Plan.PlanType type : foundPlansTypes) {
            Plan plan = createPlanFromType(type);
            if (plan == null) {
                int fuck = -1;
            }
            _schedule.add(plan);
        }
        return true;
    }

    public Plan createPlanFromType(Plan.PlanType type) {
        Plan result = null;
        switch (type) {
            case BETTER_CLOTHES:
                result = new GetBetterClothesPlan(this);
                break;
            case BETTER_JOB:
                result = new GetABetterJobPlan(this);
                break;
            //case MOVE_TO:          result = new MoveToPlan(this, null, null);  break;
            case REST_ALL_WEEK:
                result = new RestAllWeekPlan(this);
                break;
            case STUDY_ALL_WEEK:
                result = new StudyAllWeekPlan(this);
                break;
            case WORK_ALL_WEEK:
                result = new WorkAllWeekPlan(this);
                break;
        }

        return result;
    }
}
