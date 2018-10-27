package com.verizon.tsp.models;

import javax.persistence.CascadeType;	
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "csa")
public class CSA {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long csaId;
	
	@NotEmpty(message="First Name can not be empty")
	private String csaFname;
	
	@NotEmpty(message="Last Name can not be empty")
	private String csaLname;
	
	@NotEmpty(message="Phone Number can not be empty")
	private String csaMobileNo;
	
	@NotEmpty(message="Email Id can not be null")
	@Email(message="Invalid Email Id")
	private String csaEmailId;
	
	/*@OneToOne(mappedBy="telecomcircle",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private TelecomCircle tc;
	*/
	@Enumerated(EnumType.STRING)
	private PrimaryLanguage csaPrimaryLang;
	
	public CSA() {
		
	}

	public long getCsaId() {
		return csaId;
	}

	public void setCsaId(long csaId) {
		this.csaId = csaId;
	}

	public String getCsaFname() {
		return csaFname;
	}

	public void setCsaFname(String csaFname) {
		this.csaFname = csaFname;
	}

	public String getCsaLname() {
		return csaLname;
	}

	public void setCsaLname(String csaLname) {
		this.csaLname = csaLname;
	}

	public String getCsaMobileNo() {
		return csaMobileNo;
	}

	public void setCsaMobileNo(String csaMobileNo) {
		this.csaMobileNo = csaMobileNo;
	}

	public String getCsaEmailId() {
		return csaEmailId;
	}

	public void setCsaEmailId(String csaEmailId) {
		this.csaEmailId = csaEmailId;
	}

	public PrimaryLanguage getCsaPrimaryLang() {
		return csaPrimaryLang;
	}

	public void setCsaPrimaryLang(PrimaryLanguage csaPrimaryLang) {
		this.csaPrimaryLang = csaPrimaryLang;
	}

	public CSA(long csaId, String csaFname,
			 String csaLname, String csaMobileNo, String csaEmailId,PrimaryLanguage csaPrimaryLang) {
		super();
		this.csaId = csaId;
		this.csaFname = csaFname;
		this.csaLname = csaLname;
		this.csaMobileNo = csaMobileNo;
		this.csaEmailId = csaEmailId;
		this.csaPrimaryLang = csaPrimaryLang;
	}
	
	

}
