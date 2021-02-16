package Resources;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Transforannotation implements IAnnotationTransformer{

	public void transform(ITestAnnotation transform, Class arg1, Constructor arg2, Method arg3) {
		// TODO Auto-generated method stub
		transform.setRetryAnalyzer(ClassForRetry.class);
		
		
		
		
	}

}
