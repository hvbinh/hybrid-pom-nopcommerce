package commons;

import java.util.Random;

public class AbstractTest {
	protected int randomNumber()
	{
		Random random = new Random();
		return random.nextInt(999999);
	}
}
