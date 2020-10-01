package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class MenuPage extends BasePage{

	public void acessarTelaMinhaVisao(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Minha Visão")));
		clicarLink("Minha Visão");
	}
	
	public void acessarTelaVerCasos(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Ver Casos")));
		clicarLink("Ver Casos");
	}
	
	public void acessarTelaRelatarCaso(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Relatar Caso")));
		clicarLink("Relatar Caso");
	}
	
	public void acessarTelaRegistroMudancas(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Registro de Mudanças")));
		clicarLink("Registro de Mudanças");
	}
	
	public void acessarTelaPlanejamento(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Planejamento")));
		clicarLink("Planejamento");
	}
	
	public void acessarTelaMinhaConta(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Minha Conta")));
		clicarLink("Minha Conta");
	}
	
	public void acessarTelaSair(){
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText("Sair")));
		clicarLink("Sair");
	}
}
