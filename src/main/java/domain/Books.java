package domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Books{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="BOOKS_ID")
	private Long id;

	@OneToOne
	@JoinColumn(name = "BOOK_ID")
	private BookInfo book;

	@OneToOne
	@JoinColumn(name = "LOCATION_ID")
	private Location location;

	@Enumerated(EnumType.STRING)
	@Column(name = "BOOK_STATUS")
	private BookStatus bookStatus;

	@ManyToOne
	private User user;


}
