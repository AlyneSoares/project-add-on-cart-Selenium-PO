package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartContentPage {

	private WebDriver driver;

	public CartContentPage(WebDriver driver) {
		this.driver = driver;
	}

	public String qtidadePrimeiroProduto() {
		String quantidade = driver.findElement(By.id("amount_80164162")).getAttribute("value");
		return quantidade;
	}
	
	public String nomePrimeiroProduto() {
		WebElement nomeProduto = driver.findElement(By.tagName("<a href=\"http://demo.cs-cart.com/stores/c99d5e432073cb8e/electronics/cell-phones/apple-iphone/apple-iphone-4s-black/\" class=\"ty-cart-content__product-title\">"));
		String nome = nomeProduto.getText();
		return nome;
	}
	
	public String qtidadeSegundoProduto() {
		String quantidade2 = driver.findElement(By.id("amount_2012371633")).getAttribute("value");
		return quantidade2;
	}
	
	public String valorTotal() {
		String valorTotal = driver.findElement(By.id("sec_cart_total")).getText();
		return valorTotal;
	}
		
}
