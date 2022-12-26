package org.framework.android;



import org.framework.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class formpage extends AndroidActions{
	AndroidDriver driver;
	
	public formpage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Durga");
    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
    
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
    private WebElement femaleoptions;
    //driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
    @AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
    private WebElement maleoptions;
    
    @AndroidFindBy(id="android:id/text1")
    private WebElement countryselection;
    
    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public WebElement shopbutton;
    
    public void setnameField(String name) {
    	nameField.sendKeys(name);
    	driver.hideKeyboard();
    }
    public void setgender(String gender) {
    	if(gender.contains("female"))
    		femaleoptions.click();
    	else 
    		maleoptions.click();
    }
    public void setcountryselect(String Country) {
    	
    	countryselection.click();
    	scrolltotext(Country);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+Country+"']")).click();
    }
    public void submit() {
    	shopbutton.click();
    }
	
}
