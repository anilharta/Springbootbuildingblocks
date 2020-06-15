package com.java.RestServices.Pojos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Orders")
public class Orders extends RepresentationModel<Orders> {
	@Id
	@GeneratedValue
	private Long orderid;
	private String OrderDescription;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users user;

	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public String getOrderDescription() {
		return OrderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		OrderDescription = orderDescription;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Orders [orderid=" + orderid + ", OrderDescription=" + OrderDescription + ", user=" + user + "]";
	}

}
