package com.service.order.Entity;

/*import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Ordered_Item")*/
public class OrderedItems {
	
	//@Id
	//@GeneratedValue
    private Integer id;
	
	//@Column(name = "product_id")
	private Integer productId;

	//@Column(name = "price")
    private Double price;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="user_id")
	private Order order;

}