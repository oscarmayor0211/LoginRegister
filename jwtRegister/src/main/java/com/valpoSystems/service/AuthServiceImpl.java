package com.valpoSystems.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.valpoSystems.domain.dto.PhoneDto;
import com.valpoSystems.domain.response.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthServiceImpl implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	* 
	*/
	private UUID id;
	private String name;
	private String email;
	private String password;
	private String token;
	private Boolean active;
	private Set<PhoneDto> phones;
	private LocalDateTime lastLogin;
	private LocalDateTime created;
	private LocalDateTime modified;
    @JsonIgnore
	private static Collection<? extends GrantedAuthority> authorities;

	public static AuthServiceImpl build(UserResponse user) {

		return new AuthServiceImpl(user.getId(), user.getName(), user.getEmail(), user.getPassword(), user.getToken(), user.getActive(), user.getPhones(), user.getLastLogin(),
				user.getCreated(), user.getModified());

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
