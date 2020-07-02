package com.picnic.testng;

	import org.testng.annotations.Test;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Ignore;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.AfterTest;

	public class Calculator {
	 
	private static int number2;
	    
	  @BeforeTest(alwaysRun=true)
	  public void beforeTest() {
	      Reporter.log("-----Starting the First program------------", true);
	  }
	  
	  @Parameters({"num2"})
	  @Test(priority=-1)
	  public static void count(final Integer num2) {
		 number2 = num2; 		  
	  }

	  @Test(priority=0,dataProvider="dp",groups={"Addition"})
	  public static void add(int number1,int number3) {
		  int num3 = number1 + number2;
	      Assert.assertTrue(num3>number1);
	      Reporter.log("--1st Addition Completed:: " + num3, true);
	   }
	  
	  
	  @Test(priority=1,dataProvider="dp",groups={"Subtraction"})
	   public static void sub(int number1, int number3) {
		  int num3 = number1 - number2;
	      Assert.assertNotEquals(num3,1);
	      Reporter.log("--1st Subtraction Completed:: " + num3, true);
	   }
	  
	 
	  @Test(priority=2,dataProvider="dp",groups={"Multiplication"})
	   public static void mul(int number1, int number3) {
		  int num3 = number1 * number2;
	      Assert.assertTrue(num3>=0);
	      Reporter.log("--1st Multiplication Completed:: " + num3, true);
	   }
	 
	  
	  @Test(priority=3,dataProvider="dp",groups={"Div_integer"})
	  public static void divInt(int number1, int number3) {
		  Assert.assertNotEquals(number2,0,"Cannot divide by 0!");
		  int num3 = number1 / number2;
	      Assert.assertFalse(num3<0);
	      Reporter.log("--1st Division for Integer Completed:: " + num3, true);
	   }
	 
	  
	  @Test(priority=4,dataProvider="dp",groups={"Div_real"})
	   public static void divReal(int number1, int number3) {
		  Assert.assertNotEquals(number2,0,"Cannot divide by 0!");
	      double num3 = (double)number1/number2;
	      Assert.assertFalse(num3<0);
	      Reporter.log("--1st Division for Real Number Completed:: " + num3, true);
	   }
	   
	  
	  @Test(priority=5,dataProvider="dp",groups={"Exponent"})
	   public static void exponent(int number1, int number3) {   	  
		  Assert.assertNotEquals(number2,0,"Please use a number greater than 0!");
	      int num3 = (int) Math.pow(number1, number2);
	      Reporter.log("--1st Exponent Completed:: " + num3, true);
	   }
	   

	  
	  @Test(priority=6,dataProvider="dp",groups={"Modulus"})
	   public static void modulus(int number1, int number3) {
		  Assert.assertNotEquals(number2,0,"Cannot divide by 0!");
	      int num3 = number1%number2;
	      Assert.assertEquals(true, num3>=0);
	      Reporter.log("--1st Modulus Completed:: " + num3, true);
	   }
	       
	   
	  
	  @Test(priority=7,dataProvider="dp",groups={"Inverse"})
	   public static void inverse(int num1,int number3) {
		  Assert.assertNotEquals(num1,0,"Cannot divide by 0!");
		  double num3 = (double)1 / number2;
		  Assert.assertTrue(num3>0);
		  Reporter.log("--1st Inverse Completed:: "+ num3, true);
	   }
	         
	  
	 
	  @Test(priority=8,dataProvider="dp",groups={"Negate"})
	   public static void negate(int number1,int x) {
		  Assert.assertNotEquals(number1,0,"User a number greater than 0!");
		  int num3 = (-1) * number2;
		  Assert.assertTrue(num3<0);
		  Reporter.log("-1st Negation Completed:: " + num3, true);
	  }  
	  
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] {6,4},
	    };
	  }

	  @AfterTest(alwaysRun=true)
	  public void afterTest() {
		  Reporter.log("------First Run Completed--------", true);
		 }
	}

