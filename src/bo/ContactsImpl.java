package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ContactDaoImplementacija;
import dao.ContactDaoInteface;
import dto.Contacts;

public class ContactsImpl implements ContactInterface {
	ContactDaoInteface contact = new ContactDaoImplementacija();

	@Override
	public ArrayList<Contacts> getAllContacts(int id) {
		ArrayList<Contacts> contacts = null;

		if (Helper.isValidId(id)) {

			contacts = contact.getAllContacts(id);
		}

		return contacts;
	}

	@Override
	public boolean AddContacts(Contacts contacts, int id) throws SQLException {

		if (Helper.isContactNotNull(contacts) && Helper.isValidId(id)) {

			if (contact.AddContacts(contacts)) {
				return true;
			}

		}

		return false;
	}

	@Override
	public boolean DeleteContact(Contacts contacts) throws SQLException {
		
		if (Helper.isContactNotNull(contacts)) {

			if (contact.DeleteContact(contacts)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException {
		ArrayList<Contacts> contacts = null;

		try {

			contacts = contact.SearchContacts(name, id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return contacts;
	}

	@Override
	public boolean updateContacts(Contacts cons) throws SQLException {
	
		if (Helper.isContactNotNull(cons)) {

			if (contact.updateContacts(cons)) {
				return true;
			}
		}
		return false;
	}

	public Contacts readContact(int id) {
		Contacts contacts = null;

		if (Helper.isValidId(id)) {
			try {
				contacts = contact.readContact(id);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return contacts;

		
	}

}
