package rtb.appium;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kronos.global.PropertyFile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class KronosContextSwitch extends PropertyFile
{
	
	
	static AppiumDriver<MobileElement> driver;
	
	
	void setup()
	{
		        //Set the Desired Capabilities
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("deviceName", "My Phone");
				caps.setCapability("platformName", "Android");
				caps.setCapability("platformVersion", "7.0");
				caps.setCapability("appPackage", "com.kronos.mobile.android");
				caps.setCapability("appActivity", "com.kronos.mobile.android.alerts.PrerequisiteCheckActivity");
				caps.setCapability("noReset", "true");
				
				//Instantiate Appium Driver
				try {
						driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
				} catch (MalformedURLException e) {
					System.out.println(e.getMessage());
				}
		
		
	}
	
	
	void openManageRequest() throws Exception
	{
		
		driver.findElement(By.id("com.kronos.mobile.android:id/demo_btn")).click();
		driver.findElement(By.xpath("//*[@text='Manage Requests']")).click();
		Thread.sleep(5000);	
	}

	void swipeLeft()
	{
		TouchAction ta = new TouchAction(driver);
		ta.press(PointOption.point(497, 417)).moveTo(PointOption.point(60,417)).release().perform();
	}

	void approveRequest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@text='Approve']")));
		driver.findElement(By.xpath("//android.widget.Button[@text='Approve']")).click();
	}

	public static void switchToWebView() {
	    Set<String> contextNames = driver.getContextHandles();
	    String lastestContextView = (String) contextNames.toArray()[contextNames.size()-1];

	    if (lastestContextView.contains("WEBVIEW_") || lastestContextView.contains("WEBVIEW_com.xxxxxx.android.mobile.xxxxx")){
	    	driver.context(lastestContextView);
	    	System.out.println("Context View name :-"+lastestContextView);
	    }



	}
	
public static void main(String[] args) throws Exception {
	
	KronosContextSwitch kronos = new KronosContextSwitch();
	kronos.setup();
	kronos.openManageRequest();
	kronos.swipeLeft();
	kronos.approveRequest();
	
		
		
	}




}