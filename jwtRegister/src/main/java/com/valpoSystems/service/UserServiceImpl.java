package com.valpoSystems.service;

import com.valpoSystems.domain.models.PhoneModel;
import com.valpoSystems.domain.models.UserModel;
import com.valpoSystems.domain.request.UserRequest;
import com.valpoSystems.domain.response.UserResponse;
import com.valpoSystems.exception.InvalidPasswordException;
import com.valpoSystems.exception.UserException;
import com.valpoSystems.repository.UserRepository;
import com.valpoSystems.util.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final String paswordRegexp;
	private final JwtTokenUtil jwtTokenUtil;

	public UserServiceImpl(final UserRepository userRepository, JwtTokenUtil jwtTokenUtil,
			@Value("${pasword.regexp}") String paswordRegexp) {
		this.userRepository = userRepository;
		this.jwtTokenUtil = jwtTokenUtil;
		this.paswordRegexp = paswordRegexp;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public UserModel save(final UserRequest userRequest) throws UserException, InvalidPasswordException {
		validEmail(userRequest.getEmail());
		validPassword(userRequest.getPassword());

		UserModel userEntity = new UserModel();
		userEntity.setName(userRequest.getName());
		userEntity.setEmail(userRequest.getEmail());
		userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		userEntity.setCreated(LocalDateTime.now());
		userEntity.setToken(jwtTokenUtil.generateToken(userRequest.getEmail()));
		userEntity.setLastLogin(userEntity.getCreated());
		userEntity.setActive(true);
		userEntity
				.setPhones(
						userRequest
								.getPhones().stream().map(p -> new PhoneModel(userEntity, p.getNumber(),
										p.getCityCode(), p.getCountryCode(), LocalDateTime.now()))
								.collect(Collectors.toSet()));
		return userRepository.save(userEntity);
	}

	@Override
	public UserModel UpdateUser(UserModel userModel) throws UserException, InvalidPasswordException {
		// TODO Auto-generated method stub
		validPassword(userModel.getPassword());
        LocalDateTime modified = LocalDateTime.now();

		UserModel userEntity = userRepository.getById(userModel.getId());

		userEntity.setName(userModel.getName());
		userEntity.setPassword(userModel.getPassword());
		userEntity.setEmail(userModel.getEmail());
		userEntity.setPhones(userModel.getPhones().stream().map(p -> new PhoneModel(userEntity, p.getNumber(),
										p.getCityCode(), p.getCountryCode(), LocalDateTime.now()))
								.collect(Collectors.toSet()));
		userEntity.setModified(modified);
		System.out.println(userEntity);

		return userRepository.save(userEntity);
	}
	
	/* Metodos Privados */
	private void validEmail(final String email) throws UserException {
		Optional<UserResponse> user = userRepository.findUserEntityByEmail(email);
		if (user.isPresent()) {
			throw new UserException("El correo ya registrado");
		}
	}

	private void validPassword(final String password) throws InvalidPasswordException {
		Pattern pattern = Pattern.compile(paswordRegexp);
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			throw new InvalidPasswordException(
					"The password must meet the following criteria: " + "Contain at least one number (0-9)."
							+ "Contain at least one lowercase letter." + "Contain at least one capital letter."
							+ "Do not contain blank spaces." + "Have a length of between 8 and 20 characters.");
		}
	}

	

}
