package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import core.BaseTest;
import pages.BugReportPage;
import pages.LoginPage;
import pages.MenuPage;

@RunWith(Parameterized.class)
public class BugReportRulesTest extends BaseTest{
	
	private BugReportPage bugReportPage = new BugReportPage(); 
	private LoginPage loginPage = new LoginPage();
	private MenuPage menuPage = new MenuPage();
	
	@Parameter
	public String sResumo;
	
	@Parameter(value=1)
	public String sDescricao;
	
	@Parameter(value=2)
	public int iCategoria;
	
	@Parameter(value=3)
	public String sMensagem;
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", 0, "Um campo necessário 'Resumo' estava vazio. Por favor, verifique novamente suas entradas."},
			{"Resumo do Teste", "", 0, "Um campo necessário 'Descrição' estava vazio. Por favor, verifique novamente suas entradas."},
			{"Resumo do Teste", "Descrição do Teste", 0, "Um campo necessário 'Categoria' estava vazio. Por favor, verifique novamente suas entradas."}
		});
	}

	@Test
	public void validarRegrasBugReport(){
		loginPage.logar();
		menuPage.acessarTelaRelatarCaso();
		bugReportPage.escreverByName("summary", sResumo);
		bugReportPage.escreverByName("description", sDescricao);
		bugReportPage.selecionarComboCategoria(iCategoria);
		bugReportPage.clicarBotaEnviarRelatorio();
		Assert.assertEquals(sMensagem, bugReportPage.obterMensagem());
	}


}
