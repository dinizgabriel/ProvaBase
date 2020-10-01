package pages;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class ViewAllBugPage extends BasePage {

	
	public boolean verificarViewAllBugPages() {
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='submit']")));
		String sTitulo = getDriver().getTitle();
		if(sTitulo.equals("Ver Casos - MantisBT")) {
			return true;
		}
		return false;
	}
	
	public void clicarLink(String sLink) {
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.linkText(sLink)));
		clicarLink(sLink);
	}
	
	public void clicarLink(By by) {
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(by));
		clicarLink(by);
	}
	
	public String selecionarComboCategoria(By by, int index) {
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(by));
		return selecionarCombo(by, 1);
	}
	
	public void clicarBotaoAplicarFiltro() {
		String sPath = "//form[@id='filters_form_open']//*[@type='submit' and @value='Aplicar Filtro']";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.elementToBeClickable(By.xpath(sPath)));
		clicarBotao(By.xpath(sPath));
	}
	
	public List<String> buscarCategoriasCasos(){
		List<WebElement> listaCategoriasCasos = getDriver().findElements(By.xpath("//table[@id='buglist']//tr[@border=1]//td[7]"));
		List<String> listaCategorias = new ArrayList<String>();
		for(WebElement categoria : listaCategoriasCasos) {
			listaCategorias.add(categoria.getText());
		}
		return listaCategorias;
	}
}
