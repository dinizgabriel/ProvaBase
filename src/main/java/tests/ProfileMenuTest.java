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
import pages.LoginPage;
import pages.MenuAccountPage;
import pages.MenuPage;
import pages.ProfileMenuPage;

@RunWith(Parameterized.class)
public class ProfileMenuTest extends BaseTest{

	private LoginPage loginPage = new LoginPage();
	private MenuPage menuPage = new MenuPage();
	private MenuAccountPage menuAccountPage = new MenuAccountPage();
	private ProfileMenuPage profileMenuPage = new ProfileMenuPage();
	
	@Parameter
	public String sPlataforma;
	
	@Parameter(value=1)
	public String sSistemaOperacional;
	
	@Parameter(value=2)
	public String sVersao;
	
	@Parameter(value=3)
	public String sMensagem; 
	
	@Parameters
	public static Collection<Object[]> getCollection(){
		return Arrays.asList(new Object[][] {
			{"", "", "", "Um campo necessário 'Plataforma' estava vazio. Por favor, verifique novamente suas entradas."},
			{"Linux", "", "", "Um campo necessário 'Sistema Operacional' estava vazio. Por favor, verifique novamente suas entradas."},
			{"Linux", "Ubuntu", "", "Um campo necessário 'Versão' estava vazio. Por favor, verifique novamente suas entradas."}
		});
	}
	
	@Test
	public void validarRegrasBugReport(){
		loginPage.logar();
		menuPage.acessarTelaMinhaConta();
		menuAccountPage.acessarTelaPerfis();
		profileMenuPage.escreverByName("platform", sPlataforma);
		profileMenuPage.escreverByName("os", sSistemaOperacional);
		profileMenuPage.escreverByName("os_build", sVersao);
		profileMenuPage.clicarBotaoAdicionarPerfil();
		Assert.assertEquals(sMensagem, profileMenuPage.obterMensagem());
	}


}
