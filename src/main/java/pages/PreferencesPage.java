package pages;

import core.BasePage;

public class PreferencesPage extends BasePage{

	public boolean verificarPreferencesMenuPage() {
		if(getTitle().equals("PreferÍncias - MantisBT")) {
			return true;
		}
		return false;
	}
}
