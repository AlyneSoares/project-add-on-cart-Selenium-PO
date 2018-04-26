package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartContentPage {

	private WebDriver driver;

	public CartContentPage(WebDriver driver) {
		this.driver = driver;
	}

	public String primeiroProduto() {
		String quantidade = driver.findElement(By.id("amount_80164162")).getAttribute("value");
		String nome = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/"
				+ "table/tbody/tr[1]/td[2]/div[2]/a[1]")).getAttribute("a");
		String nomeQuantidadeProdutos = nome + " " + quantidade;
		return nomeQuantidadeProdutos;
	}
	
	public String segundoProduto() {
		String quantidade = driver.findElement(By.id("amount_2012371633")).getAttribute("value");
		String nome = driver.findElement(By.xpath("//*[@id=\"cart_items\"]/"
				+ "table/tbody/tr[2]/td[2]/div[2]/a[1]")).getAttribute("a");
		String nomeQuantidadeProdutos = nome + " " + quantidade;
		return nomeQuantidadeProdutos;
	}
	
	public String valorTotal() {
		String valorTotal = driver.findElement(By.id("sec_cart_total")).getText();
		return valorTotal;
	}
	
//	public String[] produtosNoCarrinho() {
//	String[] produtos = new String[2];
//	for(String produto: produtos) {			
//		List<WebElement> celulas = driver.findElements(By.tagName("tr"));
//		for(WebElement c: celulas) {
//			String quantidade = driver.findElement(By.id("amount_80164162")).getAttribute("value");
//			String nomeProduto = driver.findElement(By.className("ty-cart-content__product-title")).getText(); 
//					
//		}
//	}
//	
//	public List<WebElement> produtosDoCarrinho() {
//		Object[] celulas = new ArrayList<WebElement>();
//		
//		celulas = driver.findElements(By.tagName("tr")).toArray();
//		.findElement(By.id("amount_80164162")).getAttribute("value");
//		String nomeProduto = driver.findElement(By.className("ty-cart-content__product-title")).getText(); 
//		produto[] = quantidade, nomeProduto;
//		}
//		
//	}
	
}
