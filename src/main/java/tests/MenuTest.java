package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.AccountPage;
import pages.BugReportPage;
import pages.ChangeLogPage;
import pages.LoginPage;
import pages.MenuPage;
import pages.MyViewPage;
import pages.RoadMapPage;
import pages.ViewAllBugPage;

public class MenuTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private MenuPage menuPage = new MenuPage();
	private MyViewPage myViewPage = new MyViewPage();
	private ViewAllBugPage viewAllBugPage = new ViewAllBugPage();
	private ChangeLogPage changeLogPage = new ChangeLogPage();
	private BugReportPage bugReportPage = new BugReportPage();
	private RoadMapPage roadMapPage = new RoadMapPage();
	private AccountPage accountPage = new AccountPage();
	
	@Test
	public void clicarMinhaVisao() {
		loginPage.logar();
		menuPage.acessarTelaMinhaVisao();
		Assert.assertTrue(myViewPage.verificarMyViewPage());
	}
	
	@Test
	public void clicarVerCasos() {
		loginPage.logar();
		menuPage.acessarTelaVerCasos();
		Assert.assertTrue(viewAllBugPage.verificarViewAllBugPages());
	}
	
	@Test
	public void clicarRelatarCaso() {
		loginPage.logar();
		menuPage.acessarTelaRelatarCaso();
		Assert.assertTrue(bugReportPage.verificarBugReportPage());
	}
	
	@Test
	public void clicarRegistroMudancas() {
		loginPage.logar();
		menuPage.acessarTelaRegistroMudancas();
		Assert.assertTrue(changeLogPage.verificarChangeLogPage());
	}
	
	@Test
	public void clicarPlanejamento() {
		loginPage.logar();
		menuPage.acessarTelaPlanejamento();
		Assert.assertTrue(roadMapPage.verificarRoadMapPage());
	}
	
	@Test
	public void clicarMinhaConta() {
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		Assert.assertTrue(accountPage.verificarAccountPage());
	}
	
	@Test
	public void clicarSair() {
		loginPage.logar();
		menuPage.acessarTelaSair();
		Assert.assertTrue(loginPage.verificarLoginPage());
	}
}
