package blockchain_implementation;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Merkle{
	
	
	private List<String> hashedTransactions;
	private static List<String> merkleRoot;
	public Merkle(List<Transaction> transactions) throws NoSuchAlgorithmException {
		this.hashedTransactions = hashTransactions(transactions);
		Merkle.merkleRoot = createMerkleTree(hashedTransactions);
	}
	
	public static String getMerkleRoot() {
		System.out.println(merkleRoot.size());
		return merkleRoot.get(0);
	}

	public static List<String> hashTransactions(List<Transaction> transactions) throws NoSuchAlgorithmException{
		
		List<String> hashedTransactions = new ArrayList<>();
		for(Transaction transaction:transactions) {
			System.out.println(transaction);
			String hashedTransaction = Hasher.transaction256Hash(transaction);
			System.out.println(hashedTransaction);
			hashedTransactions.add(hashedTransaction);	
		}
		//if odd number of transactions, copy the last hash
		if(hashedTransactions.size()%2==1) hashedTransactions.add(hashedTransactions.get(hashedTransactions.size()-1));
		
		return hashedTransactions;
	}
	
	public static List<String> createMerkleTree(List<String>hashedTransactions) throws NoSuchAlgorithmException{
		if(hashedTransactions.size()==1) return hashedTransactions;
		
		List<String> updateList = new ArrayList<>();
		for(int i=0;i<hashedTransactions.size()-1;i=i+1) {
			
			String twoNodesHash = Hasher.twoTransactions256Hash(hashedTransactions.get(i), hashedTransactions.get(i+1));
			System.out.println(twoNodesHash);
			updateList.add(twoNodesHash);
		}
		return createMerkleTree(updateList);
	}
	

	


}
