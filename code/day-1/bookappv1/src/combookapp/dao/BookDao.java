package combookapp.dao;

import java.util.List;

public interface BookDao {
	public List<Book> getAll();
	public Book addBook(Book book);
	public Book getById(int id);
	public Book updateBook(int id, Book book);
	public Book deleteBook(int id);
}
