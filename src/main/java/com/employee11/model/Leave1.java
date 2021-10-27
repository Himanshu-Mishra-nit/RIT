
package com.employee11.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leave1")
public class Leave1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "leave_type")
	private String leaveType;
	
	@Column(name = "reason_for_leave")
	private String reasonForLeave;
	
	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	public Leave1() {
		
	}
	
	public Leave1(String employeeName, String leaveType, String reasonForLeave, String fromDate, String toDate) {
		super();
		this.employeeName = employeeName;
		this.leaveType = leaveType;
		this.reasonForLeave = reasonForLeave;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReasonForLeave() {
		return reasonForLeave;
	}

	public void setReasonForLeave(String reasonForLeave) {
		this.reasonForLeave = reasonForLeave;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	}
