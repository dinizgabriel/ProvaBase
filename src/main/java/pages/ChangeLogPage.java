package pages;

import core.BasePage;

public class ChangeLogPage extends BasePage{
	
	public boolean verificarChangeLogPage() {
		if(getTitle().equals("Registro de Mudan�as - MantisBT")) {
			return true;
		}
		return false;
	}

}
