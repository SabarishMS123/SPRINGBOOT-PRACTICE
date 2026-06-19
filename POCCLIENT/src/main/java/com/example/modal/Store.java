package com.example.modal;

import com.example.domain.StoreStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Store {

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getStoreAdmin() {
		return storeAdmin;
	}
	public void setStoreAdmin(User storeAdmin) {
		this.storeAdmin = storeAdmin;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStoreType() {
		return storeType;
	}
	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}
	public StoreStatus getStatus() {
		return status;
	}
	public void setStatus(StoreStatus status) {
		this.status = status;
	}
	public StoreContact getContact() {
		return contact;
	}
	public void setContact(StoreContact contact) {
		this.contact = contact;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (nullable=false)
    private String brand;
    @Column(nullable =false)
    private String name;

    @OneToOne
    private User storeAdmin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

    @Embedded
    private StoreContact contact= new StoreContact();

    @PrePersist
    protected void onCreate (){

        createdAt=LocalDateTime.now();
        status =StoreStatus.PENDING;

    }
    @PreUpdate
    protected void onUpdate()
    {
        updatedAt=LocalDateTime.now();
    }
	



}
