package com.enigma.belajar_jpa.entity;

public class Customer {
    private Integer id;
    private String customerName;
    private String mobilePhoneNo;
    private Boolean isMember;

    public Customer(Integer id, String customerName, String mobilePhoneNo, Boolean isMember) {
        this.id = id;
        this.customerName = customerName;
        this.mobilePhoneNo = mobilePhoneNo;
        this.isMember = isMember;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }

    public Boolean getIsMember() {
        return isMember;
    }

    public void setIsMember(Boolean member) {
        isMember = member;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", phoneNumber='" + mobilePhoneNo + '\'' +
                ", isMember=" + isMember +
                '}';
    }
}
