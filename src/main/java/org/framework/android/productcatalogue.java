package org.framework.android;


import java.util.List;

import org.framework.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class productcatalogue extends AndroidActions{
AndroidDriver driver;

@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
public List<WebElement> addToCart;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
public WebElement cart;
	
	public productcatalogue(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public void addItemtoCartByIndex(int index){
		addToCart.get(index).click();
	}
	public void goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
	}
}
