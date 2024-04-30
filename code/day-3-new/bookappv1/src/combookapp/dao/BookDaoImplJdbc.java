package combookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
public class BookDaoImplJdbc implements BookDao {

	@Resource(lookup="java:/MySqlDS")
	private DataSource dataSource;
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct is called");
	}
	
	@Override
	public List<Book> getAll() {
		List<Book> books=new ArrayList<>();
		try {
			Connection connection=dataSource.getConnection();
			Statement stmt=connection.createStatement();
			ResultSet rs=stmt.executeQuery("select * from books");
			while(rs.next()) {
				books.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book addBook(Book book) {
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement stmt=connection.prepareStatement("insert into books(isbn, title, price) values(?,?,?)");
			stmt.setString(1, book.getIsbn());
			stmt.setString(2, book.getTitle());
			stmt.setDouble(3, book.getPrice());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book getById(int id) {
		Book bookToReturn=null;
		try {
			Connection connection=dataSource.getConnection();
			PreparedStatement stmt=connection.prepareStatement("select * from books where id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				bookToReturn=new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookToReturn;
	}

	@Override
	public Book updateBook(int id, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book deleteBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@PreDestroy
	public void PreDestroy() {
		System.out.println("@PreDestroy is called");
	}
	
}
