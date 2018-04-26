package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

	private WebDriver driver;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProductPage selecionaProduto(String linkText) {
		WebElement produto = driver.findElement(By.linkText(linkText));
		produto.click();
		return new ProductPage(driver);
	}
}

