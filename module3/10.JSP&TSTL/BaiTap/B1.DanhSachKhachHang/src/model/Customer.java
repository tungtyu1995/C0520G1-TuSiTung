package model;

public class Customer {
    private String name;
    private String date_of_birth;
    private String address;
    private String imageURL;

    public Customer() {
    }

    public Customer(String name, String date_of_birth, String address, String imageURL) {
        this.name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
