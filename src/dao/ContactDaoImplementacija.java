package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.CipherInputStream;

import dto.Contacts;

public class ContactDaoImplementacija implements ContactDaoInteface {

	Connection connection = ConnManager.getInstance().getConnection();

	ArrayList<Contacts> list = new ArrayList<>();

	@Override
	public ArrayList<Contacts> getAllContacts(int userId) throws SQLException {

		Contacts contact = null;
		String query = "SELECT * FROM phonebook.contact_list where userId = ?;";

		ResultSet rs = null;
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			rs = statement.executeQuery();
			while (rs.next()) {

				contact = new Contacts();
				contact.setId(rs.getInt("id"));
				contact.setUserId(rs.getInt("userid"));
				contact.setName(rs.getString("name"));
				contact.setLastname(rs.getString("lastname"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				contact.setCity(rs.getString("city"));

				list.add(contact);

			}
		}
		rs.close();
		return list;

	}

	@Override
	public boolean AddContacts(Contacts contacts, int id) throws SQLException {

		String query = "INSERT INTO phonebook.contact_list ( userID, name, lastname, email, phone, city) VALUES(?,?,?,?,?,?)";
		try (PreparedStatement statement = connection.prepareStatement(query);) {
			statement.setInt(1, id);
			statement.setString(2, contacts.getName());
			statement.setString(3, contacts.getLastname());
			statement.setString(4, contacts.getEmail());
			statement.setString(5, contacts.getPhone());
			statement.setString(6, contacts.getCity());

			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public boolean DeleteContact(Contacts contacts) throws SQLException {

		String query = "delete from phonebook.contact_list where id=?;";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, contacts.getId());

			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException {
		Contacts contacts = null;

		String query = "SELECT * from phonebook.contact_list where name= ? and userID = ?;";
		PreparedStatement statement = connection.prepareStatement(query);

		statement.setString(1, name);
		statement.setInt(2, id);

		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			contacts = new Contacts();

			contacts.setName(rs.getString("name"));
			contacts.setLastname(rs.getString("lastname"));
			contacts.setEmail(rs.getString("email"));
			contacts.setPhone(rs.getString("phone"));
			contacts.setCity(rs.getString("city"));
			contacts.setId(1);
			contacts.setUserId(2);
			list.add(contacts);
		}

		return list;
	}

	@Override
	public boolean updateContacts(Contacts cons) throws SQLException {

		String query = "UPDATE phonebook.contact_list SET name = ?, lastname = ?, email = ?, phone = ?, city = ? WHERE userId = ?";

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setString(1, cons.getName());
			statement.setString(2, cons.getLastname());
			statement.setString(3, cons.getEmail());
			statement.setString(4, cons.getPhone());
			statement.setString(5, cons.getCity());

			statement.setInt(6, cons.getId());

			statement.executeUpdate();
		}
		return true;

	}

	@Override
	public Contacts readContact(int id) throws SQLException {

		Contacts contact = null;

		String query = "SELECT * FROM phonebook.contact_list WHERE userID = ?";
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query);) {

			statement.setInt(1, id);

			rs = statement.executeQuery();

			if (rs.next()) {

				contact = new Contacts();

				contact.setId(rs.getInt("contactID"));
				contact.setUserId(rs.getInt("userId"));
				contact.setName(rs.getString("name"));
				contact.setLastname(rs.getString("lastname"));
				contact.setEmail(rs.getString("email"));
				contact.setPhone(rs.getString("phone"));
				contact.setCity(rs.getString("city"));

			}
		}
		rs.close();

		return contact;
	}

}
