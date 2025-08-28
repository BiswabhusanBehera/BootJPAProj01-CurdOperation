package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "JPA_CUSTOMER_TAB")
@Data
public class Customer {

	@Column(name = "CID")
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "CID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.AUTO)
	private Integer cno;
	@Column(name = "CNAME",length = 20)
	private String cname;
	@Column(name = "CADD",length = 20)
	private String caddrs;
	@Column(name = "BILLAMOUNT")
	private Float billAmt;

}
