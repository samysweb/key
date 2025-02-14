package de.uka.ilkd.key.java.recoderext.adt;

import recoder.java.Expression;


public class SeqSingleton extends ADTPrefixConstruct {

    /**
     *
     */
    private static final long serialVersionUID = 940102046205262465L;

    public SeqSingleton(Expression lhs) {
        super(lhs);
        makeParentRoleValid();
    }


    protected SeqSingleton(SeqSingleton proto) {
        super(proto);
        makeParentRoleValid();
    }


    @Override
    public SeqSingleton deepClone() {
        return new SeqSingleton(this);
    }


    @Override
    public int getArity() {
        return 1;
    }


    @Override
    public int getNotation() {
        return PREFIX;
    }

    @Override
    public String toSource() {
        return "\\seq_singleton(" + children.get(0) + ")";
    }
}
