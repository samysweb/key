// This file is part of the RECODER library and protected by the LGPL.

package recoder.java.statement;

import recoder.java.*;
import recoder.java.declaration.LocalVariableDeclaration;
import recoder.java.declaration.VariableSpecification;
import recoder.list.generic.ASTList;
import recoder.util.Debug;

import java.util.ArrayList;
import java.util.List;

/**
 * For.
 *
 * @author <TT>AutoDoc</TT>
 */

public class For extends LoopStatement implements VariableScope {

    /**
     * serialization id
     */
    private static final long serialVersionUID = 6315865704532091022L;

    /**
     * For.
     */

    public For() {
        // nothing to do
    }

    /**
     * For.
     *
     * @param inits a loop initializer mutable list.
     * @param guard an expression.
     * @param updates an expression mutable list.
     * @param body a statement.
     */

    public For(ASTList<LoopInitializer> inits, Expression guard, ASTList<Expression> updates,
            Statement body) {
        super(body);
        setInitializers(inits);
        setGuard(guard);
        setUpdates(updates);
        makeParentRoleValid();
    }

    /**
     * For.
     *
     * @param proto a for.
     */

    protected For(For proto) {
        super(proto);
        makeParentRoleValid();
    }

    /**
     * Deep clone.
     *
     * @return the object.
     */

    public For deepClone() {
        return new For(this);
    }

    public SourceElement getLastElement() {
        return (body != null) ? body.getLastElement() : this;
    }

    /**
     * Is exit condition.
     *
     * @return the boolean value.
     */

    public boolean isExitCondition() {
        return false;
    }

    /**
     * Is checked before iteration.
     *
     * @return the boolean value.
     */

    public boolean isCheckedBeforeIteration() {
        return true;
    }

    public boolean isDefinedScope() {
        return true;
    }

    public void setDefinedScope(@SuppressWarnings("unused") boolean defined) {
        // ignore.
    }

    public List<VariableSpecification> getVariablesInScope() {
        if (inits != null) {
            LoopInitializer li = inits.get(0);
            if (li instanceof LocalVariableDeclaration) {
                return ((LocalVariableDeclaration) li).getVariables();
            }
        }
        return new ArrayList<VariableSpecification>();
    }

    public VariableSpecification getVariableInScope(String name) {
        Debug.assertNonnull(name);
        if (inits != null) {
            LoopInitializer li = inits.get(0);
            if (li instanceof LocalVariableDeclaration) {
                List<VariableSpecification> vars = ((LocalVariableDeclaration) li).getVariables();
                for (int i = 0, s = vars.size(); i < s; i += 1) {
                    VariableSpecification v = vars.get(i);
                    if (name.equals(v.getName())) {
                        return v;
                    }
                }
            }
        }
        return null;
    }

    public void addVariableToScope(VariableSpecification var) {
        Debug.assertNonnull(var);
        // TODO maybe check if var is contained in inits? (consistency-check)
    }

    public void removeVariableFromScope(String name) {
        Debug.assertNonnull(name);
    }

    public void accept(SourceVisitor v) {
        v.visitFor(this);
    }
}
