package keywrod_FrameWork;

import java.lang.reflect.Method;

class A{
	static void m1()
	{
		System.out.println("This is m1 method ");
	}
	
	static void m1(String s)
	{
		System.out.println("This is m1 method with String :"+s);
	}
	
	static void m1(String s1,String s2)
	{
		System.out.println("This is m1 method with Strings :"+s1+" and "+s2);
	}
	
	
}
public class RemovalofForloopingforInvoke {

	public static void main(String[] args) throws Exception 
	{
		A.class.getDeclaredMethod("m1",String.class).invoke(null, "vijay");
		A.class.getDeclaredMethod("m1",String.class,String.class).invoke(null, "vijay","udagatti");
//		Method[] allMethods = A.class.getDeclaredMethods();
//		for(Method method:allMethods )
//		{
//				method.invoke(null,"vijay");
//		}
	}
}
