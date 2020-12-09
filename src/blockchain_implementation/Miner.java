package blockchain_implementation;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Miner {
	
	
	public Miner() {
		
	}
	
	public static boolean mine(ArrayList<Transaction> transactionPool, String nonce) throws NoSuchAlgorithmException {
		Block lastBlock = Blockchain.getLastBlock();
		
		String previousBlockHash = lastBlock.getBlockHash();
		String merkleRootHash = Hasher.getMerkleRootHash(transactionPool);
		String toHash = previousBlockHash+merkleRootHash+nonce;
		String blockHash = Hasher.hashBlock(toHash);
		System.out.println("BLOCK HASH: "+blockHash);
		if(blockHash.startsWith("1")) {
			Block newBlock = new Block(blockHash, merkleRootHash, previousBlockHash, nonce,1);
			Blockchain.addToBlockchain(newBlock);
			
		}
		return true;
		
		
		
	}
	

}
