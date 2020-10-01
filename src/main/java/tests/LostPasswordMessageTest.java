package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.LoginPage;
import pages.LostPasswordMessagePage;
import pages.LostPasswordPage;

public class LostPasswordMessageTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private LostPasswordPage lostPasswordPage = new LostPasswordPage();
	private LostPasswordMessagePage LostPasswordMessagePage =  new LostPasswordMessagePage();
	
	@Test
	public void voltarParaTelaLogin() {
		loginPage.clicarLostPassword();
		lostPasswordPage.recuperarPasswordComSucesso();
		LostPasswordMessagePage.clicarProceed();
		Assert.assertTrue(loginPage.verificarLoginPage());
	}
}
