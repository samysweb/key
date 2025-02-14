package de.uka.ilkd.key.proof.rulefilter;

import de.uka.ilkd.key.rule.Rule;

/**
 * Intersection (conjunction) of two rule filters
 */
public class AndRuleFilter implements RuleFilter {

    private final RuleFilter a;
    private final RuleFilter b;

    public AndRuleFilter(RuleFilter p_a, RuleFilter p_b) {
        a = p_a;
        b = p_b;
    }

    public boolean filter(Rule rule) {
        return a.filter(rule) && b.filter(rule);
    }


    public String toString() {
        return a + " AND " + b;
    }

}
