package javaReflectctionAPI;

import java.lang.reflect.Method;

class D{
	public void m1(int i)
	{
		System.out.println("This is m1 method :"+i);
	}
	
	protected void m2(int j,String v)
	{
		System.out.println("This is m2 method: "+j+" and name is :"+v);
	}
	
	
}
public class AccessMethod3 {

	public static void main(String[] args) throws Exception 
	{
		String methodToRun="m2";
		Class<D> c = D.class;
		Method[] allMethods = c.getDeclaredMethods();
		for(Method method:allMethods )
		{
			//print Method name
			String mname = method.getName();
			if(mname.equals(methodToRun))
			{
				method.invoke(new D(),15,"vijay");//call method using object bcz it it is non-static
			}
		}
	}
}
