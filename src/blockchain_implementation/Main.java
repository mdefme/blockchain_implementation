package blockchain_implementation;

import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {
		
		Transaction transaction1 = new Transaction("Marko", "Ivan", "240");
		System.out.println(transaction1);
		ArrayList<Block> blockChain = new ArrayList<Block>();
		
		Block genesis = new Block(transaction1, 0);
		blockChain.add(genesis);
		System.out.println();
		
		Transaction transaction2 = new Transaction("Maja", "Marina", "1240");
		int previousHash = genesis.getCurrentHash();
		Block second = new Block(transaction2,previousHash);
		blockChain.add(second);
		
		Transaction transaction3 = new Transaction("Ivo", "Zoki", "12");
		//int previousHash2 = second.getCurrentHash();
		int previousHash2 = 3;
		Block third = new Block(transaction3,previousHash2);
		blockChain.add(third);
		
		System.out.println(blockChain);
		System.out.println(validate(blockChain));
		
	}
	
	static boolean validate(ArrayList<Block> blockChain) {
		int n = blockChain.size();
		Block current;
		Block next;
		for(int i= 0 ;i<n;i++) {
			if(i==n-1) {
				break;
			}
			current = blockChain.get(i);
			next = blockChain.get(i+1);
			if(current.getCurrentHash()!=next.getPreviousHash()) {
				return false;
				
			}
		}
		return true;
	}

}
