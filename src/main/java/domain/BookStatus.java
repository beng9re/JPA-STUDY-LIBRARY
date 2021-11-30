package domain;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum BookStatus {

	BORROW(1,"대출중","대출중인 상태"),
	UN_BORROW(2,"대출가능","안 대출 상태");
	private int code;
	private String name;
	private String desc;

	public static BookStatus getCodeAsStatus (int code) {
		return Arrays.stream(BookStatus.values()).filter((data) -> data.code == code)
				 .findFirst()
				 .orElseThrow(()-> new IllegalArgumentException("해당 코드가 없습니다."));
	}

}
