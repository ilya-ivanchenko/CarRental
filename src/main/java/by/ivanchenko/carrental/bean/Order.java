package by.ivanchenko.carrental.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {

    private static final long serialVersionUID = -1569614752562823290L;
    private int id;
    private int customerId;
    private int carId;
    private int managerId;
    private Date startDate;
    private Date endDate;
    private int totalPrice;
    private String description;
    private boolean payment;
    private boolean returned;
    private boolean given;
    private boolean needRepair;
    private boolean approved;
    private int repairPrice;
    private String passport;
    private String carName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public boolean isGiven() {
        return given;
    }

    public void setGiven(boolean given) {
        this.given = given;
    }

    public boolean isNeedRepair() {
        return needRepair;
    }

    public void setNeedRepair(boolean needRepair) {
        this.needRepair = needRepair;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(int repairPrice) {
        this.repairPrice = repairPrice;
    }
    public String getPassport() {
        return passport;
    }
    public void setPassport(String passport) {
        this.passport = passport;
    }
    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Order(int id, int customerId, int carId, int managerId, Date startDate, Date endDate, int totalPrice,
                 String description, boolean payment, boolean returned,  boolean needRepair,
                 boolean approved, int repairPrice, String passport, boolean given) {
        setId(id);
        setCustomerId(customerId);
        setCarId(carId);
        setManagerId(managerId);
        setStartDate(startDate);
        setEndDate(endDate);
        setTotalPrice(totalPrice);
        setDescription(description);
        setPayment(payment);
        setReturned(returned);
        setNeedRepair(needRepair);
        setApproved(approved);
        setRepairPrice(repairPrice);
        setPassport(passport);
        setGiven(given);
    }

    public Order (int customerId, int carId, Date startDate, Date endDate, int totalPrice) {
        setCustomerId(customerId);
        setCarId(carId);
        setStartDate(startDate);
        setEndDate(endDate);
        setTotalPrice(totalPrice);
    }

    public Order(int id, int customerId, int carId, int managerId, Date startDate, Date endDate, int totalPrice,
                 String description, boolean payment, boolean returned,  boolean needRepair,
                 boolean approved, int repairPrice, String passport, boolean given, String carName) {
        setId(id);
        setCustomerId(customerId);
        setCarId(carId);
        setManagerId(managerId);
        setStartDate(startDate);
        setEndDate(endDate);
        setTotalPrice(totalPrice);
        setDescription(description);
        setPayment(payment);
        setReturned(returned);
        setNeedRepair(needRepair);
        setApproved(approved);
        setRepairPrice(repairPrice);
        setPassport(passport);
        setGiven(given);
        setCarName(carName);
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", managerId=" + managerId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                ", description='" + description + '\'' +
                ", payment=" + payment +
                ", returned=" + returned +
                ", given=" + given +
                ", needRepair=" + needRepair +
                ", approved=" + approved +
                ", repairPrice=" + repairPrice +
                ", passport=" + passport +
                ", carName=" + carName +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && customerId == order.customerId && carId == order.carId && managerId == order.managerId
                && totalPrice == order.totalPrice && payment == order.payment && returned == order.returned
                && given == order.given && needRepair == order.needRepair && approved == order.approved
                && repairPrice == order.repairPrice && Objects.equals(startDate, order.startDate)
                && Objects.equals(endDate, order.endDate) && Objects.equals(description, order.description)
                && Objects.equals(passport, order.passport) && Objects.equals(carName, order.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, carId, managerId, startDate, endDate, totalPrice, description, payment, returned,
                given, needRepair, approved, repairPrice, passport, carName);
    }
}
