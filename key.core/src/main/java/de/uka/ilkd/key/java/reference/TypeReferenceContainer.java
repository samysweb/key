package de.uka.ilkd.key.java.reference;

import de.uka.ilkd.key.java.NonTerminalProgramElement;

/**
 * Type reference container.
 *
 */

public interface TypeReferenceContainer extends NonTerminalProgramElement {

    /**
     * Get the number of type references in this container.
     *
     * @return the number of type references.
     */
    int getTypeReferenceCount();

    /*
     * Return the type reference at the specified index in this node's "virtual" type reference
     * array.
     *
     * @param index an index for a type reference.
     *
     * @return the type reference with the given index.
     *
     * @exception ArrayIndexOutOfBoundsException if <tt>index</tt> is out of bounds.
     */
    TypeReference getTypeReferenceAt(int index);
}
