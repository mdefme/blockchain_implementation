package blockchain_implementation;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;



public class Main {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		
		
		Block genesisBlock = new Block("00000","00000","5251580113c5506bc491a6d5b789bh71a86eb7b2ad8e1df7761fcfc676284fb5","nesto",0);
		Blockchain blockchain= new Blockchain();
		blockchain.addToBlockchain(genesisBlock);
		
		Transaction transaction1 = new Transaction("Marko", "Ivan", "240");
		Transaction transaction2 = new Transaction("Maja", "Marina", "1240");
		Transaction transaction3 = new Transaction("Ivo", "Zoki", "12");
		Transaction transaction4 = new Transaction("Leo", "Lola", "1312");
		
		ArrayList<Transaction> transactionPool= new ArrayList<Transaction>();
		transactionPool.add(transaction1);
		transactionPool.add(transaction2);
		transactionPool.add(transaction3);
		transactionPool.add(transaction4);
		
		Miner.mine(transactionPool,"ffdsad"); //hash with this nonce doesn't start with 1
		System.out.println(Blockchain.getBlockchainSize());
		Miner.mine(transactionPool,"ffdsads"); //hash with this nonce does start with 1 => block mined

		
	}
	


}
