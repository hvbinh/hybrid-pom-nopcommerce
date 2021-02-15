package exceptions;

public class Java_Exception {

	public static void main(String[] args) {
		

		try {
			int a = 4/0;
			System.out.println("a ="+a);
			
			
			
		}catch(Throwable e)
		{
			System.out.println("error");
			
		}
		System.out.println("closed");

	}

}
