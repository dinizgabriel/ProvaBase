package pages;

import static core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class MyViewPage extends BasePage{

	public boolean verificarMyViewPage() {
		if(getTitle().equals("Minha Visão - MantisBT")) {
			return true;
		}
		return false;
	}
	
	public void clicarBotaoIrPara() {
		String sPath = "//*[@value='Ir para']"; 
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//*[@style='color:red']"));
	}
	
	public void escreverCaso(String sIdCaso) {
		String sPath = "//input[@name='bug_id']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(sPath)));
		escrever(By.xpath(sPath), sIdCaso);
	}
	
	public String getIdValido() {
		return getPrimeiroElementoValido("//span[@class='small']//a");
	}
	
	public String getRecentementeVisitadoValido() {
		return getPrimeiroElementoValido("//small//a ");
	}

	private String getPrimeiroElementoValido(String sPath) {
		List<WebElement> listaIds = getDriver().findElements(By.xpath(sPath));
		if(listaIds.size() > 0) {
			return listaIds.get(0).getText();
		}
		return "";
	}
	
	public void clicarRecetementeVisitado(String sLink) {
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText(sLink)));
		clicarLink(sLink);
	}
	
	public String getTitleRecetementeVisitado() {
		return getTitle();
	}
	
}
