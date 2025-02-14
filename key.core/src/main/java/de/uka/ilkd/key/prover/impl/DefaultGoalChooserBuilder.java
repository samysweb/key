package de.uka.ilkd.key.prover.impl;

import de.uka.ilkd.key.prover.GoalChooserBuilder;
import de.uka.ilkd.key.prover.GoalChooser;

/**
 * creates the default goal chooser used in KeY
 */
public class DefaultGoalChooserBuilder implements GoalChooserBuilder {

    public static final String NAME = "Simple Goal Chooser";

    public DefaultGoalChooserBuilder() {}

    public GoalChooser create() {
        return new DefaultGoalChooser();
    }

    public String name() {
        return NAME;
    }

    public GoalChooserBuilder copy() {
        return new DefaultGoalChooserBuilder();
    }

}
