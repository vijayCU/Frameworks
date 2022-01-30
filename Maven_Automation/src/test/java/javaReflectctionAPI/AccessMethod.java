package javaReflectctionAPI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

class B{
	public static void m1()
	{
		System.out.println("This is m1 method");
	}
	
	protected static void m2()
	{
		System.out.println("This is m2 method");
	}
	
	
}
public class AccessMethod {

	public static void main(String[] args) throws Exception 
	{
		String methodToRun="m1";
		Class<B> c = B.class;
		Method[] allMethods = c.getDeclaredMethods();
		for(Method method:allMethods )
		{
			//print Method name
			String mname = method.getName();
			if(mname.equals(methodToRun))
			{
				method.invoke(null);//call method without object bcz it it is static
			}
		}
	}
}
