package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {

	/********* Title ************/
	public String getTitle() {
		return getDriver().getTitle();
	}
	
	
	/********* TextField e TextArea ************/
	
	public void escrever(By by, String sTexto){
		getDriver().findElement(by).clear();
		getDriver().findElement(by).sendKeys(sTexto);
	}

	public void escrever(String sIdCampo, String sTexto){
		escrever(By.id(sIdCampo), sTexto);
	}
	
	public String obterValorCampo(String sIdCampo) {
		return getDriver().findElement(By.id(sIdCampo)).getAttribute("value");
	}
	
	/********* Radio e Check ************/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarRadio(String sId) {
		clicarRadio(By.id(sId));
	}
	
	public boolean isRadioMarcado(String sId){
		return getDriver().findElement(By.id(sId)).isSelected();
	}
	
	public void clicarCheck(String sId) {
		getDriver().findElement(By.id(sId)).click();
	}
	
	public boolean isCheckMarcado(String sId){
		return getDriver().findElement(By.id(sId)).isSelected();
	}
	
	/********* Combo ************/
	
	public void selecionarCombo(String sId, String sValor) {
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		combo.selectByVisibleText(sValor);
	}
	
	public String selecionarCombo(By by, int iIndex) {
		WebElement element = getDriver().findElement(by);
		Select combo = new Select(element);
		combo.selectByIndex(iIndex);
		return obterTexto(by);
	}
	
	public void deselecionarCombo(String sId, String sValor) {
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		combo.deselectByVisibleText(sValor);
	}

	public String obterValorCombo(String sId) {
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public List<String> obterValoresCombo(String sId) {
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	
	public int obterQuantidadeOpcoesCombo(String sId){
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		return options.size();
	}
	
	public boolean verificarOpcaoCombo(String sId, String sOpcao){
		WebElement element = getDriver().findElement(By.id(sId));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option : options) {
			if(option.getText().equals(sOpcao)){
				return true;
			}
		}
		return false;
	}
	
	/********* Botao ************/
	
	public void clicarBotao(By by) {
		getDriver().findElement(by).click();
	}
	public void clicarBotao(String sId) {
		clicarBotao(By.id(sId));
	}
	
	public void clicarBotaoPorTexto(String sTexto){
		clicarBotao(By.xpath("//button[.='" + sTexto + "']"));
	}
	
	public String obterValueElemento(String sId) {
		return getDriver().findElement(By.id(sId)).getAttribute("value");
	}
	
	/********* Link ************/
	
	public void clicarLink(String sLink) {
		getDriver().findElement(By.linkText(sLink)).click();
	}
	
	/********* Textos ************/
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public String obterTexto(String sId) {
		return obterTexto(By.id(sId));
	}
	
	/********* Alerts ************/
	
	public String alertaObterTexto(){
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaObterTextoEAceitar(){
		Alert alert = getDriver().switchTo().alert();
		String sValor = alert.getText();
		alert.accept();
		return sValor;
	}
	
	public String alertaObterTextoENegar(){
		Alert alert = getDriver().switchTo().alert();
		String sValor = alert.getText();
		alert.dismiss();
		return sValor;
	}
	
	public void alertaEscrever(String sValor) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(sValor);
		alert.accept();
	}
	
	/********* Frames e Janelas ************/
	
	public void entrarFrame(String sId) {
		getDriver().switchTo().frame(sId);
	}
	
	public void sairFrame(){
		getDriver().switchTo().defaultContent();
	}
	
	public void trocarJanela(String sId) {
		getDriver().switchTo().window(sId);
	}
	
	/************** JS *********************/
	
	public Object executarJS(String sComando, Object... param) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(sComando, param);
	}
	
	/************** Tabela *********************/
	
	public WebElement obterCelula(String sColunaBusca, String sValor, String sColunaBotao, String sIdTabela){
		//procurar coluna do registro
		WebElement tabela = getDriver().findElement(By.xpath("//*[@id='" + sIdTabela + "']"));
		int iIdColuna = obterIndiceColuna(sColunaBusca, tabela);
		
		//encontrar a linha do registro
		int iIdLinha = obterIndiceLinha(sValor, tabela, iIdColuna);
		
		//procurar coluna do botao
		int iIdColunaBotao = obterIndiceColuna(sColunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + iIdLinha + "]/td[" + iIdColunaBotao + "]"));
		return celula;
	}
	
	public void clicarBotaoTabela(String sColunaBusca, String sValor, String sColunaBotao, String sIdTabela){
		WebElement celula = obterCelula(sColunaBusca, sValor, sColunaBotao, sIdTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String sValor, WebElement tabela, int iIdColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[" + iIdColuna + "]"));
		int iIdLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(sValor)) {
				iIdLinha = i + 1;
				break;
			}
		}
		return iIdLinha;
	}

	protected int obterIndiceColuna(String sColuna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int iIdColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(sColuna)) {
				iIdColuna = i + 1;
				break;
			}
		}
		return iIdColuna;
	}
	
	public List<String> obterTextosTabela(By by){
		List<WebElement> elementos = getDriver().findElements(by);
		List<String> textos = new ArrayList<String>();
		for(WebElement elemento : elementos) {
			textos.add(elemento.getText());
		}
		return textos;
	}
}