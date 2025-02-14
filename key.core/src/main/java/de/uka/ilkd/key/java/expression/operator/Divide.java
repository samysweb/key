package de.uka.ilkd.key.java.expression.operator;

import org.key_project.util.ExtList;

import de.uka.ilkd.key.java.Expression;
import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.visitor.Visitor;


/**
 * Divide.
 */

public class Divide extends BinaryOperator {

    /**
     * Divide.
     *
     * @param children an ExtList with all children of this node the first children in list will be
     *        the one on the left side, the second the one on the right side.
     */

    public Divide(ExtList children) {
        super(children);
    }

    public Divide(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    /**
     * Get precedence.
     *
     * @return the int value.
     */

    public int getPrecedence() {
        return 2;
    }

    /**
     * Get notation.
     *
     * @return the int value.
     */

    public int getNotation() {
        return INFIX;
    }

    /**
     * calls the corresponding method of a visitor in order to perform some action/transformation on
     * this element
     *
     * @param v the Visitor
     */
    public void visit(Visitor v) {
        v.performActionOnDivide(this);
    }

    public void prettyPrint(PrettyPrinter p) throws java.io.IOException {
        p.printDivide(this);
    }


}
