import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import domain.Book;
import domain.Location;


public class LibraryInitService {

	EntityManager em;

	LibraryInitService(EntityManager em) {
		this.em = em;
		init();
	}

	private List<Location> createLocations() {
		return List.of(
			Location.builder().name("A열").build(),
			Location.builder().name("C열").build(),
			Location.builder().name("B열").build()
		);
	}

	private List<Book> createBooks() {
		return List.of(
			Book.builder().name("원피스").price(new BigDecimal(2000)).build(),
			Book.builder().name("나루토").price(new BigDecimal(1500)).build(),
			Book.builder().name("블리치").price(new BigDecimal(200)).build()
		);
	}

	private void init() {
		final List<Location> locations = createLocations();
		final List<Book> books = createBooks();

		TransactionComponent transactionComponent = new TransactionComponent(this.em);

		transactionComponent.run(()-> {
				locations.forEach((data) -> em.persist(data));
				books.forEach((data) -> em.persist(data));
			}
		);

	}



}
