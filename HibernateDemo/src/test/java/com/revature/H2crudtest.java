package com.revature;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.revature.beans.Commenter;

public class H2crudtest extends H2Test {
	
	  @Test
	    public void testGetObjectById_success() {
	        Commenter c = em.find(Commenter.class, 1);
	        assertNotNull(c);
	    }

	  /*  @Test
	    public void testGetAll_success() {
	        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();
	        assertEquals(1, books.size());
	    }

	    @Test
	    public void testPersist_success() {
	        em.getTransaction().begin();
	        em.persist(new Book(10, "Unit Test Hibernate/JPA with in memory H2 Database"));
	        em.getTransaction().commit();

	        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();

	        assertNotNull(books);
	        assertEquals(2, books.size());
	    }

	    @Test
	    public void testDelete_success(){
	        Book book = em.find(Book.class, 1);

	        em.getTransaction().begin();
	        em.remove(book);
	        em.getTransaction().commit();

	        List<Book> books = em.createNamedQuery("Book.getAll", Book.class).getResultList();

	        assertEquals(0, books.size());
	    }*/

}
