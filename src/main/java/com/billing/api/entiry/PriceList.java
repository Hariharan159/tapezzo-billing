package com.billing.api.entiry;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "PRICELIST")
public class PriceList {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	@Column(name = "PRICELIST_ID")
	private Long priceListId;
	
    @ManyToOne
    @JoinColumn(name = "PRICEBOOK_ID", referencedColumnName = "PRICEBOOK_ID")
	private PriceBook priceBook;
	
    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private Item item;
	
	@Column(name = "PRICE")
	private Double price;

	public Long getPriceListId() {
		return priceListId;
	}

	public void setPriceListId(Long priceListId) {
		this.priceListId = priceListId;
	}

	public PriceBook getPriceBook() {
		return priceBook;
	}

	public void setPriceBook(PriceBook priceBook) {
		this.priceBook = priceBook;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
