package testscripts.display;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import testscripts.Constants;
import testscripts.mediaTypes.MusicTest;

public class DisplayMusicTabPlaylistStyleTest {
	
	@Test
	public static void checkEnableMusicPlaylist() throws Exception
	{
		MusicTest.music();

		Capabilities caps = new DesiredCapabilities();
		((DesiredCapabilities) caps).setJavascriptEnabled(true);
		((DesiredCapabilities) caps).setCapability("takesScreenshot", true);

		PhantomJSDriver wd;
		wd = new PhantomJSDriver(caps);
		wd.manage().window().setSize(new Dimension(1920, 1080));

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login to wordpress by admin account
		wd.get(Constants.WP_SERVER);
		Constants.login(wd, Constants.USERNAME1, Constants.UPASSWORD1);
		 System.out.println("Correctly Logged In");
		 
		 Constants.openrtMediaSettings(wd);

		wd.findElement(By.id("tab-rtmedia-display")).click();
		System.out.println("display clicked");
		
		((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/DisplayMusicTabPlaylistStyleTest0.png');");	
		 
		Thread.sleep(2000);
		
		
		List<WebElement> likes = wd.findElements(By.cssSelector("span.rt-form-checkbox> label[for=\"rt-form-checkbox-8\"] > div.rt-switch.has-switch > div.switch-animate.switch-off"));
		
		if (likes.size() != 0){

			likes.get(0).findElement(By.cssSelector("span.switch-right")).click();
			Thread.sleep(1000);
			((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/DisplayMusicTabPlaylistStyleTest1.png');");	

				
		}
		wd.findElement(By.id("rtmedia-settings-submit")).click();
		
		System.out.println("rtMedia Settings Saved");
				

		// Do a mouse over on the primary menu on top LHS
		new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-site-name > a.ab-item"))).build().perform();

		// Click on Visit Site

		wd.findElement(By.linkText("Visit Site")).click();
		
	//  Mouseover  on Profile (Howdy, admin) section , click on Media 

					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account > a.ab-item"))).build().perform();
					Thread.sleep(1000);
					new Actions(wd).moveToElement(wd.findElement(By.cssSelector("#wp-admin-bar-my-account-media > a.ab-item"))).click();
					wd.findElement(By.linkText("Media")).click();
					
		System.out.println("Media Clicked");		
				 
				 Thread.sleep(2000);				 
				 wd.findElement(By.id("rtmedia-nav-item-music")).click();
				 System.out.println("music clicked");
				 Thread.sleep(2000);
				 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/DisplayMusicTabPlaylistStyleTest2.png');");			 
				 /*wd.findElement(By.xpath(".//*[@id='mep_0']/div/div[3]/div[2]/button")).click();*/
				 wd.findElement(By.cssSelector("div.mejs-button.mejs-playpause-button.mejs-play")).click();
				  
	 ((PhantomJSDriver) wd).executePhantomJS("var page=this;" +"page.render('./screen/Display/Functional/DisplayMusicTabPlaylistStyleTest3.png');");			 
			
				 System.out.println(" Play button clicked");
				 
				 Constants.logout(wd);
		
		
	}
}
