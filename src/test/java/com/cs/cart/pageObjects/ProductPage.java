package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
		WebDriverWait wait = new WebDriverWait(driver, 1);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ajax-overlay")));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sw_dropdown_8"))));
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
		return driver.findElement(By.linkText("My cart")).getText();
	}

	public void abreDropdownCarrinho() {
		WebElement iconeCarrinho = driver.findElement(By.id("sw_dropdown_8"));
		iconeCarrinho.click();
	}
	
	public CartContentPage abreCartPage() {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("sw_dropdown_8"))));
		WebElement cartBox = driver.findElement(By.id("dropdown_8"));
		cartBox.findElement(By.className("ty-float-left")).click();
		return new CartContentPage(driver);
	}
}
