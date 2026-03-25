/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.jones.map;

import main.java.jones.actions.Action;
import main.java.jones.actions.StudyAction;
import main.java.jones.general.PlayerState;
import main.java.jones.general.Position;
import main.java.jones.jobs.Job;
import main.java.net.vivin.GenericTree;
import main.java.net.vivin.GenericTreeNode;

/**
 *
 * @author dimid
 */
class College extends Building {

    public static final int JANITOR_BASE_WAGE = 6;
    public static final int TEACHER_BASE_WAGE = 12;
    public static final int PROFESSOR_BASE_WAGE = 27;

    public College(Position pos, String name) {

        super(pos, name);
        addJobs();
    }

    @Override
    protected void buildActionsTree(PlayerState player, GenericTree<Action> actionsTree) {
        Action study = new StudyAction();
        GenericTreeNode<Action> studyNode = new GenericTreeNode<>(study);
        actionsTree.getRoot().addChild(studyNode);

    }

    @Override
    protected final void addJobs() {
        getJobs().add(new Job("Janitor", this, 1, JANITOR_BASE_WAGE, 1));
        getJobs().add(new Job("Teacher", this, 4, TEACHER_BASE_WAGE, 2));
        getJobs().add(new Job("Proffesor", this, 9, PROFESSOR_BASE_WAGE, 3));

    }
}
