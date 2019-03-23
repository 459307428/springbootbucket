package com.liuawei.spirng.web.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class ValBean {
	
	@Min(value=15,message="最小值是15")
	@Max(value=130,message="最大值是130")
	private int age;
	
	@Email(message="必须符合邮件地址")
	private String email;
	
	@Past(message="日期是过去的日期")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	@NotBlank
	private String remark;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
