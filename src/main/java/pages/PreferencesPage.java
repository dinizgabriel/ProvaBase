package pages;

import core.BasePage;

public class PreferencesPage extends BasePage{

	public boolean verificarPreferencesMenuPage() {
		if(getTitle().equals("Prefer�ncias - MantisBT")) {
			return true;
		}
		return false;
	}
}
