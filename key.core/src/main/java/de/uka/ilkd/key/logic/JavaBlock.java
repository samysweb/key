package de.uka.ilkd.key.logic;

import java.io.IOException;
import java.io.StringWriter;

import de.uka.ilkd.key.java.JavaProgramElement;
import de.uka.ilkd.key.java.NameAbstractionTable;
import de.uka.ilkd.key.java.PrettyPrinter;
import de.uka.ilkd.key.java.StatementBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaBlock {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaBlock.class);

    /**
     * Attention using the JavaBlock below means no program not the empty program. It is used as a
     * realization of the sentinel design pattern to mark terms with operators that are incapable of
     * containing a program like predicate symbols.
     *
     * If you want to have an empty program, create a new JavaBlock instance with an empty statement
     * block.
     *
     */
    public static final JavaBlock EMPTY_JAVABLOCK = new JavaBlock(new StatementBlock());

    private final JavaProgramElement prg;


    /**
     * create a new JavaBlock
     *
     * @param prg the root JavaProgramElement for this JavaBlock
     */
    private JavaBlock(JavaProgramElement prg) {
        this.prg = prg;
    }

    /**
     * create a new JavaBlock
     *
     * @param prg the root StatementBlock for this JavaBlock. TacletIndex relies on <code>prg</code>
     *        being indeed a StatementBlock.
     */
    public static JavaBlock createJavaBlock(StatementBlock prg) {
        assert prg != null;
        /*
         * if (prg.isEmpty() && ! ) { return EMPTY_JAVABLOCK; }
         */
        return new JavaBlock(prg);
    }


    public boolean isEmpty() {
        if ((program() instanceof StatementBlock)) {
            return ((StatementBlock) program()).isEmpty();
        }
        return this == EMPTY_JAVABLOCK;
    }

    public int size() {
        if ((program() instanceof StatementBlock)) {
            return ((StatementBlock) program()).getChildCount();
        }
        return 0;
    }

    /** returns the hashCode */
    public int hashCode() {
        return 17 + ((program() == null) ? 0 : program().hashCode());
    }

    /** returns true iff the program elements are equal */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof JavaBlock)) {
            return false;
        } else {
            JavaBlock block = (JavaBlock) o;

            if (block.program() == null) {
                return program() == null;
            } else {
                return block.program().equals(program());
            }
        }
    }

    /**
     * returns true if the given ProgramElement is equal to the one of the JavaBlock modulo renaming
     * (see comment in SourceElement)
     */
    public boolean equalsModRenaming(Object o, NameAbstractionTable nat) {
        if (!(o instanceof JavaBlock)) {
            return false;
        }
        return equalsModRenaming(((JavaBlock) o).program(), nat);
    }


    /**
     * returns true if the given ProgramElement is equal to the one of the JavaBlock modulo renaming
     * (see comment in SourceElement)
     */
    private boolean equalsModRenaming(JavaProgramElement pe, NameAbstractionTable nat) {
        if (pe == null && program() == null) {
            return true;
        } else if (pe != null && program() != null) {
            return program().equalsModRenaming(pe, nat);
        }
        return false;
    }

    /**
     * returns the java program
     *
     * @return the stored JavaProgramElement
     */
    public JavaProgramElement program() {
        return prg;
    }

    /** toString */
    public String toString() {
        // if (this==EMPTY_JAVABLOCK) return "";
        StringWriter sw = new StringWriter();
        try {
            PrettyPrinter pp = new PrettyPrinter(sw, true);
            pp.setIndentationLevel(0);
            prg.prettyPrint(pp);
        } catch (IOException e) {
            LOGGER.warn("toString of JavaBlock failed", e);
        }
        return sw.toString();
    }

}
