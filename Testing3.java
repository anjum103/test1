package selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {

	SoftAssert softAssert = new SoftAssert();

	@Test(priority = 1) // creating a new user
	public void homeTest() {
		System.out.println("I am in home test");
		System.out.println("Before assertion");
		Assert.assertTrue(2 > 3, "Verifying Element");
		System.out.println("After assertion");
		Assert.assertEquals("abc", "abc");
	}

	@Test(priority = 2, dependsOnMethods="homeTest")  //Editing created user
	public void mainTest() {
		System.out.println("I am in main test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2 > 3, "Verifying Element");
		System.out.println("After assertion");
		softAssert.assertAll(); // similar to error collector in Junit
	}

	@Test(priority = 3, dependsOnMethods="mainTest")  //Deleting user
	public void endTest() {
		System.out.println("I am in end test");
		System.out.println("Before assertion");
		softAssert.assertTrue(2 > 3);
		System.out.println("After Assertion");
		softAssert.assertEquals("abc", "abc1");
		System.out.println("After second assertion");
		softAssert.assertAll();
	}
}



