package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import core.BaseTest;
import pages.LoginPage;
import pages.LostPasswordPage;
import pages.MyViewPage;

public class LoginTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private LostPasswordPage lostPasswordPage = new LostPasswordPage();
	private MyViewPage myViewPage = new MyViewPage();
	
	@Test
	public void loginVazio() {
		loginPage.loginVazio();
		Assert.assertTrue(loginPage.obterTexto(By.xpath("//font"))
				.equals("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
	
	@Test
	public void loginSemUsername() {
		loginPage.loginSemUsername();
		Assert.assertTrue(loginPage.obterTexto(By.xpath("//font"))
				.equals("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
	
	
	@Test
	public void loginSemPassword() {
		loginPage.loginVazio();
		Assert.assertTrue(loginPage.obterTexto(By.xpath("//font"))
				.equals("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
	
	@Test
	public void loginUsernameInvalido() {
		loginPage.loginUsernameInvalido();
		Assert.assertTrue(loginPage.obterTexto(By.xpath("//font"))
				.equals("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
	
	@Test
	public void loginPasswordInvalido() {
		loginPage.loginPasswordInvalido();
		Assert.assertTrue(loginPage.obterTexto(By.xpath("//font"))
				.equals("Your account may be disabled or blocked or the username/password you entered is incorrect."));
	}
	
	@Test
	public void clicarLostPassword() {
		loginPage.clicarLostPassword();
		Assert.assertTrue(lostPasswordPage.verificarLostPasswordPage());
	}
	
	@Test
	public void loginComSucesso() {
		loginPage.logar();
		Assert.assertTrue(myViewPage.verificarMyViewPage());
	}
}
