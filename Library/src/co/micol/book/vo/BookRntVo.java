package co.micol.book.vo;

import java.sql.Date;

public class BookRntVo {
	private Date rentalDate;
	private String bookCode;
	private String memberId;
	private String returnDate;
	private String expReturnDate;

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getExpReturnDate() {
		return expReturnDate;
	}

	public void setExpReturnDate(String expReturnDate) {
		this.expReturnDate = expReturnDate;
	}
}
