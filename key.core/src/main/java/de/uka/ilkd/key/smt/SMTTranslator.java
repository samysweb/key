package de.uka.ilkd.key.smt;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.logic.Sequent;
import de.uka.ilkd.key.logic.Term;


/**
 * Classes that implement this interface provide a translation of a KeY-problem into a specific
 * format.
 */
public interface SMTTranslator {

    /**
     * Translates a problem into the given syntax. The only difference to
     * <code>translate(Term t, Services services)</code> is that assumptions will be added.
     *
     * @param sequent the sequent to be translated.
     * @param services
     * @return a representation of the term in the given syntax.
     * @throws IllegalFormulaException
     */
    public CharSequence translateProblem(Sequent sequent, Services services, SMTSettings settings)
            throws IllegalFormulaException;

}
