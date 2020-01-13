package enigma;

import static org.junit.Assert.*;

import org.junit.Test;

public class RotorTest {

	@Test
	public void forwad() {
            Rotor r = Rotor.rotorFactory(
				"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "E");
            r.setPosition(0);
            char actual = r.toLetter(r.convertForward(2));
            assertEquals('C', actual);
	}
        
        @Test
	public void backward() {
            Rotor r = Rotor.rotorFactory(
				"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z", "E");
            r.setPosition(2);
            char actual = r.toLetter(r.convertForward(0));
            assertEquals('A', actual);
	}
        
        
}
