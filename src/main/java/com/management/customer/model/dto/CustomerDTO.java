package com.management.customer.model.dto;

public class CustomerDTO {
    private int customerCode;
    private String customerName;
    private String customerGender;
    private int customerAge;
    private int categoryNo;
    private int roomCode;

    public CustomerDTO() {
    }

    public int getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerCode=" + customerCode +
                ", customerName='" + customerName + '\'' +
                ", customerGender='" + customerGender + '\'' +
                ", customerAge=" + customerAge +
                ", categoryNo=" + categoryNo +
                ", roomCode=" + roomCode +
                '}';
    }
}
