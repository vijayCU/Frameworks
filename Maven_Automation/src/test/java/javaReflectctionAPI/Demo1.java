package javaReflectctionAPI;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

class A{
	public static void m1()
	{
		System.out.println("This is m1 method");
	}
	
	protected int m2()
	{
		System.out.println("This is m2 method");
		return 0;
	}
	
	public void m3()
	{
		System.out.println("This is m3 method");
	}
}
public class Demo1 {

	public static void main(String[] args) 
	{
		Class<A> c = A.class;
		Method[] allMethods = c.getDeclaredMethods();
		int methodcount=allMethods.length;
		System.out.println(methodcount);
		for(int i=0;i<methodcount;i++)
		{
			Method m = allMethods[i];
			//print Modifier
			String modifier = Modifier.toString(m.getModifiers());
		
			//Print return type
			Class<?> returntype = m.getReturnType();
			String rt = returntype.getName();
			
			//print Method name
			String mname = m.getName();
			
			System.out.println(modifier+" "+rt+" "+mname);
			
			//print method arguments
			Parameter[] allparam = m.getParameters();
			for(Parameter param :allparam)
			{
				System.out.print("("+param.getType()+" "+param.getName()+")");
			}
			System.out.println("");
		}
		
		
		
	}

}
