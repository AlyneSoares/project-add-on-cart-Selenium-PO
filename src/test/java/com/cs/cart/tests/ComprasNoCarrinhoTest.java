package com.cs.cart.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.cs.cart.pageObjects.CartContentPage;
import com.cs.cart.pageObjects.HomePage;
import com.cs.cart.pageObjects.ProductPage;
import com.cs.cart.pageObjects.SearchResultPage;


public class ComprasNoCarrinhoTest {

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
	public void pesquisaBatman() {
		homepage.abrePagina();
		assertEquals("Shopping Cart Software & Ecommerce Software Solutions by CS-Cart", homepage.getTitle());
		homepage.escreveNoCampoPesquisa("batman");
		SearchResultPage searchResultPage =  homepage.acionaPesquisa();
		assertEquals("Search results",searchResultPage.nomeDaTab());
	}


	@Test
	public void adicionaBatman() throws InterruptedException {
		homepage.abrePagina();
		homepage.escreveNoCampoPesquisa("batman");
		SearchResultPage searchResultPage = homepage.acionaPesquisa();
		ProductPage productPage = searchResultPage.selecionaProduto("Lego Batman (Wii)");
		assertEquals("Video Games :: Nintendo Wii :: Lego Batman (Wii)", productPage.nomeDoProduto());
		productPage.adicionaAoCarrinho("button_cart_84");	
		productPage.espera();
		assertEquals("MY CART\n1 item(s) for $19.99", productPage.meuCarrinho());
	}

	@Test
	public void adicionaIPhone() throws InterruptedException {
		homepage.abrePagina();
		homepage.escreveNoCampoPesquisa("batman");
		SearchResultPage searchResultPage = homepage.acionaPesquisa();
		ProductPage productPage = searchResultPage.selecionaProduto("Lego Batman (Wii)");
		productPage.adicionaAoCarrinho("button_cart_84");	
		productPage.espera();
		productPage.escreveNoCampoPesquisa("iPhone");
		productPage.espera();
		productPage.acionaPesquisa();
		productPage.selecionaProduto("Apple iPhone 4S Black");
		productPage.adicionaMaisUmProduto();
		productPage.adicionaAoCarrinho("button_cart_238");
		productPage.espera();
		assertEquals("MY CART\n3 item(s) for $1,019.97", productPage.meuCarrinho());
	}

	@Test
	public void confereCarrinhoTest() {
		homepage.abrePagina();
		homepage.escreveNoCampoPesquisa("batman");
		SearchResultPage searchResultPage = homepage.acionaPesquisa();
		ProductPage productPage = searchResultPage.selecionaProduto("Lego Batman (Wii)");
		productPage.adicionaAoCarrinho("button_cart_84");	
		productPage.espera();
		productPage.escreveNoCampoPesquisa("iPhone");
		productPage.acionaPesquisa();
		productPage.selecionaProduto("Apple iPhone 4S Black");
		productPage.adicionaMaisUmProduto();
		productPage.adicionaAoCarrinho("button_cart_238");
		productPage.espera();
		productPage.abreDropdownCarrinho();		
		CartContentPage cartPage = productPage.abreCartPage(); 
		assertEquals("2", cartPage.qtidadePrimeiroProduto());
		assertEquals("1", cartPage.qtidadeSegundoProduto());
		assertEquals("1,019.97", cartPage.valorTotal());

	}


}
