package com.cs.cart.pageObjects;

import java.util.ArrayList;
import java.util.List;

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
		List<WebElement> nomeProduto = driver.findElements(By.className(".ty-cart-content__product-title"));
		String nome = nomeProduto.get(0).getText();
		return nome;
	}

	public List<String> nomeDosProdutos() {
		List<WebElement> produtos = driver.findElements(By.className(".ty-cart-content__product-title"));
		List<String> nomes = new ArrayList<String>();
		for (WebElement produto: produtos) {
			nomes.add(produto.getText());
		}
		return nomes;
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
