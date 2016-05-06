package org.wikidreams.security;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * @author Daniel Vieira
 * RSA is one of the most popular asymmetric (public-key) cryptography algorithms. In contrast to the symmetric methods like DES and AES that require a single secret key, asymmetric algorithms are based on a pair of keys: public and private key. The public key which is available to everyone is used to encrypt the plaintext to the ciphertext (i.e. encrypted message). The private key, on the other hand, is used for decrypting the ciphertext to obtain the original plaintext and it is confidential to its respective owner.
 */

/**
 * @author Daniel Vieira
 *
 */
/**
 * @author Daniel Vieira
 *
 */
public class WDSecurity {


	/**
	 * @return
	 * @throws Exception
	 */
	public static KeyPair createKeyPair() throws Exception {
		KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		return keyPair;
	}

	/**
	 * @param publicKey
	 * @param plainText
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(PublicKey publicKey, String plainText) throws Exception { Cipher cipher = Cipher.getInstance("RSA");
	cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
	return new String(Base64.getEncoder().encode(encryptedBytes));
	}


	/**
	 * @param privateKey
	 * @param encryptedText
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(PrivateKey privateKey, String encryptedText) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] ciphertextBytes = Base64.getDecoder().decode(encryptedText.getBytes());
		byte[] decryptedBytes = cipher.doFinal(ciphertextBytes);
		return new String(decryptedBytes);		
	}

}