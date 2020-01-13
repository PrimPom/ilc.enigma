package enigma;

public class Rotor {

    private int position;
    final int CONSTANTE=26;
    private int[] cipher = new int[CONSTANTE];
    private int[] bcipher = new int[CONSTANTE];
    private int notch1 = -1;
    private int notch2 = -1;
    

    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
    
	public static Rotor rotorFactory(String str, String notches){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
			return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
		} else {
			return new Rotor(cipher, toIndex(s[0]));
		}
		
	}
	
	Rotor(int[] c, int notch1, int notch2) {
		this.notch1 = notch1;
		this.notch2 = notch2;
		cipher = c;
		createBCipher();
	}
	
	Rotor(int[] c, int notch1) {
		this.notch1 = notch1;
		cipher = c;
		createBCipher();
	}

    public int convertForward(int p) {  // roue quand la lettre va vers le centre
        return ((cipher[((p+position)%CONSTANTE+CONSTANTE)%CONSTANTE]-position)%CONSTANTE+CONSTANTE)%CONSTANTE;
    }

    public int convertBackward(int e) { // roue quand la lettre va vers l'extérieur
        return ((bcipher[((e+position)%CONSTANTE+CONSTANTE)%CONSTANTE]-position)%CONSTANTE+CONSTANTE)%CONSTANTE;
    }
    
    protected void advance() { //doit être uniquement accessible à l'ordinateur (pas public) + constante = 26
        position = (position+1) % CONSTANTE;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {     // alourdi le serveur pour rien (pas de static)
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<CONSTANTE; i++)
			bcipher[cipher[i]] = i;
	}



}
