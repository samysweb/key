package de.uka.ilkd.key.rule.inst;

import org.key_project.util.collection.ImmutableArray;

import de.uka.ilkd.key.java.ProgramElement;
import de.uka.ilkd.key.logic.op.SVSubstitute;

public class ProgramList implements SVSubstitute {

    private final ImmutableArray<ProgramElement> list;


    public ProgramList(ImmutableArray<ProgramElement> list) {
        assert list != null
                : "Constructor of ProgramList must" + " not be called with null argument";
        this.list = list;
    }

    public ImmutableArray<ProgramElement> getList() {
        return list;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ProgramList)) {
            return false;
        }
        return list.equals(((ProgramList) o).list);
    }

    public int hashCode() {
        return list.hashCode();
    }

}
