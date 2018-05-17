package com.cs.cart.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;

	public HomePage() {
		System.setProperty("webdriver.chrome.driver", "/home/alyne/workspace/chromedriver");
		driver = new ChromeDriver();
	}
	
	public void abrePagina() {
		driver.get("http://demo.cs-cart.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void fechaBrowser() {
		driver.quit();
	}

	public void escreveNoCampoPesquisa(String texto) {
		WebElement campoDePesquisa = driver.findElement(By.id("search_input"));
		campoDePesquisa.sendKeys(texto);
	}

	public String lerDoCampoPesquisa() {
		WebElement campoDePesquisa = driver.findElement(By.id("search_input"));
		return campoDePesquisa.getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public SearchResultPage acionaPesquisa() {
		WebElement botaoAcionaPesquisa = driver.findElement(By.cssSelector(".ty-search-magnifier"));
		botaoAcionaPesquisa.click();
		return new SearchResultPage(driver);
	}

	public RegistrationPage clickNoMenuMyAccount() {
		WebElement menuMyAccount = driver.findElement(By.linkText("Create account"));
		menuMyAccount.click();
		return new RegistrationPage(driver);

	}

}