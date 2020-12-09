package blockchain_implementation;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
	
	private static List<Block> blockchain = new ArrayList<>();
	
	public static void addToBlockchain(Block block) {
		blockchain.add(block);
	}
	
	public static Block getLastBlock() {
		return blockchain.get(blockchain.size()-1);
	}
	
	public static int getBlockchainSize() {
		return blockchain.size();
	}
	
}
