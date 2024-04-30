package com.bookapp.model;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.bookapp.exceptions.BookNotFoundException;

//Tx mgt in j2ee
//ejb is by default transactional ie u dont need to start the tx ACID
@Stateless

@TransactionManagement(TransactionManagementType.BEAN) // programmer will mange the tx
public class BookDaoImplJpa implements BookDao {

	@PersistenceContext(name = "bookappEjbJpa")
	private EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	@Override
	public List<Book> getAll() {
		// JPA u write something called HQL (hibernate Query language)
		return em.createQuery("select b from Book b", Book.class).getResultList();
	}

	@Override
	public Book addBook(Book book) {
		try {
			userTransaction.begin();
			em.persist(book);
			userTransaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				userTransaction.setRollbackOnly();
			} catch (Exception e1) {
				e1.printStackTrace();
			} 
		}

		return book;
	}

	@Override
	public Book getById(int id) {
		Book book = em.find(Book.class, id);
		if (book == null) {
			throw new BookNotFoundException("book with id " + id + " is not found");
		}
		return book;
	}

	@Override
	public Book updateBook(int id, Book book) {
		Book bookToUpdate = getById(id);
		bookToUpdate.setPrice(book.getPrice());
		em.merge(bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book deleteBook(int id) {
		Book bookToDelete = getById(id);
		em.remove(bookToDelete);
		return bookToDelete;
	}

}
