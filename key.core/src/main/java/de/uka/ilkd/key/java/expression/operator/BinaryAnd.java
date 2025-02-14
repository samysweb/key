package de.uka.ilkd.key.java.expression.operator;

import org.key_project.util.ExtList;

import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.visitor.Visitor;

/**
 * Binary and.
 */

public class BinaryAnd extends BinaryOperator {

    /**
     * Binary and.
     *
     * @param children an ExtList with all children of this node the first children in list will be
     *        the one on the left side, the second the one on the right side.
     */

    public BinaryAnd(ExtList children) {
        super(children);
    }

    /**
     * Get arity.
     *
     * @return the int value.
     */

    public final int getArity() {
        return 2;
    }

    /**
     * Get precedence.
     *
     * @return the int value.
     */

    public final int getPrecedence() {
        return 7;
    }

    /**
     * Get notation.
     *
     * @return the int value.
     */

    public final int getNotation() {
        return INFIX;
    }

    /**
     * calls the corresponding method of a visitor in order to perform some action/transformation on
     * this element
     *
     * @param v the Visitor
     */
    public void visit(Visitor v) {
        v.performActionOnBinaryAnd(this);
    }

    public void prettyPrint(PrettyPrinter p) throws java.io.IOException {
        p.printBinaryAnd(this);
    }


}
