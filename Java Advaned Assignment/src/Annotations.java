import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Student{
	int roll() default 312;
	String name() default "Nishu";
}

public class Annotations{

	@Student(roll=12, name="Nishant")
	public void StudentInfo() throws NoSuchMethodException, SecurityException
	{
		Class<? extends Annotations> cls = this.getClass();
		Method m = cls.getMethod("StudentInfo");
		Student ss = m.getAnnotation(Student.class);
		System.out.println("Roll Number: "+ss.roll());;
		System.out.println("Name: "+ss.name());
	}
	public static void main(String a[]) throws NoSuchMethodException, SecurityException{
		Annotations mat = new Annotations();
		mat.StudentInfo();}
}