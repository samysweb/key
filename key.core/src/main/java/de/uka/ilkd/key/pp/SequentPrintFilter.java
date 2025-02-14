package de.uka.ilkd.key.pp;

import java.util.Iterator;

import org.key_project.util.collection.ImmutableList;
import org.key_project.util.collection.ImmutableSLList;

import de.uka.ilkd.key.logic.Sequent;
import de.uka.ilkd.key.logic.SequentFormula;
import de.uka.ilkd.key.pp.IdentitySequentPrintFilter.IdentityFilterEntry;


/**
 * Filter a given sequent to prepare it for the SequentPrinter class by adjusting constraints,
 * deleting formulas, etc.
 */
public abstract class SequentPrintFilter {
    /**
     * the original sequent
     */
    Sequent originalSequent;

    /**
     * the antecedent of the filtered formula
     */
    ImmutableList<SequentPrintFilterEntry> antec = ImmutableSLList.<SequentPrintFilterEntry>nil();

    /**
     * the antecedent of the filtered formula
     */
    ImmutableList<SequentPrintFilterEntry> succ = ImmutableSLList.<SequentPrintFilterEntry>nil();

    /**
     * @return the original sequent
     */
    public Sequent getOriginalSequent() {
        return originalSequent;
    }

    /**
     * filters the sequent according to filter type
     */
    protected abstract void filterSequent();

    /**
     * sets the (original) sequent of this filter
     *
     * @param s the sequent s is set to
     */
    public void setSequent(Sequent s) {
        originalSequent = s;
        antec = null;
        succ = null;
        filterSequent();
    }

    /**
     * Get the formulas of the filtered antecedent and the constraints to use for instantiating
     * metavariables when printing
     *
     * @return the filtered antecedent
     */
    public ImmutableList<SequentPrintFilterEntry> getFilteredAntec() {
        return antec;
    }

    /**
     * Get the formulas of the filtered succcedent and the constraints to use for instantiating
     * metavariables when printing
     *
     * @return the filtered succcedent
     */
    public ImmutableList<SequentPrintFilterEntry> getFilteredSucc() {
        return succ;
    }

    /**
     * converts the complete original sequent into antecedent/succendent lists of print filter
     * entries.
     */
    protected void filterIdentity() {
        antec = ImmutableSLList.<SequentPrintFilterEntry>nil();
        Iterator<SequentFormula> it = originalSequent.antecedent().iterator();
        while (it.hasNext()) {
            antec = antec.append(new IdentityFilterEntry(it.next()));
        }

        succ = ImmutableSLList.<SequentPrintFilterEntry>nil();
        it = originalSequent.succedent().iterator();
        while (it.hasNext()) {
            succ = succ.append(new IdentityFilterEntry(it.next()));
        }
    }
}
