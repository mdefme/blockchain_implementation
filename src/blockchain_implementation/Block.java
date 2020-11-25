package blockchain_implementation;

import java.util.Arrays;

public class Block {
	
	private Transaction transaction;
	private int previousHash;
	private int currentHash;
	
	public Block(Transaction transaction, int previousHash) {
		this.transaction = transaction;
		this.previousHash = previousHash;
		this.currentHash = calculateCurrentHash(transaction,previousHash);
	}
	
	private int calculateCurrentHash(Transaction transaction, int previousHash) {
		return currentHash = Arrays.hashCode(new Integer[] {transaction.hashCode(),previousHash});
	}

	@Override
	public String toString() {
		return "Block [transaction=" + transaction + ", previousHash=" + previousHash + ", currentHash=" + currentHash
				+ "]";
	}

	public int getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(int previousHash) {
		this.previousHash = previousHash;
	}

	public int getCurrentHash() {
		return currentHash;
	}

	public void setCurrentHash(int currentHash) {
		this.currentHash = currentHash;
	}
	
	
	
 
	
}
