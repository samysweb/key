// This file is part of the RECODER library and protected by the LGPL.

package recoder.service;

import recoder.ModelException;
import recoder.abstraction.ClassType;

/**
 * Exception indicating a cyclic inheritance.
 *
 * @author AL
 * @since 0.72
 */
public class CyclicInheritanceException extends ModelException {

    /**
     * serialization id
     */
    private static final long serialVersionUID = -2917658612032872699L;
    private final ClassType baseClass;

    /**
     * Empty constructor.
     *
     * @param ct a class type which is part of the cycle.
     */
    public CyclicInheritanceException(ClassType ct) {
        this.baseClass = ct;
    }

    /**
     * Constructor with an explanation text.
     *
     * @param s an explanation.
     * @param ct a class type which is part of the cycle.
     */
    public CyclicInheritanceException(String s, ClassType ct) {
        super(s);
        this.baseClass = ct;
    }

    /**
     * Returns a class type that inherits from itself.
     */
    public ClassType getSelfInheritingType() {
        return baseClass;
    }
}
