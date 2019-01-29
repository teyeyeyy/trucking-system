package com.finalcasestudy;

import java.util.List;

public class Mainn {

	public static void main(String[] args) {

		DAOts dao = new DAOts();
		
//		Truck truck = new Truck();
	Transaction trans = new Transaction();		
//		
//		List<Transaction> transactions = dao.sortTransaction("content");
//		for(Transaction t: transactions) {
//			System.out.println(t.getContent());
//	}
		

		
		
		// TARE WEIGHT - GROSS WEIGHT = LOAD WEIGHT
		
		trans.setTareWeight(8000);
		trans.setGrossWeight(220);
		System.out.println(dao.TareTransaction(trans));
		
		
		
	
	
	
	
	}
	
}

