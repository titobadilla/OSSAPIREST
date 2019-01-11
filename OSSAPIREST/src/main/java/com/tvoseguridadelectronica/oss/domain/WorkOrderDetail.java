package com.tvoseguridadelectronica.oss.domain;

<<<<<<< HEAD
import java.io.Serializable;

public class WorkOrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
=======
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Inventory_category")
public class WorkOrderDetail  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "check_in")
    private String checkIn;

    @Column(name = "check_out")
    private String checkOut;

    @Column(name = "description")
    private String description;

    @Column(name = "invoice_id")
    private int invoiceId;

    @Column(name = "manager_name")
    private String managerName;

    public WorkOrderDetail(Date date, String checkIn, String checkOut, String description, int invoiceId, String managerName) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.description = description;
        this.invoiceId = invoiceId;
        this.managerName = managerName;
    }

    public WorkOrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
>>>>>>> 21f8744ae3f6a7144c4d9b9e76c12757b91bb1fe
}
