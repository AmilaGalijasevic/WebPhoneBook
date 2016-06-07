package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Contacts;

public interface ContactDaoInteface {
	
	public ArrayList<Contacts> getAllContacts(int id) throws SQLException;

	public boolean AddContacts(Contacts contacts,int id) throws SQLException;

	public boolean DeleteContact(Contacts contacts)throws SQLException;

	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException;

	public boolean updateContacts(Contacts cons) throws SQLException;

	public Contacts readContact(int id) throws SQLException;
	
}
