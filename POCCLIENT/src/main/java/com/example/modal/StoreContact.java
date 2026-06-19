package com.example.modal;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Proxy;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreContact {
    private String address;
    private String phone;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Email(message="invalid email format!")
    private String email;
	
	


}
