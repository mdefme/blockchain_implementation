package blockchain_implementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Hasher {
	
	//needs serious refactoring
	
	public static String transaction256Hash(Transaction transaction) throws NoSuchAlgorithmException {
		String transactionString = transaction.toString();
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(transactionString.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
		for (int i = 0; i < encodedhash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedhash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
		}
		return hexString.toString();
	}
	
	//refactor this, can be one function, as above
	public static String twoTransactions256Hash(String hash1, String hash2) throws NoSuchAlgorithmException {
		String transactionString = hash1+hash2;
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(transactionString.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
		for (int i = 0; i < encodedhash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedhash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
		}
		return hexString.toString();
	}
	
	public static String hashBlock(String block) throws NoSuchAlgorithmException {

		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = digest.digest(block.getBytes(StandardCharsets.UTF_8));
		
		StringBuilder hexString = new StringBuilder(2 * encodedhash.length);
		for (int i = 0; i < encodedhash.length; i++) {
	        String hex = Integer.toHexString(0xff & encodedhash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
		}
		return hexString.toString();
	}
	
	public static String getMerkleRootHash(ArrayList<Transaction> transactionPool) throws NoSuchAlgorithmException {
		List<String> hashedTransactions = Merkle.hashTransactions(transactionPool);
		List<String> merkleTree = Merkle.createMerkleTree(hashedTransactions);
		return merkleTree.get(0);
		
		
	}
	
}
