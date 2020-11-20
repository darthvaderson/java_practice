package etc;

import java.lang.reflect.Method;

public class AnnotationExam {
	
	@MyAnnotation
	public void hello() {
		System.out.println("hello");
	}
	
	
	public static void main(String[] args) {
		AnnotationExam temp = new AnnotationExam();
		
		try {
			Method method = temp.getClass().getDeclaredMethod("hello");
			
			if(method.isAnnotationPresent(MyAnnotation.class)) {
				for(int i = 0 ; i < 100 ; i++) {
					temp.hello();
				}
			}else {
				temp.hello();
			}
		} catch (Exception e) {
			
		}
	}
}
