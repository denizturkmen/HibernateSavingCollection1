package com.denizturkmen.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.denizturkmen.Model.Adres;

@Entity
@Table(name = "Employee_Table")
@DynamicUpdate
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Employee_id")
	private Integer employeeId;

	@Column(name = "Employee_name", length = 100, nullable = false)
	private String EmployeeName;

	@Column(name = "Email", unique = false)
	private String Email;

	@Column(name = "Date_of_Joining")
	private Date doj;

	@Column(name = "Salary")
	private Double Salary;

	// bir employeenin birden çok adresi olabilir ve biz bunu join ile başka tabloda
	// tututuk
	// Joincolumn name foreign key ile bağlı olan alanın ismini veriyoruz
	@ElementCollection(fetch = FetchType.EAGER)
	@JoinTable(name = "Adress_Table", joinColumns = @JoinColumn(name = "Employee_id"))
	@GenericGenerator(name = "sequence-generator",strategy = "sequence") // adresi adress_id olarak PK yapmaya yarıyor
	@CollectionId(columns = {@Column(name="adress_id")},generator ="sequence",type = @Type(type = "int"))
	private Collection<Adres> adressList = new ArrayList<>();

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public Double getSalary() {
		return Salary;
	}

	public void setSalary(Double salary) {
		Salary = salary;
	}

	public Collection<Adres> getAdressList() {
		return adressList;
	}

	public void setAdressList(Collection<Adres> adressList) {
		this.adressList = adressList;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", EmployeeName=" + EmployeeName + ", Email=" + Email + ", doj="
				+ doj + ", Salary=" + Salary + ", adressList=" + adressList + "]";
	}

}
