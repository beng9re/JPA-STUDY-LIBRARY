import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
		EntityManager em = emf.createEntityManager();

		LibraryInitService libraryService = new LibraryInitService(em);

		emf.close();

		em.close();

		System.out.println("RUN");
	}


}
