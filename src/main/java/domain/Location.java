package domain;

import javax.persistence.*;

import lombok.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Location {

	@Builder
	public Location(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "LOCATION_ID")
	private Long id;

	@Column(name = "LOCATION_NAME")
	private String name;



}
