package examenaco;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	@Test
	public void test() {

		char lletra='a';
		assertEquals(true,Main.nova_lletra(lletra));
		lletra='c';
		assertEquals(false,Main.nova_lletra(lletra));
	}

}
