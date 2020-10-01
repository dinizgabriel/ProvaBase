package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class LoginPage extends BasePage{

	public static String URL = "https://mantis-prova.base2.com.br";
	public static String sUsername = "gabriel.diniz";
	public static String sUsernameInvalido = "gabriel.dnz";
    public static String sPassword = "Base2020";
    public static String sPasswordInvalido = "Bs2020";
	
    public boolean verificarLoginPage() {
    	if(obterTexto(By.xpath("//*[@class='form-title']")).equals("Login")) {
    		return true;
    	}
    	return false;
    }
    
	public void acessarTelaInicial(){
		getDriver().get(URL);
	}
	
	public void setUsername(String sUsername) {
		String sPath = "//input[@name='username']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sUsername);
	}
	
	public void setPassword(String sPassword) {
		String sPath = "//input[@name='password']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sPassword);
	}
	
	
	
	public void clicarBotaoLogin() {
		String sPath = "//input[@type='submit']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public void loginVazio() {
		clicarBotaoLogin();
	}
	
	public void loginSemUsername() {
		setPassword(sPassword);
		clicarBotaoLogin();
	}
	
	public void loginSemPassword() {
		setUsername(sUsername);
		clicarBotaoLogin();
	}
	
	public void loginUsernameInvalido() {
		setUsername(sUsernameInvalido);
		setPassword(sPassword);
		clicarBotaoLogin();
	}
	
	public void loginPasswordInvalido() {
		setUsername(sUsername);
		setPassword(sPasswordInvalido);
		clicarBotaoLogin();
	}
	
	public void logar() {
		setUsername(sUsername);
		setPassword(sPassword);
		clicarBotaoLogin();
	}
	
	public void clicarLostPassword() {
		String sLink = "Lost your password?";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
        espera.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(By.linkText(sLink))));
		clicarLink(sLink);
	}
	
	
}
