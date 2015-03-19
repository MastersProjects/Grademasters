package ch.grademasters.model;

public class UserRegistration {
	private String Username;
	private byte[] Passwort;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public byte[] getPasswort() {
		return Passwort;
	}

	public void setPasswort(byte[] key) {
		Passwort = key;
	}

}
