package com.HMSAPP.Hospital.Management.System.doclogin.enity;

import java.sql.Date;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@CrossOrigin(origins = "http://localhost:4200") // Allowing CORS for Angular development server
@Entity
@Table(name = "medicines")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String brand;

	@Column(name = "generic_name")
	private String genericName;

	@Column(name = "dosage_form")
	private String dosageForm;

	@Column(nullable = false)
	private String strength;

	@Column(nullable = false)
	private int quantity;

	@Column(name = "expiration_date")
	@Temporal(TemporalType.DATE)
	private Date expirationDate;

	@Column(nullable = false)
	private double price;

	@Column(name = "prescription_required")
	private boolean prescriptionRequired;

	public Medicine(Long id, String name, String brand, String genericName, String dosageForm, String strength,
			int quantity, Date expirationDate, double price, boolean prescriptionRequired) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.genericName = genericName;
		this.dosageForm = dosageForm;
		this.strength = strength;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
		this.price = price;
		this.prescriptionRequired = prescriptionRequired;
	}

	public Medicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getDosageForm() {
		return dosageForm;
	}

	public void setDosageForm(String dosageForm) {
		this.dosageForm = dosageForm;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPrescriptionRequired() {
		return prescriptionRequired;
	}

	public void setPrescriptionRequired(boolean prescriptionRequired) {
		this.prescriptionRequired = prescriptionRequired;
	}
}