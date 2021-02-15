package basic;

public class Java_Basic {

	public static void main(String[] args) {
		String automation = "automation FC";
		System.out.println("length = "+automation.length());
		System.out.println("text at 5 = "+automation.charAt(5));
		//noi chuoi
		String testing = automation.concat(" group");
		System.out.println("noi chuoi "+testing);
		
		int index1 = testing.indexOf("group");
		int index2 = testing.indexOf("FC");
		System.out.println("index1="+index1);
		System.out.println("index2="+index2);
		System.out.println("sub string: "+testing.substring(index1));
		
		String text = "Automation 01 Testing 345 Tutorials Online 123456";
		System.out.println("1.");
		int countA = count_A_In_Text(text,"a");
		System.out.println("count a in text = "+countA);
		System.out.println("2.");
		System.out.println("is Testing exitsted in text? answer is: "+checkTestingExisted(text, "testing"));
		
		System.out.println("3.");
		System.out.println("is text start with 'Automation'? answer is: "+checkStartWithText(text, "Automation"));
		
		System.out.println("4.");
		System.out.println("is text end with 'Automation'? answer is: "+checkEndtWithText(text, "Online"));
		
		System.out.println("5.");
		System.out.println("get position of 'Tutorials': "+positionofText(text, "Tutorials"));
		
		System.out.println("6.");
		System.out.println("replace 'Online' by 'Offline' ");
		replaceOnlinebyOffine(text);
		
	}
	//count a in text
	static int count_A_In_Text(String text,String character)
	{
		int count =0;
		for(int i=0;i<text.length();i++)
		{
			if(text.charAt(i)=='a'||text.charAt(i)=='A')
			{
				count ++;
			}
		}
		return count;
		
	}
	//check "Testing" is exsited in text
	static boolean checkTestingExisted(String text,String str)
	{
		String[] arr = text.split(" ");
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].equalsIgnoreCase("Testing"))
			{
				return true;
			}
		}
		return false;
	}
	//check is text start with "Automation"
	static boolean checkStartWithText(String text,String textStarwith)
	{
		return text.startsWith(textStarwith);
	}
	//check is text end with "Online"
	static boolean checkEndtWithText(String text,String textStarwith)
	{
		return text.endsWith(textStarwith);
	}
	//get position of 'Tutorials'
	static int positionofText(String text,String TextNeedPosition)
	{
		return text.indexOf(TextNeedPosition)+1;
	}
	//replace online = offline
	static void replaceOnlinebyOffine(String text)
	{
		String[] arr = text.split(" ");
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].equalsIgnoreCase("Online"))
			{
				arr[i] = "Offline";
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
	}
}
