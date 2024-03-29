package com.tc.poc.networkdb.model;

import javax.persistence.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EntityScan
@Entity

@Table(name = "CUSTOMER") 
public class Customer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID", unique=true, updatable=true, nullable=false)
	private Long Id;

	@Column(name="name", unique=false, updatable=true, nullable=false)
	private String name;
	
	@Column(name="createtime", unique=false, updatable=true, nullable=false)
	private String createtime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format(new Date()).toString();
	
    
	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
		this.createtime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format(new Date()).toString();
	}

	public Customer(String name,String createtime) {
		this.name = name;
		this.createtime = createtime;
	}
	
	public Long getId() {
		return Id;
	}

	public void setId(Long Id) {
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcreatetime() {
		return createtime;
	}

	public void setcreatetime(String createtime) {
		if(createtime.isEmpty()) {
			this.createtime = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss.SSS").format(new Date()).toString();
		}
	}

	
	@Override
	public String toString() {
		return "Customer [Id=" + Id + ", name=" + name + ", createtime=" + createtime + "]";
	}

	
	
	
}
