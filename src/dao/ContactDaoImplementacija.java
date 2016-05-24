package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Contacts;


public class ContactDaoImplementacija implements ContactDaoInteface {

	@Override
	public ArrayList<Contacts> getAllContacts(int id) {
		Contacts contact = null;
		ArrayList<Contacts> list = new ArrayList<>();
		String query = "SELECT * FROM phonebook.contact_list;";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {

					contact = new Contacts();
					contact.setId(rs.getInt("id"));
					contact.setUserId(rs.getInt("userid"));
					contact.setName(rs.getString("name"));
					contact.setLastname(rs.getString("lastaname"));
					contact.setEmail(rs.getString("email"));
					contact.setPhone(rs.getString("phone"));
					contact.setCity(rs.getString("city"));

					list.add(contact);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public boolean AddContacts(Contacts contacts) {

		String query = "INSERT INTO phonebook.contact_list(id, userid, name,lastaname, email, phone, city) VALUES(?,?,?,?,?,?,?)";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, contacts.getId());
			statement.setInt(2, contacts.getUserId());
			statement.setString(3, contacts.getName());
			statement.setString(4, contacts.getLastname());
			statement.setString(5, contacts.getEmail());
			statement.setString(6, contacts.getPhone());
			statement.setString(7, contacts.getCity());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean DeleteContact(Contacts contacts) {

		String query = "delete from phonebook.contact_list where name = ? and lastaname=?;";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, contacts.getName());
			statement.setString(2, contacts.getLastname());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<Contacts> SearchContacts(String name, int id) throws SQLException {
		Contacts contacts = null;
		ArrayList<Contacts> cons = new ArrayList<>();
		String query = "SELECT * from phonebook.contact_list where name = ? and id = ?;";
		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setString(1, name);

			statement.executeQuery();

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					contacts = new Contacts();

					contacts.setName(rs.getString("name"));
					contacts.setLastname(rs.getString("lastaname"));
					contacts.setEmail(rs.getString("email"));
					contacts.setPhone(rs.getString("phone"));
					contacts.setCity(rs.getString("city"));
					contacts.setId(1);
					contacts.setUserId(2);
					cons.add(contacts);
				}
				System.out.println(contacts.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cons;
	}

	@Override
	public boolean updateContacts(Contacts cons) {

		String query = "UPDATE phonebook.contact_list SET name = ?, lastname = ?, email = ?, phone = ?, city = ? WHERE contactId = ?";

		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			// fill in the parameters
			statement.setString(1, cons.getName());
			statement.setString(2, cons.getLastname());
			statement.setString(3, cons.getEmail());
			statement.setString(4, cons.getPhone());
			statement.setString(6, cons.getCity());

			statement.setInt(6, cons.getId());

			// execute the query
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;

	}

	public Contacts readContact(int id) throws SQLException {

		Contacts contact = null;

		String query = "SELECT * FROM phonebook.contact_list WHERE id = ?";
		ResultSet rs = null;

		try (Connection connection = ConnManager.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {

			statement.setInt(1, id);
			rs = statement.executeQuery();

			if (rs.next()) {

				contact = new Contacts();

				contact.setId(rs.getInt("id"));
				contact.setUserId(rs.getInt("Userid"));
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
