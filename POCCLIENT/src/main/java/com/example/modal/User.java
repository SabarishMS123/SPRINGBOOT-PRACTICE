package com.example.modal;
import java.time.LocalDateTime;

import com.example.domain.UserRole;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
	 @Id
     @GeneratedValue(strategy =GenerationType.IDENTITY)
     private Long id;
	 
	 @Column(nullable =false)
	 private String fullName;
	 @Column(nullable =false , unique = true)
	 @Email(message ="EMAIL SHOULD BE VALID")
	 private String email;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne
     private Store store;
	 @Column(nullable=false)
	 private String phone;
	 @Column(nullable=false)
	 private UserRole role;
	 @Column(nullable=false)
	 private String password;
	 private LocalDateTime createdAt;
	 private LocalDateTime updatedAt;
	 private LocalDateTime lastLogin;
	 public Long getId() {
		 return id;
	 }
	 public void setId(Long id) {
		 this.id = id;
	 }
	 public String getFullName() {
		 return fullName;
	 }
	 public void setFullName(String fullName) {
		 this.fullName = fullName;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 public String getPhone() {
		 return phone;
	 }
	 public void setPhone(String phone) {
		 this.phone = phone;
	 }
	 public UserRole getRole() {
		 return role;
	 }
	 public void setRole(UserRole role) {
		 this.role = role;
	 }
	 public String getPassword() {
		 return password;
	 }
	 public void setPassword(String password) {
		 this.password = password;
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
	 public LocalDateTime getLastLogin() {
		 return lastLogin;
	 }
	 public void setLastLogin(LocalDateTime lastLogin) {
		 this.lastLogin = lastLogin;
	 }    
}
