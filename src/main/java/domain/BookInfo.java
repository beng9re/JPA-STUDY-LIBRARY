package domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class BookInfo {

	@Builder
	public BookInfo(Long id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "BOOK_NAME")
	private String name;
	private BigDecimal price;


}
