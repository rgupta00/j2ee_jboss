package combookapp.dao;

import java.util.*;

import combookapp.exceptions.BookNotFoundException;

public class BookDaoImplMap implements BookDao {

	private static Map<Integer, Book> map=new HashMap<>();
	private static int counter=2;
	static {
		map.put(1, new Book(1, "ABX123", "head first", 400));
		map.put(2, new Book(2, "ABX193", "rich dad poor dad", 300));
	}
	@Override
	public List<Book> getAll() {
		return new ArrayList<>(map.values());
	}

	@Override
	public Book addBook(Book book) {
		book.setId(++counter);
		map.put(counter, book);
		return book;
	}

	@Override
	public Book getById(int id) {
		Book book=map.get(id);
		if(book==null)
			throw new BookNotFoundException("book with id "+id +" is not found");
		return book;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate= getById(id);
		bookToUpdate.setPrice(book.getPrice());
		map.put(id, bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book deleteBook(int id) {
		Book bookToDelete= getById(id);
		map.remove(id);
		return bookToDelete;
	}

}
