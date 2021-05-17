package Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	protected static String hashGenerator(String userName, String senderId, String content, String secureKey) {
		// TODO Auto-generated method stub
		StringBuffer finalString=new StringBuffer();
		finalString.append(userName.trim()).append(senderId.trim()).append(content.trim()).append(secureKey.trim());
		//		logger.info("Parameters for SHA-512 : "+finalString);
		String hashGen=finalString.toString();
		StringBuffer sb = null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(hashGen.getBytes());
			byte byteData[] = md.digest();
			//convert the byte to hex format method 1
			sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
//		String new_mobile="9839268180";
		String content = "Your One Time Password (OTP) for ECI e-KYC is 1234";
		String username= "ECISMS-CDAC";
//		String password= "CDAC$123456";
		String senderid= "ECISMS";
//		String smsservicetype= "otpmsg";
		String key= "be2ab46d-983e-43ca-bcf8-bdc82b7ce6c8";
		System.out.println(hashGenerator(username, senderid, content, key));
		
	}
	
}
