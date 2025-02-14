package de.uka.ilkd.key.java.expression.operator;

import org.key_project.util.ExtList;

import de.uka.ilkd.key.java.Expression;
import de.uka.ilkd.key.java.Services;
import de.uka.ilkd.key.java.TypeConverter;
import de.uka.ilkd.key.java.abstraction.KeYJavaType;
import de.uka.ilkd.key.java.expression.Operator;
import de.uka.ilkd.key.java.reference.ExecutionContext;

/**
 * Operator of arity 2
 *
 * @author AL
 */
public abstract class BinaryOperator extends Operator {

    public BinaryOperator(ExtList children) {
        super(children);
    }

    public BinaryOperator(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    /**
     * Get arity.
     *
     * @return the int value.
     */
    public int getArity() {
        return 2;
    }

    public KeYJavaType getKeYJavaType(Services javaServ, ExecutionContext ec) {
        final TypeConverter tc = javaServ.getTypeConverter();
        try {
            return tc.getPromotedType(tc.getKeYJavaType((Expression) getChildAt(0), ec),
                tc.getKeYJavaType((Expression) getChildAt(1), ec));
        } catch (Exception e) {
            throw new RuntimeException("Type promotion failed (see below). Operator was " + this,
                e);
        }
    }

}
