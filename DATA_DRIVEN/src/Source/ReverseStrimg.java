package Source;

public class ReverseStrimg {
public static void main(String args[]) {
	String s="abcde";
	String r="";
	for(int i=s.length()-1;i>=0;i--) {
		r=r+s.charAt(i);
	}
	System.out.println(r);
}
}