package testListeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestNGitransformer implements IAnnotationTransformer {
	@SuppressWarnings("rawtypes")
	@Override
	public void transform(ITestAnnotation annotation,  Class testClass,  Constructor testConstructor,Method testMethod) {
		annotation.setRetryAnalyzer(FailedTestRerunner.class);
	}
}
