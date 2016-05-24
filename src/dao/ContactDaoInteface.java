package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Contacts;

public interface ContactDaoInteface {
	public ArrayList<Contacts> getAllContacts(int id);

	public boolean AddContacts(Contacts contacts);

	public boolean DeleteContact(Contacts contacts);

	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException;

	public boolean updateContacts(Contacts cons);
	
	public Contacts readContact(int id)throws SQLException;
}
