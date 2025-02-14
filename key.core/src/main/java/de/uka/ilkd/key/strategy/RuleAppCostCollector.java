package de.uka.ilkd.key.strategy;

import de.uka.ilkd.key.rule.RuleApp;

/**
 * Interface for collecting <code>RuleApp</code>s, together with their assigned cost. This interface
 * is used in the signature of the method <code>Strategy.instantiateApp</code>
 */
public interface RuleAppCostCollector {
    void collect(RuleApp app, RuleAppCost cost);
}
