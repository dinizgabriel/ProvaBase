package pages;

import core.BasePage;

public class ManageColumnsPage extends BasePage{

	public boolean verificarManageColumnsPage() {
		if(getTitle().equals("Gerenciar Colunas - MantisBT")) {
			return true;
		}
		return false;
	}
}
