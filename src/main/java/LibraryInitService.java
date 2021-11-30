import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import domain.BookInfo;
import domain.BookStatus;

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

	private List<BookInfo> createBooks() {
		return List.of(
			BookInfo.builder().name("원피스").price(new BigDecimal(2000)).build(),
			BookInfo.builder().name("나루토").price(new BigDecimal(1500)).build(),
			BookInfo.builder().name("블리치").price(new BigDecimal(200)).build()
		);
	}

	private void init() {
		final List<Location> locations = createLocations();
		final List<BookInfo> books = createBooks();

		TransactionComponent transactionComponent = new TransactionComponent(this.em);

		transactionComponent.run(()-> {
				locations.forEach((data) -> em.persist(data));
				books.forEach((data) -> em.persist(data));
			}
		);

		transactionComponent.run(() -> {
			final Location clocation = locations.stream().filter((data) -> data.getName().equals("C열"))
					.findFirst()
					.orElseGet(() -> locations.get(0));

			final BookInfo oneBook = books.stream()
					.filter((data) -> data.getName().equals("나루토"))
					.findFirst()
					.orElseGet(() -> books.get(0));



		});


	}



}
