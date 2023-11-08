package com.mycompany.fastpassui;

public class FastPassCustomer {

    private String fastPassId;
    private String customerFullName;
    private String customerPhone;
    private Float currentBalance;

    public FastPassCustomer() {
    }

    public FastPassCustomer(String fastPassId, String customerFullName, String customerPhone, Float currentBalance) {
        this.fastPassId = fastPassId;
        this.customerFullName = customerFullName;
        this.customerPhone = customerPhone;
        this.currentBalance = currentBalance;
    }

    public String getFastPassId() {
        return fastPassId;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setFastPassId(String fastPassId) {
        this.fastPassId = fastPassId;
    }

}
