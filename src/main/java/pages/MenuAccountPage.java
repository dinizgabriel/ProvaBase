package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class MenuAccountPage extends BasePage{

	public void acessarTelaMinhaVisaoConta(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Minha Conta")));
		clicarLink("Minha Conta");
	}
	
	public void acessarTelaPreferencias(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Preferências")));
		clicarLink("Preferências");
	}
	
	public void acessarTelaGerenciarColunas(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Gerenciar Colunas")));
		clicarLink("Gerenciar Colunas");
	}
	
	public void acessarTelaPerfis(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Perfís")));
		clicarLink("Perfís");
	}
}
