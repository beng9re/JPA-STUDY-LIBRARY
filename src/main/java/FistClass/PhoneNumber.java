package FistClass;

import lombok.Builder;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumber {
	private String first = "";
	private String middle = "";
	private String last = "";
	private String fullPhoneNumber;

	public PhoneNumber(){
	};

	@Builder
	public PhoneNumber(String first, String middle, String last) {
		this.first = first;
		this.middle = middle;
		this.last = last;
		validate();
	}

	public String getFullPhoneNumber() {
		return new StringBuilder(first)
				.append("-")
				.append(middle)
				.append("-")
				.append(last).toString();
	}

	public void setFullPhoneNumber(String fullPhoneNumber) {
		this.fullPhoneNumber = new StringBuilder(first)
				.append("-")
				.append(middle)
				.append("-")
				.append(last).toString();
	}

	private void validate() throws IllegalArgumentException{
		if(this.first.length() != 3) {
			throw new IllegalArgumentException("핸드폰 시작 번호는 3자리 여야 한다.");
		}

		if(this.middle.length() != 4) {
			throw new IndexOutOfBoundsException("두번째 번호는 4자리 여야 한다.");
		}
		if(this.last.length() != 4) {
			throw new IndexOutOfBoundsException("마지막 번호는 4자리 여야 한다.");
		}
	}
}
