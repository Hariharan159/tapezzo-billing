package com.billing.api.entiry;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "PRICEBOOK")
public class PriceBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name = "PRICEBOOK_ID")
	private Long priceBookId;
	
	@Column(name = "PRICEBOOK_NAME")
	private String priceBookName;
	
	@OneToMany(mappedBy = "priceBook")
	private List<PriceList> priceList;

	public List<PriceList> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PriceList> priceList) {
		this.priceList = priceList;
	}

	public Long getPriceBookId() {
		return priceBookId;
	}

	public void setPriceBookId(Long priceBookId) {
		this.priceBookId = priceBookId;
	}

	public String getPriceBookName() {
		return priceBookName;
	}

	public void setPriceBookName(String priceBookName) {
		this.priceBookName = priceBookName;
	}

}
