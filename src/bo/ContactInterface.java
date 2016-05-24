package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import dto.Contacts;

public interface ContactInterface {
	
	public ArrayList<Contacts> getAllContacts(int id);

	public boolean AddContacts(Contacts contacts, int id) throws SQLException;

	public boolean DeleteContact(Contacts contacts) throws SQLException;

	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException;

	public boolean updateContacts(Contacts cons) throws SQLException;

}
