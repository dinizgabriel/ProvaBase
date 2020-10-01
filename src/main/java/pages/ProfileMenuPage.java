package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class ProfileMenuPage extends BasePage{

	public boolean verificarProfileMenuPage() {
		if(getTitle().equals("Perfís - MantisBT")) {
			return true;
		}
		return false;
	}
	
	public void escreverByName(String sName, String sTexto) {
		String sPath = "//*[@name='" + sName + "']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sTexto);
	}
	
	public void clicarBotaoAdicionarPerfil() {
		String sPath = "//*[@value='Adicionar Perfil']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public String obterMensagem() {
		String sPath = "//*[@style='color:red']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		return obterTexto(By.xpath(sPath));
	}
}
