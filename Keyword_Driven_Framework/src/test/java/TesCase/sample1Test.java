package TesCase;

import org.testng.annotations.Test;

import com.qa.demo.ExcutionEngine.ExecuteEngine;

public class sample1Test {

	public ExecuteEngine e;
	@Test
	public void testCase()
	{
		e=new ExecuteEngine();
		e.coreEngine();
	}
	
}
