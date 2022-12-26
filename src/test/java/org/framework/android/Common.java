package org.framework.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Common {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
@BeforeClass
public void setup() throws MalformedURLException {
	
	 service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1")
		.usingPort(4723).build();
	// service.start();
	UiAutomator2Options options=new UiAutomator2Options();
	options.setDeviceName("Pixel 2 API 30");
	options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	//options.setApp("C:\\Users\\Admin\\eclipse-workspace\\aaaaa\\src\\test\\java\\Resources\\ApiDemos-debug.apk");
	options.setApp("C:\\Users\\Admin\\eclipse-workspace\\aaaaa\\src\\test\\java\\Resources\\General-Store.apk");
	
	
	
 driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}
public void longpressAction(WebElement ele) {
	((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
			"duration",2000));
}
public void scrollToEnd() {
	boolean camScrollMore;
	do
	{
		camScrollMore=(Boolean) ((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"left",100,"top",100,"width",200,"height",200,
				"direction","down",
				"percent",3.0
				));
	}while(camScrollMore);
}
public void swipeAction(WebElement firstImage,String direction) {
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",ImmutableMap.of(
			"elementId", ((RemoteWebElement)firstImage).getId(),
			"direction", direction,
			"percent",0.75
			));
}
public Double getAmount(String amount) {
	Double price=Double.parseDouble(amount.substring(1));
	return price;
}
@AfterClass
		

public void thread(){
			driver.quit();
			service.stop();
		
	
}
}
