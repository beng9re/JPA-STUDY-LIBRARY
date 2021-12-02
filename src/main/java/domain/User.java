package domain;


import FistClass.PhoneNumber;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int age;

	@Embedded
	private PhoneNumber phoneNum;

	@OneToMany(mappedBy = "user")
	private List<Books> borrow;

}
