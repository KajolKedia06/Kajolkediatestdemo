package Java_OOps;

public class Static2 extends StaticKeyword1{
	static int a;
	public static void view(){
		a=20;
		display();
		System.out.println(a);
	}
	public static void main(String args[]) {
		
		Static2.view();
	}
}
