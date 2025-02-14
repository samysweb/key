package de.uka.ilkd.key.rule;

import de.uka.ilkd.key.logic.PosInOccurrence;
import de.uka.ilkd.key.proof.Goal;
import org.key_project.util.collection.ImmutableList;

import java.util.Objects;

/**
 * The rule application for {@link JmlAssertRule}
 *
 * @author Benjamin Takacs
 */
public class JmlAssertBuiltInRuleApp extends AbstractBuiltInRuleApp {

    /**
     * @param rule the rule being applied
     * @param occurrence the position at which the rule is applied
     */
    public JmlAssertBuiltInRuleApp(BuiltInRule rule, PosInOccurrence occurrence) {
        this(rule, occurrence, null);
    }

    /**
     * @param rule the rule being applied
     * @param pio the position at which the rule is applied
     * @param ifInsts information flow related information
     */
    public JmlAssertBuiltInRuleApp(BuiltInRule rule, PosInOccurrence pio,
            ImmutableList<PosInOccurrence> ifInsts) {
        super(rule, Objects.requireNonNull(pio, "rule application needs a position"), ifInsts);
        if (!(rule instanceof JmlAssertRule)) {
            throw new IllegalArgumentException(String
                    .format("can only create an application for JmlAssertRule, not for %s", rule));
        }
    }

    @Override
    public JmlAssertBuiltInRuleApp replacePos(PosInOccurrence newPos) {
        return new JmlAssertBuiltInRuleApp(rule(), newPos);
    }

    @Override
    public IBuiltInRuleApp setIfInsts(ImmutableList<PosInOccurrence> ifInsts) {
        // XXX: This is overridden in all subclasses to allow making ifInsts final
        // when all usages of setIfInsts are corrected to use the result.
        // Then a new instance has to be returned here.
        setMutable(ifInsts);
        return this;
    }

    @Override
    public AbstractBuiltInRuleApp tryToInstantiate(Goal goal) {
        return this;
    }
}
