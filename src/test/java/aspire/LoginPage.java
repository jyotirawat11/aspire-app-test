package aspire;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPage {

	@Test
	public void TestApp() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://aspireapp.odoo.com");

		// Login page

		driver.findElement(By.id("login")).sendKeys("user@aspireapp.com");
		driver.findElement(By.id("password")).sendKeys("@sp1r3app");

		// login button
		driver.findElementByTagName("button").click();
		Thread.sleep(1000);

		// inventory
		driver.findElementById("result_app_1").click();

		/// products menu
		driver.findElementByXPath("//button[@title='Products']").click();
		Thread.sleep(1000);

		// products option
		driver.findElementByXPath("//a[@data-menu-xmlid='stock.menu_product_variant_config_stock']").click();
		Thread.sleep(1000);

		// create
		driver.findElementByXPath("//button[@title='Create record']").click();

		// product name
		driver.findElement(By.id("o_field_input_11")).sendKeys("kathirollss");
		Thread.sleep(1000);

		driver.findElement(By.id("o_field_input_17")).click();
		driver.findElement(By.xpath("//*[text()='mm']")).click();
		driver.findElementByXPath("//button[@title='Save record']").click();

		Thread.sleep(1000);

		// update quantity
		driver.findElement(By.name("action_update_quantity_on_hand")).click();

		// create
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[2]/div[1]/div/div/button[4]")).click();

		driver.findElementByXPath("//button[@data-original-title='Create record']").click();

		driver.findElementByXPath("//input[@name='inventory_quantity']").clear();
		driver.findElementByXPath("//input[@name='inventory_quantity']").sendKeys("10.00");
		driver.findElementByXPath("//button[@title='Save record']").click();

		// Manufacturing
		driver.findElementByXPath("//a[@title='Home menu']").click();
		driver.findElement(By.xpath("//*[text()=\"Manufacturing\"]")).click();
		// Create
		driver.findElementByXPath("//button[@data-original-title='Create record']").click();

		// WebElement d = driver.findElementByName("product_id");
		driver.findElementByClassName("ui-autocomplete-input").sendKeys("kathirolls");

		driver.findElementByXPath("//a[text()='kathirolls']").click();

		driver.findElement(By.name("action_confirm")).click();
		Thread.sleep(2000);
		// mark as done
		// driver.findElement(By.name("qty_producing")).sendKeys("10.00");
		driver.findElementByXPath("//input[@name='qty_producing']").clear();
		driver.findElementByXPath("//input[@name='qty_producing']").sendKeys("10.00");
		// multiple button for name button mark done
		driver.findElementsByName("button_mark_done").get(3).click();

		// modal window

		String s1 = driver.findElement(By.className("modal-title")).getText();
		System.out.println(s1);

		driver.findElement(By.xpath("//*[text()='Ok']")).click();
		driver.quit();

	}

}
