package com.mxj.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTest {

	
	
	@Test
   public void testSelenium() {
		//       System.getProperties().setProperty("webdriver.chrome.driver", "C:\\Users\\haima\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//       WebDriver webDriver = new ChromeDriver();
		//       webDriver.get("http://huaban.com/");
		//       WebElement webElement = webDriver.findElement(By.xpath("/html"));
		//       System.out.println(webElement.getAttribute("outerHTML"));
		//       webDriver.close();
		
		Object obj= null;
		String str=(String)obj;
		Double doub=(Double)obj;
		System.out.println(str);
		System.out.println(doub);
		
		String ch="A";
		ch.charAt(0);
		
		int a=11;
		short shortValue = ((Number)a).shortValue();
		
   }
}
