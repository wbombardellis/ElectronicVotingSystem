package architecture;

import static org.junit.Assert.*;

import org.junit.Test;

public class JustificationTest {

	@Test
	public void test() {
		String justificationExpected = "Teste Justificativa";
		Member memberExpected = new VotingMember("Joao");
		
		Justification j = new Justification(justificationExpected, memberExpected);
		
		assertEquals(justificationExpected, j.getJsutification());
		assertEquals(memberExpected, j.getAuthor());
	}

}
