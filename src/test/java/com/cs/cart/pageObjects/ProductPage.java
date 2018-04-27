package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void espera() {
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax-overlay")));
	}

	public void adicionaMaisUmProduto() {
		WebElement plusOneButton = driver.findElement(By.xpath("//*[@id=\"qty_238\"]/div/a[1]"));
		plusOneButton.click();		
	}

	public void adicionaAoCarrinho(String id) {
		WebElement addToCartButton = driver.findElement(By.id(id));
		addToCartButton.click();
	}

	public void veProdutosNoCarrinho(String id) {
		WebElement cartButton = driver.findElement(By.id(id));
		cartButton.click();
	}

	public void escreveNoCampoPesquisa(String texto) {
		WebElement campoDePesquisa = driver.findElement(By.id("search_input"));
		campoDePesquisa.sendKeys(texto);
	}

	public String lerDoCampoPesquisa() {
		WebElement campoDePesquisa = driver.findElement(By.id("search_input"));
		return campoDePesquisa.getText();
	}

	public void acionaPesquisa() {
		WebElement botaoAcionaPesquisa = driver.findElement(By.className("ty-icon-search"));
		botaoAcionaPesquisa.click();
	}

	public void selecionaProduto(String linkText) {
		WebElement produto = driver.findElement(By.linkText(linkText));
		produto.click();
	}

	public String nomeDoProduto() {
		return driver.getTitle();
	}

	public String meuCarrinho() {
		return driver.findElement(By.id("sw_dropdown_8")).getText();
	}

	public CartContentPage abreCarrinho() {
		WebElement dropdownCart = driver.findElement(By.id("sw_dropdown_8"));
		dropdownCart.click();
		WebElement viewCart = driver.findElement(By.linkText("View cart"));
		viewCart.click();
		return new CartContentPage(driver);
	}
}
