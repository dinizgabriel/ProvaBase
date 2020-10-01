package tests;

import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import pages.LoginPage;
import pages.LostPasswordMessagePage;
import pages.LostPasswordPage;

public class LostPasswordTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private LostPasswordPage lostPasswordPage = new LostPasswordPage();
	private LostPasswordMessagePage lostPasswordMessagePage = new LostPasswordMessagePage();
	
	@Test
	public void acessarTelaLostPassword() {
		loginPage.clicarLostPassword();
		Assert.assertTrue(lostPasswordPage.verificarLostPasswordPage());
	}
	
	@Test
	public void resestPasswordVazio() {
		loginPage.clicarLostPassword();
		lostPasswordPage.clicarBotaoSubmit();
		Assert.assertEquals("Invalid e-mail address.", lostPasswordMessagePage.obterMensagemErro());
	}
	
	@Test
	public void resetPasswordSemUsername() {
		loginPage.clicarLostPassword();
		lostPasswordPage.resetPasswordSemUsername();
		Assert.assertEquals("The provided information does not match any registered account!", lostPasswordMessagePage.obterMensagemErro());
	}
	
	@Test
	public void resetPasswordSemEmail() {
		loginPage.clicarLostPassword();
		lostPasswordPage.resetPassworSemEmail();
		Assert.assertEquals("Invalid e-mail address.", lostPasswordMessagePage.obterMensagemErro());
	}
	
	@Test
	public void resetPasswordUsernameInvalido() {
		loginPage.clicarLostPassword();
		lostPasswordPage.resetPasswordUsernameInvalido();
		Assert.assertEquals("The provided information does not match any registered account!", lostPasswordMessagePage.obterMensagemErro());
	}
	
	@Test
	public void resetPasswordEmailInvalido() {
		loginPage.clicarLostPassword();
		lostPasswordPage.resetPasswordEmailInvalido();
		Assert.assertEquals("The provided information does not match any registered account!", lostPasswordMessagePage.obterMensagemErro());
	}
	
	@Test
	public void verificarEnvioEmailResetPasswordComSucesso() {
		loginPage.clicarLostPassword();
		lostPasswordPage.recuperarPasswordComSucesso();
		Assert.assertEquals("Password Message Sent", lostPasswordMessagePage.obterMensagemSucesso());
	}
}
