package com.example.payload.dto;

import com.example.domain.StoreStatus;
import com.example.modal.StoreContact;
import com.example.modal.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreDTO {


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


	public UserDto getStoreAdmin() {
		return storeAdmin;
	}


	public void setStoreAdmin(UserDto storeAdmin) {
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


	private Long id;

    private String brand;

    private String name;


    private UserDto storeAdmin;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String description;

    private String storeType;

    private StoreStatus status;

	@Embedded
    private StoreContact contact;
}
