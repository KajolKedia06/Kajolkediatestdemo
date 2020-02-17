package Java_OOps;

public class thisconstrucor {
	String s="parent";
	int a;
	thisconstrucor(){
		
			System.out.println("patent is called");
		}
	
	thisconstrucor(int a){
		this.a=a;
		System.out.println("patent is called");
		System.out.println(a);
	}
	
	public static void main(String args[])
	  
	  {
		thisconstrucor ob=new thisconstrucor(10);
		
		// ob.display();
		 }
}
