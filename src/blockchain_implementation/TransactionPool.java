package blockchain_implementation;

import java.util.ArrayList;

public class TransactionPool {
	
	ArrayList<Transaction> transactionPool = new ArrayList<Transaction>();
	int numberOfTransactionsInPool;
	
	public TransactionPool() {
		
	}
	
	public ArrayList<Transaction> getTransactionPool() {
		return transactionPool;
	}

	public int getNumberOfTransactionsInPool() {
		return numberOfTransactionsInPool;
	}
	
	boolean addTransactioToTransactionPool(Transaction transaciton) {
		
		//later create function that checks if transaction is valid (authorization, public keys...)
		if(1==1) {
			transactionPool.add(transaciton);
			numberOfTransactionsInPool++;
			return true;
		}
		return false;
		
	}
	
	
	
	
	
	
}
