package com.cs.cart.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.cs.cart.pageObjects.HomePage;
import com.cs.cart.pageObjects.RegistrationPage;

public class CriaCadastroDeClienteTeste {

	private HomePage homepage;

	@Before
	public void setUp() throws Exception {
		homepage = new HomePage();
	}

	@After
	public void tearDown() throws Exception {
		homepage.fechaBrowser();
	}
	
	@Test
	public void cadastraCliente() {
		homepage.abrePagina();
		RegistrationPage registrationPage = homepage.clickNoMenuMyAccount();
		
		assertEquals("Registration", registrationPage.getTitle());
		registrationPage.digitaEmail("teste@email.com");
		registrationPage.digitaSenha("teste");
		registrationPage.confirmaSenha("teste");
		assertEquals("teste@email.com", registrationPage.confereEmail());
		registrationPage.digitaAniversario("01/01/1990");
		assertEquals("01/01/1990", registrationPage.confirmaAniversario());
		registrationPage.clicaRegister();
//		registrationPage.notRobot();
		
	}

}
