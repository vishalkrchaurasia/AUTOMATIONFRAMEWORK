package script;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Result;

@Listeners(Result.class)
public class DemoA2 extends BaseTest{
	@Test
	public void testA(){
		Reporter.log("testA..",true);
	}
}
