import java.util.function.Consumer;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TransactionComponent {

	EntityManager em;
	TransactionComponent(EntityManager em) {
		this.em = em;
	}

	public void run(TransactionFunction function) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		try {
			function.run();
			transaction.commit();
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}



}
