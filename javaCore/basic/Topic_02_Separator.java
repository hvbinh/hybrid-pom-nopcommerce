package basic;

import java.io.File;

public  class Topic_02_Separator {

	 
	public static void main(String[] args) {
		String projectFolder = System.getProperty("user.dir");
		File file = new File(projectFolder + File.separator+"browserExtentions"+File.separator+"extension_2_0_9_0.crx");
		System.out.println("file: "+projectFolder);
		System.out.println("file: "+file);
	}

}
