package ch.grademasters.junit;

import java.util.Arrays;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import ch.grademasters.controller.GMController;
import ch.grademasters.model.User;

/**
 * @description JUnit Test fuer das Loginsystem
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserEintragen.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

@RunWith(Parameterized.class)
public class JUnitTestLogin {
	private static User u;
	private String username;
	private String passwort;
	private boolean result;

	//Setzt alle jedes mal die Werte aus der Liste in das Objekt user
	public JUnitTestLogin(String username, String passwort, boolean result) {
		this.username = username;
		this.passwort = passwort;
		this.result = result;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		JUnitTestLogin.u = new User(); //Erstellt neuer User
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		JUnitTestLogin.u = null; //Loescht akteueller user nach dem test
	}

	//Daten fuer den Test
	@Parameters
	public static Collection<Object[]> values() {
		return Arrays.asList(new Object[][] { 
				{ "hans", "1234", true },
				{ "ruedi", "1234", true }, 
				{ "usertest1", "   ", false },
				{ "usertest2", "", false }, 
				{ "usertest3", "passwort", false },
				{ "marco", "1234", true } });
	}

	@Test
	public void testInsertUser() {
		u.setUsername(username);
		u.setPasswort(passwort);
		Assert.assertEquals(GMController.getInstance().login(u), result); //Ueberprueft mit der Methode von GMController login
	}

}
