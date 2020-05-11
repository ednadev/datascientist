package broker.three.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.three.vo.CustomerRec;
import broker.three.vo.SharesRec;
import broker.three.vo.StockRec;

//Database의 동명이인
public class Protocol {
	
	public Protocol(String serverIp) {
		
	}
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException {
		
	}
	public void deleteCustomer(String ssn) throws RecordNotFoundException {
		
	}
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException {
		
	}
	public Vector<SharesRec> getPortfolio(String ssn) throws RecordNotFoundException {
		return null;
	}
	public CustomerRec getCustomer(String ssn) throws RecordNotFoundException {
		return null;
	}
	public ArrayList<CustomerRec> getAllCustomers() throws RecordNotFoundException {
		return null;
	}
	public ArrayList<StockRec> getAllStocks() {
		return null;
	}
	public void buyShares(String ssn, String symbol, int quantity) throws RecordNotFoundException {
		
	}
	public void sellShares(String ssn, String symbol, int quantity) throws InvalidTransactionException, RecordNotFoundException {
		
	}
}
