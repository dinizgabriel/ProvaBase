package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class AccountPage extends BasePage{

	public boolean verificarAccountPage() {
		if(getTitle().equals("Minha Conta - MantisBT")) {
			return true;
		}
		return false;
	}
	
	public void escreverSenha(String sSenha) {
		String sPath = "//*[@name='password']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sSenha);
	}
	
	public void escreverConfirmacaoSenha(String sConfirmacaoSenha) {
		String sPath = "//*[@name='password_confirm']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sConfirmacaoSenha);
	}
	
	public void clicarBotaoAlterarUsuario() {
		String sPath = "//input[@value='Atualizar Usuário']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
}
