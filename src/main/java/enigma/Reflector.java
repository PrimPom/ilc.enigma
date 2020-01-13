package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends SuperRefRot {  //h�ritage inutile => ici sp�cialisation
	
	int[] reflection;
	
	public static Reflector reflectorFactory(String str){
		char[] s = str.trim().replace(" ", "").toCharArray();
		int[] cipher = new int[26];
		for (int i = 0; i< 26; i++){
			cipher[i] = toIndex(s[i]);
		}
		return new Reflector(cipher);
	}
	
	Reflector(int[] r){
                super();     //variable qui n'est pas utilis�e
		reflection = r; 
	}
        
   
    @Override
    public int convertForward(int p) {
        return ((reflection[((p)%26+26)%26])%26+26)%26;
    }
//Surchage inutiles
    //Cr�ation d'une classe de generalisation dont h�rite la classe Reflector

    
    

}
