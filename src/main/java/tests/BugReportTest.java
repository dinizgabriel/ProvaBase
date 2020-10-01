package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.BugReportPage;
import pages.LoginPage;
import pages.MenuPage;

public class BugReportTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private MenuPage menuPage = new MenuPage();
	private BugReportPage bugReportPage = new BugReportPage();
	
	@Test
	public void enviarRelatorioVazio() {
		loginPage.logar();
		menuPage.acessarTelaRelatarCaso();
		bugReportPage.clicarBotaEnviarRelatorio();
		Assert.assertEquals("Um campo necessário 'Resumo' estava vazio. Por favor, verifique novamente suas entradas.", bugReportPage.obterMensagemErro());
	}
}
