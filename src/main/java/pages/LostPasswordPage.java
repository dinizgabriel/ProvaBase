package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class LostPasswordPage extends BasePage{
	
	public static String sUsername = "gabriel.diniz";
	public static String sUsernameInvalido = "gabriel.dnz";
    public static String sEmail = "dinizgabriel1906@gmail.com";
    public static String sEmailInvalido = "dinizgabriel1906@hotmail.com";
	
	public boolean verificarLostPasswordPage() {
		if(obterTexto(By.xpath("//form[@name='lost_password_form']//td[@class='form-title']")).equals("Password Reset")) {
			return true;
		}
		return false;
	}
	
	public void setUsername(String sUsername) {
		String sPath = "//input[@name='username']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sUsername);
	}
	
	public void setEmail(String sEmail) {
		String sPath = "//input[@name='email']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sEmail);
	}
	
	public void clicarBotaoSubmit() {
		String sPath = "//input[@type='submit']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public void recuperarPasswordComSucesso() {
		setUsername(sUsername);
		setEmail(sEmail);
		clicarBotaoSubmit();
	}
	
	public void clicarLinkLogin() {
		clicarLink("Login");
	}
	
	public void resetPasswordUsernameInvalido() {
		setUsername(sUsernameInvalido);
		setEmail(sEmail);
		clicarBotaoSubmit();
	}

	public void resetPasswordEmailInvalido() {
		setUsername(sUsername);
		setEmail(sEmailInvalido);
		clicarBotaoSubmit();
	}

	public void resetPasswordSemUsername() {
		setEmail(sEmail);
		clicarBotaoSubmit();
	}

	public void resetPassworSemEmail() {
		setUsername(sUsername);
		clicarBotaoSubmit();
	}
}
