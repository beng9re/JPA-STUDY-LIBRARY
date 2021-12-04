package FistClass;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import domain.Books;

public class LibraryService {

	private EntityManager em;

	public LibraryService(EntityManager em) {
		this.em = em;
	}

	public List<Books> findBooksName (String bookName) {
		return new ArrayList<>();
	}

}
