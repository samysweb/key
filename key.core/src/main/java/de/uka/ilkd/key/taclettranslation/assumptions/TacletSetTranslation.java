package de.uka.ilkd.key.taclettranslation.assumptions;

import org.key_project.util.collection.ImmutableList;
import org.key_project.util.collection.ImmutableSet;

import de.uka.ilkd.key.logic.sort.Sort;
import de.uka.ilkd.key.taclettranslation.TacletFormula;

/**
 * This interface provides the mechanism of translating taclets to formulae. The resulting formulae
 * can be used for example for building assumptions for external proofers. CAUTION: The correctness
 * of a single formula, i.d. the universal validity, depends on the particular taclet.
 */
public interface TacletSetTranslation {



    /**
     * Builds the translation of the taclets given by calling the method
     * <code>setTacletSet()</code>.
     *
     * @param sorts this sorts are used for the instantiation of generic types.
     * @return returns the resulting formulae of the taclets. Each formula of the resulting set is
     *         associated with one taclet.
     */
    public ImmutableList<TacletFormula> getTranslation(ImmutableSet<Sort> sorts);

    /**
     * Returns all taclet that have not been translated. The reason can be got by
     * {@link TacletFormula#getStatus}.
     *
     * @return a list of taclets.
     */
    public ImmutableList<TacletFormula> getNotTranslated();

    /**
     * Updates the translation, i.d. the given list of taclets is being translated again.
     */
    public void update();



}
