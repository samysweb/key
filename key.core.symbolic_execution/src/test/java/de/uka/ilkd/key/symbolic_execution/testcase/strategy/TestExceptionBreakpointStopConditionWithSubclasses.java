package de.uka.ilkd.key.symbolic_execution.testcase.strategy;

import de.uka.ilkd.key.control.DefaultUserInterfaceControl;
import de.uka.ilkd.key.proof.Proof;
import de.uka.ilkd.key.proof.init.ProofInputException;
import de.uka.ilkd.key.proof.io.ProblemLoaderException;
import de.uka.ilkd.key.strategy.StrategyProperties;
import de.uka.ilkd.key.symbolic_execution.strategy.CompoundStopCondition;
import de.uka.ilkd.key.symbolic_execution.strategy.SymbolicExecutionBreakpointStopCondition;
import de.uka.ilkd.key.symbolic_execution.strategy.breakpoint.SymbolicExecutionExceptionBreakpoint;
import de.uka.ilkd.key.symbolic_execution.testcase.AbstractSymbolicExecutionTestCase;
import de.uka.ilkd.key.symbolic_execution.util.SymbolicExecutionEnvironment;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashMap;

public class TestExceptionBreakpointStopConditionWithSubclasses
        extends AbstractSymbolicExecutionTestCase {
    @Test // weigl not prev. activated
    public void testBreakpointStopCondition() throws ProofInputException, IOException,
            ParserConfigurationException, SAXException, ProblemLoaderException {
        HashMap<String, String> originalTacletOptions = null;
        boolean originalOneStepSimplification = isOneStepSimplificationEnabled(null);
        SymbolicExecutionEnvironment<DefaultUserInterfaceControl> env = null;
        try {
            // Define test settings
            String javaPathInkeyRepDirectory =
                "/set/exceptionBreakpointsWithSubclassesTest/test/ClassCastAndNullpointerExceptions.java";
            String containerTypeName = "ClassCastAndNullpointerExceptions";
            final String methodFullName = "main";
            String oraclePathInkeyRepDirectoryFile =
                "/set/exceptionBreakpointsWithSubclassesTest/oracle/ClassCastAndNullpointerExceptions";
            String oracleFileExtension = ".xml";
            // Store original settings of KeY
            originalTacletOptions = setDefaultTacletOptions(testCaseDirectory,
                javaPathInkeyRepDirectory, containerTypeName, methodFullName);
            setOneStepSimplificationEnabled(null, true);
            // Create proof environment for symbolic execution
            env = createSymbolicExecutionEnvironment(testCaseDirectory, javaPathInkeyRepDirectory,
                containerTypeName, methodFullName, null, false, false, false, false, false, false,
                false, false, false, true);
            // Make sure that initial tree is valid
            int oracleIndex = 0;
            assertSetTreeAfterStep(env.getBuilder(), oraclePathInkeyRepDirectoryFile, ++oracleIndex,
                oracleFileExtension, testCaseDirectory);
            CompoundStopCondition allBreakpoints = new CompoundStopCondition();

            Proof proof = env.getBuilder().getProof();
            StrategyProperties props =
                proof.getSettings().getStrategySettings().getActiveStrategyProperties();
            props.put(StrategyProperties.METHOD_OPTIONS_KEY, StrategyProperties.METHOD_EXPAND);
            props.put(StrategyProperties.LOOP_OPTIONS_KEY, StrategyProperties.LOOP_EXPAND);
            proof.getSettings().getStrategySettings().setActiveStrategyProperties(props);

            SymbolicExecutionExceptionBreakpoint firstBreakpoint =
                new SymbolicExecutionExceptionBreakpoint(proof, "java.lang.Exception", true, true,
                    true, true, -1);
            SymbolicExecutionBreakpointStopCondition bc =
                new SymbolicExecutionBreakpointStopCondition(firstBreakpoint);
            allBreakpoints.addChildren(bc);
            env.getProof().getServices().setFactory(createNewProgramVariableCollectorFactory(bc));
            // Do steps
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
            stepReturnWithBreakpoints(env.getUi(), env.getBuilder(),
                oraclePathInkeyRepDirectoryFile, ++oracleIndex, oracleFileExtension,
                testCaseDirectory, allBreakpoints);
        } finally {
            // Restore runtime option
            setOneStepSimplificationEnabled(null, originalOneStepSimplification);
            restoreTacletOptions(originalTacletOptions);
            if (env != null) {
                env.dispose();
            }
        }
    }
}
