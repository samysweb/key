package de.uka.ilkd.key.java.expression.literal;

import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.java.expression.Literal;
import de.uka.ilkd.key.java.visitor.Visitor;
import de.uka.ilkd.key.logic.Name;

/**
 * Null literal. Is used as singleton.
 */

public class NullLiteral extends Literal {

    public static final NullLiteral NULL = new NullLiteral();

    /**
     * Constructor for the transformation of COMPOST ASTs to KeY.
     */
    private NullLiteral() {
        super();
    }

    /**
     * calls the corresponding method of a visitor in order to perform some action/transformation on
     * this element
     *
     * @param v the Visitor
     */
    public void visit(Visitor v) {
        v.performActionOnNullLiteral(this);
    }


    public void prettyPrint(PrettyPrinter p) throws java.io.IOException {
        p.printNullLiteral(this);
    }

    public KeYJavaType getKeYJavaType(Services javaServ) {
        return javaServ.getJavaInfo().getNullType();
    }

    @Override
    public Name getLDTName() {
        throw new UnsupportedOperationException("No LDT is linked to the null literal.");
    }

}
