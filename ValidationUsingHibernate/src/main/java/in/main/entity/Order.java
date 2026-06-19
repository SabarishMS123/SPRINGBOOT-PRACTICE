package in.main.entity;

public class Order {
  private String customername;
  private String email;
  private String medicine_name;
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
  public String getAddress() {
	return address;
  }
  public void setAddress(String address) {
	this.address = address;
  }
  public int getQuantity() {
	return quantity;
  }
  public void setQuantity(int quantity) {
	this.quantity = quantity;
  }
  private int quantity;

}
