package pages;

import core.BasePage;

public class RoadMapPage extends BasePage{

	public boolean verificarRoadMapPage() {
		if(getTitle().equals("Planejamento - MantisBT")) {
			return true;
		}
		return false;
	}
}
