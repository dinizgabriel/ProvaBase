package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.LoginPage;
import pages.MenuPage;

public class AccountTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private MenuPage menuPage = new MenuPage();
	private AccountPage accountPage = new AccountPage();
	
	@Test
	public void acessarTelaLostPassword() {
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		Assert.assertTrue(accountPage.verificarAccountPage());
	}
}
