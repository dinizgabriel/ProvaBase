package pages;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.BasePage;

public class LostPasswordMessagePage extends BasePage{
	
	public String obterMensagemSucesso() {
		return obterTexto(By.xpath("//tbody//b"));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//*[@style='color:red']"));
	}
	
	public void clicarProceed() {
		String sLink = "Proceed";
		WebDriverWait espera = new WebDriverWait(getDriver(), 5);
		espera.until(ExpectedConditions.presenceOfElementLocated(By.linkText(sLink)));
		clicarLink(sLink);
	}
	
}
