package de.uka.ilkd.key.java.recoderext;

import java.util.List;

import recoder.java.Expression;
import de.uka.ilkd.key.util.MiscTools;

/**
 * This class is used to parse function applications with JavaDL escapes within set statements or
 * similar situations.
 *
 *
 * @author Mattias Ulbrich
 */
public class DLEmbeddedExpression extends EscapeExpression {

    private static final long serialVersionUID = 1210489918296848261L;

    public DLEmbeddedExpression(String functionName, List<Expression> arguments) {
        super(functionName, arguments);
    }

    @Override
    public Expression deepClone() {
        return new DLEmbeddedExpression(functionName, children);
    }

    @Override
    public String toSource() {
        return "\\dl_" + functionName + "(" + MiscTools.join(children, ",") + ")";
    }

}
