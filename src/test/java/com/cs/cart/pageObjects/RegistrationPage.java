package com.cs.cart.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
	
	private WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public String confereEmail() {
		WebElement email = driver.findElement(By.id("email"));
		return email.getAttribute("value");
	}
	
	public void digitaEmail(String email) {
		WebElement emailForm = driver.findElement(By.id("email"));
		emailForm.clear();
		emailForm.sendKeys(email);
	}
	
	public void digitaSenha(String senha) {
		WebElement password = driver.findElement(By.id("password1"));
		password.clear();
		password.sendKeys(senha);
	}
	
	public void confirmaSenha(String senha) {
		WebElement password = driver.findElement(By.id("password2"));
		password.clear();
		password.sendKeys(senha);
	}
	
	public void digitaAniversario(String dataDeAniversario) {
		WebElement aniversario = driver.findElement(By.id("birthday"));
		aniversario.sendKeys(dataDeAniversario);
	}

	public String confirmaAniversario() {
		WebElement aniversario = driver.findElement(By.id("birthday"));
		return aniversario.getAttribute("value");
	}
	
	public void notRobot() {
		WebElement robo = driver.findElement(By.id("recaptcha-anchor"));
//				.className("recaptcha-anchor"));
		robo.getAttribute("aria-checked").replaceAll("false", "true");
	}
	
	public void clicaRegister() {
		WebElement register = driver.findElement(By.name("dispatch[profiles.update]"));
		register.click();
	}
}
