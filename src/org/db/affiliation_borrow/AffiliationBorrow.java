package org.db.affiliation_borrow;

/**
 * AffiliationBorrow entity. @author MyEclipse Persistence Tools
 */

public class AffiliationBorrow implements java.io.Serializable {

	// Fields

	private Integer num;
	private String date;
	private String name;
	private String affiliation;
	private String phone;
	private Integer borrowNum;
	private String note;

	// Constructors

	/** default constructor */
	public AffiliationBorrow() {
	}

	/** full constructor */
	public AffiliationBorrow(String date, String name, String affiliation,
			String phone, Integer borrowNum, String note) {
		this.date = date;
		this.name = name;
		this.affiliation = affiliation;
		this.phone = phone;
		this.borrowNum = borrowNum;
		this.note = note;
	}

	// Property accessors

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getBorrowNum() {
		return this.borrowNum;
	}

	public void setBorrowNum(Integer borrowNum) {
		this.borrowNum = borrowNum;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}