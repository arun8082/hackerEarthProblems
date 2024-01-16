package com.spring.batch.dao.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerBean {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private String contactNo;
	private String country;
//	@DateTimeFormat(pattern = "dd-MM-yyyy")
//	@JsonFormat(pattern = "dd-MM-yyyy")
	private String dob;

}
