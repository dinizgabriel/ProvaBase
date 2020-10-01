package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.LoginPage;
import pages.ManageColumnsPage;
import pages.MenuAccountPage;
import pages.MenuPage;
import pages.PreferencesPage;
import pages.ProfileMenuPage;

public class MenuAccountTest extends BaseTest{

	private MenuPage menuPage = new MenuPage();
	private LoginPage loginPage = new LoginPage();
	private MenuAccountPage menuAccountPage = new MenuAccountPage();
	private ProfileMenuPage profileMenuPage = new ProfileMenuPage();
	private PreferencesPage preferencesPage = new PreferencesPage();
	private ManageColumnsPage manageColumnsPage = new ManageColumnsPage();
	
	@Test
	public void clicarPreferencias() {
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		menuAccountPage.acessarTelaPreferencias();
		Assert.assertTrue(preferencesPage.verificarPreferencesMenuPage());
	}
	
	@Test
	public void clicarGerenciasColunas() {
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		menuAccountPage.acessarTelaGerenciarColunas();
		Assert.assertTrue(manageColumnsPage.verificarManageColumnsPage());
	}
	
	@Test
	public void clicarPerfis() {
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		menuAccountPage.acessarTelaPerfis();
		Assert.assertTrue(profileMenuPage.verificarProfileMenuPage());
	}
}
