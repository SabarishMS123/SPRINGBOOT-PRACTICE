package in.main.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class OrderRequest {
 
	 @NotBlank(message="Customer name cannot be empty")
	 private String customername;
	 
	 @Email(message="proper format is needed..")
	 @NotBlank(message="email is mandatory ,enter it man..")
	 private String email;
	 
	 @NotBlank(message="medicine name cannot be empty")
	 private String medicine_name;
	 
	 @Min(value = 1 , message=" Quantity should be greater than 0")
	 private int Quantity;
	 
	 @NotBlank(message="delivery address cannot be empty")
	 private String address;

	 public String getCustomername() {
		 return customername;
	 }

	 public void setCustomername(String customername) {
		 this.customername = customername;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getMedicine_name() {
		 return medicine_name;
	 }

	 public void setMedicine_name(String medicine_name) {
		 this.medicine_name = medicine_name;
	 }

	 public int getQuantity() {
		 return Quantity;
	 }

	 public void setQuantity(int quantity) {
		 Quantity = quantity;
	 }

	 public String getAddress() {
		 return address;
	 }

	 public void setAddress(String address) {
		 this.address = address;
	 }
	 
	 
}
