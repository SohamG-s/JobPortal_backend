package com.jobportal.dto;

import com.jobportal.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

 @Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


	private Long id;
	@NotBlank(message= "{user.name.absent}")
	private String name;
	@Email(message = "{ user.email.absent}")
	@NotBlank(message= "{user.email.invalid}")
	private String email;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",message = "{user.password.absent}")
	@NotBlank(message= "{user.password.invalid} ")
	private String password;
	private AccountType accountType;
	private Long profileId;

	
	public User toEntity() {
		return new User(this.id, this.name, this.email, this.password, this.accountType, this.profileId);
		
	}
}
