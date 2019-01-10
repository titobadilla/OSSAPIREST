package com.tvoseguridadelectronica.oss.domain;

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

}
