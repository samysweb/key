package de.uka.ilkd.key.java.expression.operator;

import org.key_project.util.ExtList;

import de.uka.ilkd.key.java.Expression;
import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.visitor.Visitor;

/**
 * Times.
 *
 * @author <TT>AutoDoc</TT>
 */

public class Times extends BinaryOperator {

    /**
     * Times.
     *
     * @param lhs an expression.
     * @param rhs an expression.
     */

    public Times(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }


    /**
     * Constructor for the transformation of COMPOST ASTs to KeY. The first occurrence of an
     * Expression in the given list is taken as the left hand side of the expression, the second
     * occurrence is taken as the right hand side of the expression.
     *
     * @param children the children of this AST element as KeY classes.
     */
    public Times(ExtList children) {
        super(children);
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
        v.performActionOnTimes(this);
    }

    public void prettyPrint(PrettyPrinter p) throws java.io.IOException {
        p.printTimes(this);
    }


}
