// This file is part of the RECODER library and protected by the LGPL.

package recoder.service;

import recoder.ModelException;
import recoder.ParserException;

/**
 * Exception indicating that a certain type could not be imported. This might have been a
 * consequence of a parse or IO exception.
 *
 * @author AL
 */
public class TypeImportException extends ModelException {

    /**
     * serialization id
     */
    private static final long serialVersionUID = 7615714671292466231L;

    /**
     * Empty constructor.
     */
    public TypeImportException() {
        super();
    }

    /**
     * Constructor with an explanation text.
     *
     * @param s an explanation.
     */
    public TypeImportException(String s) {
        super(s);
    }

    /**
     * Constructor to wrap a parser exception.
     *
     * @param p a parser exception.
     */
    public TypeImportException(ParserException p) {
        super(p.toString());
    }
}

