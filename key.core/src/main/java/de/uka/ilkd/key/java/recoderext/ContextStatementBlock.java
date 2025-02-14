// This file is taken from the RECODER library, which is protected by the LGPL,
// and modified.

package de.uka.ilkd.key.java.recoderext;

import recoder.java.StatementBlock;

/**
 * Statement block.
 *
 * @author AL
 * @author <TT>AutoDoc</TT>
 */

public class ContextStatementBlock extends StatementBlock implements KeYRecoderExtension {

    /**
     *
     */
    private static final long serialVersionUID = -7812560435975572578L;
    private ExecutionContext ec;

    /**
     * Statement block.
     */
    public ContextStatementBlock() {
    }

    /**
     * Statement block.
     */
    public ContextStatementBlock(TypeSVWrapper tr, MethodSignatureSVWrapper pm,
            ExpressionSVWrapper runtime) {
        this(tr != null ? new ExecutionContext(tr, pm, runtime) : null);
    }

    /**
     * Statement block.
     */
    public ContextStatementBlock(ExecutionContext ec) {
        this.ec = ec;
    }

    /**
     * Statement block.
     *
     * @param proto a statement block.
     */

    protected ContextStatementBlock(ContextStatementBlock proto) {
        super(proto);
        this.ec = proto.getExecutionContext();
    }


    public TypeSVWrapper getClassContext() {
        return (TypeSVWrapper) ec.getTypeReference();
    }

    public ExpressionSVWrapper getRuntimeInstance() {
        return (ExpressionSVWrapper) ec.getRuntimeInstance();
    }

    public ExecutionContext getExecutionContext() {
        return ec;
    }

}
