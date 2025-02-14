/*
 * Created on 04.01.2006
 *
 * This file is part of the RECODER library and protected by the LGPL.
 *
 */
package recoder.abstraction;

import recoder.ModelException;
import recoder.service.ProgramModelInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an intersection type, which was introduced in java 5. See JLS, 3rd edition, �4.9 for
 * details.
 *
 * @author Tobias Gutzmann
 */
public class IntersectionType implements ClassType {
    private final List<Type> types;
    private ProgramModelInfo pmi;

    /**
     *
     */
    public IntersectionType(List<Type> types, ProgramModelInfo pmi) {
        super();
        this.types = types;
        this.pmi = pmi;
    }

    public String getFullName() {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < types.size(); i++) {
            if (i != 0)
                res.append(" & ");
            res.append(types.get(i).getFullName());
        }
        return res.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see recoder.abstraction.ProgramModelElement#getProgramModelInfo()
     */
    public ProgramModelInfo getProgramModelInfo() {
        return pmi;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * recoder.abstraction.ProgramModelElement#setProgramModelInfo(recoder.service.ProgramModelInfo)
     */
    public void setProgramModelInfo(ProgramModelInfo pmi) {
        this.pmi = pmi;
    }

    /*
     * (non-Javadoc)
     *
     * @see recoder.NamedModelElement#getName()
     */
    public String getName() {
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < types.size(); i++) {
            if (i != 0)
                res.append(" & ");
            res.append(types.get(i).getName());
        }
        return res.toString();
    }

    public void validate() throws ModelException {
        // nothing to do
    }

    public boolean isInterface() {
        return false;
    }

    public boolean isOrdinaryInterface() {
        return false;
    }

    public boolean isAnnotationType() {
        return false;
    }

    public boolean isEnumType() {
        return false;
    }

    public boolean isOrdinaryClass() {
        return false;
    }

    public boolean isAbstract() {
        return true; // kinda is ?!
    }

    public List<ClassType> getSupertypes() {
        List<ClassType> res = new ArrayList<ClassType>();
        boolean addedObject = false;
        for (int i = 0; i < types.size(); i++) {
            Type t = types.get(i);
            if (t instanceof ClassType) {
                res.add((ClassType) t);
                if (t.getFullName().equals("java.lang.Object"))
                    addedObject = true;
            }
            if (t instanceof ArrayType && !addedObject) {
                res.add(pmi.getServiceConfiguration().getNameInfo().getJavaLangObject());
                addedObject = true;
            }
        }
        return res;
    }

    public List<ClassType> getAllSupertypes() {
        return pmi.getAllSubtypes(this);
    }

    public List<? extends Field> getFields() {
        return null;
    }

    public List<Field> getAllFields() {
        return pmi.getAllFields(this);
    }

    public List<Method> getMethods() {
        return null;
    }

    public List<Method> getAllMethods() {
        return pmi.getAllMethods(this);
    }

    public List<Constructor> getConstructors() {
        return null;
    }

    public List<ClassType> getAllTypes() {
        return null;
    }

    public List<? extends TypeParameter> getTypeParameters() {
        return null;
    }

    public boolean isFinal() {
        return false;
    }

    public boolean isStatic() {
        return false;
    }

    public boolean isPrivate() {
        return false;
    }

    public boolean isProtected() {
        return false;
    }

    public boolean isPublic() {
        return false;
    }

    public boolean isStrictFp() {
        return false;
    }

    public ClassType getContainingClassType() {
        return null;
    }

    public List<? extends AnnotationUse> getAnnotations() {
        return null;
    }

    public List<? extends ClassType> getTypes() {
        return null;
    }

    public Package getPackage() {
        return null;
    }

    public ClassTypeContainer getContainer() {
        return null;
    }

}
