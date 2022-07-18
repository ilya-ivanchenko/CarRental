package by.ivanchenko.carrental.bean.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import  java.util.Calendar;
import java.time.LocalDate;
import java.util.Objects;

//TemporalType.TIMESTAMP

public class Order {

    private int id;
    private int customerId;
    private int carId;
    private int managerId;
    private Date startDate; //GregorianCalendar    SimpleDateFormat   LocalDate
    private Date endDate;
    private int totalPrice;
    private String description;
    private boolean payment;
    private boolean isReturned;
    private boolean needRepair;
    private boolean isApproved;
    private int repairPrice;


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
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public boolean isNeedRepair() {
        return needRepair;
    }

    public void setNeedRepair(boolean needRepair) {
        this.needRepair = needRepair;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getRepairPrice() {
        return repairPrice;
    }

    public void setRepairPrice(int repairPrice) {
        this.repairPrice = repairPrice;
    }

    public Order(int id, int customerId, int carId, int managerId, Date startDate, Date endDate,
                 int totalPrice, String description, boolean payment, boolean isReturned, boolean needRepair,
                 boolean isApproved, int repairPrice) {
        setId(id);
        setCustomerId(customerId);
        setCarId(carId);
        setManagerId(managerId);
        setStartDate(startDate);
        setEndDate(endDate);
        setTotalPrice(totalPrice);
        setDescription(description);
        setPayment(payment);
        setReturned(isReturned);
        setNeedRepair(needRepair);
        setApproved(isApproved);
        setRepairPrice(repairPrice);
    }

    public Order (int customerId, int carId, Date startDate, Date endDate, int totalPrice) {
        setCustomerId(customerId);
        setCarId(carId);
        setStartDate(startDate);
        setEndDate(endDate);
        setTotalPrice(totalPrice);
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
                ", isReturned=" + isReturned +
                ", needRepair=" + needRepair +
                ", isApproved=" + isApproved +
                ", repairPrice=" + repairPrice +
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
                && totalPrice == order.totalPrice && payment == order.payment && isReturned == order.isReturned
                && needRepair == order.needRepair && isApproved == order.isApproved && repairPrice == order.repairPrice
                && Objects.equals(startDate, order.startDate) && Objects.equals(endDate, order.endDate)
                && Objects.equals(description, order.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, carId, managerId, startDate, endDate, totalPrice, description, payment, isReturned,
                needRepair, isApproved, repairPrice);
    }
}
