package blockchain_implementation;

import java.util.Arrays;

public class Block {
	
	private String blockHash;
	private String merkleRootHash;
	private String previousBlockHash;
	private String nonce;
	private int difficulty; //if difficulty==1, block is considered mined if hash starts with 1
	
	
	
	public Block(String blockHash, String merkleRootHash, String previousBlockHash, String nonce, int difficulty) {
		this.blockHash = blockHash;
		this.merkleRootHash = merkleRootHash;
		this.previousBlockHash = previousBlockHash;
		this.nonce = nonce;
		this.difficulty = difficulty;
	}



	public String getBlockHash() {
		return blockHash;
	}



	public String getMerkleRootHash() {
		return merkleRootHash;
	}



	public String getPreviousBlockHash() {
		return previousBlockHash;
	}



	public String getNonce() {
		return nonce;
	}



	public int getDifficulty() {
		return difficulty;
	}



	
}
