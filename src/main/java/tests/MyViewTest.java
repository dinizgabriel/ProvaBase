package tests;

import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import pages.LoginPage;
import pages.MyViewPage;
import pages.ViewAllBugPage;

public class MyViewTest extends BaseTest{
	
	private LoginPage loginPage = new LoginPage();
	private MyViewPage myViewPage = new MyViewPage();
	private ViewAllBugPage viewAllBugPage = new ViewAllBugPage();
	
	public void viewBugs(String sParam) {
		loginPage.logar();
		myViewPage.clicarLink(sParam);
		Assert.assertTrue(viewAllBugPage.verificarViewAllBugPages());
	}
	
	@Test
	public void clicarNaoAtribuidos() {
		viewBugs("Não Atribuídos");
	}
	
	@Test
	public void clicarResolvidos() {
		viewBugs("Resolvidos");
	}
	
	@Test
	public void clicarMonitoradosPorMim() {
		viewBugs("Monitorados por Mim");
	}
	
	@Test
	public void clicarRelatadosPorMim() {
		viewBugs("Relatados por Mim");
	}
	
	@Test
	public void clicarModificadosRecentemente() {
		viewBugs("Modificados Recentemente");
	}
	
	@Test
	public void clicarBotaoIrParaVazio() {
		loginPage.logar();
		myViewPage.clicarBotaoIrPara();
		Assert.assertEquals("Um número era esperado para bug_id.", myViewPage.obterMensagemErro());
	}
	
	@Test
	public void clicarBotaoIrParaComIdInvalido() {
		loginPage.logar();
		myViewPage.clicarBotaoIrPara();
		myViewPage.escreverCaso("A"); //Id Caso incorreto
		Assert.assertEquals("Um número era esperado para bug_id.", myViewPage.obterMensagemErro());
	}
	
	@Test
	public void clicarBotaoIrParaComIdCorreto() {
		loginPage.logar();
		myViewPage.clicarBotaoIrPara();
		String sIdValido = myViewPage.getIdValido();
		if(sIdValido.equals("")) {
			Assert.assertTrue(true);//Ignorar o teste pois não existem casos cadastrados
			return;
		}
		myViewPage.escreverCaso(sIdValido);
		Assert.assertEquals("Um número era esperado para bug_id.", myViewPage.obterMensagemErro());
	}
	
	
	
	@Test
	public void clicarRecentementeVisitados() {
		loginPage.logar();
		myViewPage.clicarBotaoIrPara();
		String sRecentementeVisitadoValido = myViewPage.getRecentementeVisitadoValido();
		if(sRecentementeVisitadoValido.equals("")) {
			Assert.assertTrue(true);//Ignorar o teste pois não existem recentemente visitados
			return;
		}
		myViewPage.clicarRecetementeVisitado(sRecentementeVisitadoValido);
		Assert.assertTrue(myViewPage.getTitle().startsWith(sRecentementeVisitadoValido));
	}
	
}
