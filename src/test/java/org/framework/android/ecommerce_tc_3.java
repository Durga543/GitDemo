package org.framework.android;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ecommerce_tc_3 extends Common{
	@Test
	public void fillform() throws InterruptedException {
		
		formpage formpage=new formpage(driver);
		formpage.setnameField("Durga");
		formpage.setgender("female");
		formpage.setcountryselect("Argentina");
		formpage.submit();
		productcatalogue product=new productcatalogue(driver);
		product.addItemtoCartByIndex(0);
		product.addItemtoCartByIndex(0);
		product.goToCartPage();
		
		
		
	   // driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	   // driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
	  //driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[0]")).click();
	 // driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	 // Thread.sleep(3000);
	  WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.attributeContains(By.id("com.androidsample.generalstore:id/toolbar_title"),"text","Cart"));
	List<WebElement> productPrice= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	int count=productPrice.size();
	double total=0;
	
	for(int i=0;i<count;i++)
	{
		String amount=productPrice.get(i).getText();
		Double price=getAmount(amount);
		total=total+price;
	}

	String totalamount=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	Double sum=getAmount(totalamount);
	Assert.assertEquals(total,sum);
	WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	longpressAction(ele);
	driver.findElement(By.id("android:id/button1")).click();
	driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	Thread.sleep(3000);
	
}
}