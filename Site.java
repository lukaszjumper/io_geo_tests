package maly_geograf_tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Site {
	private static WebDriver driver;
	
	public Site() {
		//uruchamiam przeglądarkę
	       driver = new ChromeDriver();
	}
	
	public void open() {
		driver.get("http://localhost:8000/");
	}
	
	public void close() {
		driver.close();
	}
	
	void refresh() {
		driver.navigate().refresh();
	}
	
	void clickShowCoordinates() {
		driver.findElement(By.id("show")).click();
	}
	
	void clickClear() {
		driver.findElement(By.id("clear")).click();
	}
	
	void clickHipso() {
		driver.findElement(By.id("hipso")).click();
	}
	
	void click3d() {
		driver.findElement(By.id("3d")).click();
	}
	
	void closeModal() {
		driver.findElements(By.className("close")).get(0).click();
	}
	
	String modalTitle() {
		return driver.findElement(By.className("modal-title")).getText();
	}

	void zoomIn() {
		driver.findElements(By.className("leaflet-control-zoom-in")).get(0).click();
	}
	
	void zoomOut() {
		driver.findElements(By.className("leaflet-control-zoom-out")).get(0).click();
	}
	
	void someArea() {
		driver.findElements(By.className("leaflet-draw-draw-rectangle")).get(0).click();
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.tagName("body")), 0, 0);
		actions
			.clickAndHold()
			.moveByOffset(30, 30).release().build().perform();
	}
	
	int tabs = 1;
	
	boolean newTab() {
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
		if (tabs + 1 != browserTabs.size()) {
			return false;
		}
		else {
			tabs++;
			return true;
		}
	}
	
}
