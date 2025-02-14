package recoder.testsuite.basic.syntax;

import junit.framework.Assert;
import junit.framework.TestCase;
import recoder.ProgramFactory;
import recoder.convenience.Format;
import recoder.io.SourceFileRepository;
import recoder.java.CompilationUnit;
import recoder.java.ProgramElement;
import recoder.testsuite.basic.BasicTestsSuite;

import java.util.List;

public class CloneTest extends TestCase {

    public void testClone() {
        SourceFileRepository sfr = BasicTestsSuite.getConfig().getSourceFileRepository();
        ProgramFactory pf = BasicTestsSuite.getConfig().getProgramFactory();
        List<CompilationUnit> units = sfr.getCompilationUnits();
        for (int i = 0; i < units.size(); i += 1) {
            CompilationUnit cu = units.get(i);
            String buffer1 = cu.toSource();
            CompilationUnit cv = cu.deepClone();
            if (!ProgramElement.STRUCTURAL_EQUALITY.equals(cu, cv)) {
                Assert.fail(
                    "Printed tree of " + Format.toString("%u", cu) + " has changed its structure");
            }
            String buffer2 = cv.toSource();
            if (!buffer1.equals(buffer2)) {
                Assert.fail(Format.toString("Reprint of parsed %u differs", cu));
            }
        }
    }
}
