package konfiguration;

import nutzerVerwaltung.Nutzer;

public class Session {
	private Nutzer currentUser;
	
	public Session(Nutzer currentUser) {
		this.currentUser = currentUser;
	}

	public Nutzer getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Nutzer currentUser) {
		this.currentUser = currentUser;
	}
	
	
}
