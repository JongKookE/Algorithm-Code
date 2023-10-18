package etc;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHATest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String password = "asdfbzxcvzv";
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(password.getBytes());

	    System.out.println(bytesToHex(md.digest()).length());

	}
	
	static private String bytesToHex(byte[] bytes) {
	    StringBuilder builder = new StringBuilder();
	    for (byte b : bytes) {
	        builder.append(String.format("%02x", b));
	    }
	    return builder.toString();
	}

}
