package javaReflectctionAPI;

import java.lang.reflect.Method;

class C{
	public void m1()
	{
		System.out.println("This is m1 method");
	}
	
	protected void m2()
	{
		System.out.println("This is m2 method");
	}
	
	
}
public class AccessMethod2 {

	public static void main(String[] args) throws Exception 
	{
		String methodToRun="m2";
		Class<C> c = C.class;
		Method[] allMethods = c.getDeclaredMethods();
		for(Method method:allMethods )
		{
			//print Method name
			String mname = method.getName();
			if(mname.equals(methodToRun))
			{
				method.invoke(new C());//call method using object bcz it it is non-static
			}
		}
	}
}
