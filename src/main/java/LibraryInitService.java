import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import FistClass.PhoneNumber;
import domain.*;


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
		final List<BookInfo> bookInfos = createBooks();
		final List<User> users = createUser();

		TransactionComponent transactionComponent = new TransactionComponent(this.em);

		transactionComponent.run(()-> {
				locations.forEach((data) -> em.persist(data));
				bookInfos.forEach((data) -> em.persist(data));
			}
		);

		transactionComponent.run(() -> {
			final Location clocation = locations.stream().filter((data) -> data.getName().equals("C열"))
					.findFirst()
					.orElseGet(() -> locations.get(0));

			final BookInfo oneBook = bookInfos.stream()
					.filter((data) -> data.getName().equals("나루토"))
					.findFirst()
					.orElseGet(() -> bookInfos.get(0));


			User user = users.get(0);

			Books book = new Books();
			book.setBook(oneBook);
			book.setLocation(clocation);
			book.setUser(user);

			em.persist(book);


		});
	}

	private List<User> createUser() {
		User user1 = new User();
		user1.setAge(20);
		user1.setName("KIM");
		user1.setPhoneNum(new PhoneNumber("010","3245","5233"));

		em.persist(user1);

		User user2 = new User();
		user2.setAge(20);
		user2.setName("KIM");
		user2.setPhoneNum(new PhoneNumber("010","3245","5233"));

		em.persist(user2);

		return List.of(user1,user2);

	}



}
