package de.uka.ilkd.key.strategy.termProjection;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.logic.Term;
import de.uka.ilkd.key.proof.Goal;
import de.uka.ilkd.key.rule.RuleApp;

/**
 * Interface for mappings from rule applications to terms. This is used, for instance, for
 * determining the instantiation of a schema variable. We also allow projections to be partial,
 * which is signalled by <code>toTerm</code> returning <code>null</code>
 */
public interface ProjectionToTerm {
    Term toTerm(RuleApp app, PosInOccurrence pos, Goal goal);
}
