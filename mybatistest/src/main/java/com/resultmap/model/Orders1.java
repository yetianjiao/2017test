package com.resultmap.model;

import java.util.Date;
import java.util.List;



public class Orders1 {
    private Integer id;

    private Integer userId;

    private String number;

    private Date createtime;

    private String note;
    
    //用户信息
    private User1 user;
    
    //订单明细
    private List<Orderdetail1> orderdetails;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public List<Orderdetail1> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<Orderdetail1> orderdetails) {
		this.orderdetails = orderdetails;
	}

	
    
    
}