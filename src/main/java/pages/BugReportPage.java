package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class BugReportPage extends BasePage{
	
	public boolean verificarBugReportPage() {
		if(getTitle().equals("Relatar Caso - MantisBT")) {
			return true;
		}
		return false;
	}
	
	public void clicarBotaEnviarRelatorio() {
		String sPath = "//*[@value='Enviar Relatório']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public String obterMensagemErro() {
		String sPath = "//*[@style='color:red']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		return obterTexto(By.xpath(sPath));
	}
	
	public void escreverByName(String sName, String sTexto) {
		String sPath = "//*[@name='" + sName + "']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sTexto);
	}
	
	public void selecionarComboCategoria(int iIndex) {
		String sPath ="//*[@name='category_id']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		selecionarCombo(By.xpath(sPath), iIndex);
	}
	
	public String obterMensagem() {
		String sPath = "//*[@style='color:red']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		return obterTexto(By.xpath(sPath));
	}
	
}
