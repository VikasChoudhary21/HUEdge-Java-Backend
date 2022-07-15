package com.service.order.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")
public class Order {

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "user_id")
	private Integer userId;

    @Column (name = "ordered_date")
    @NonNull
    private Date orderedDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private Double totalAmount;
    
    @Column(name = "product_id")
    private Integer productId;
    
    //neToMany(mappedBy="orders", cascade= {CascadeType.ALL})
    //Li<OrderedItems> list;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}


}
