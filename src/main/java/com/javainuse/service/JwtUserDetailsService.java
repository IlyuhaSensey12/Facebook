package com.javainuse.service;

import java.util.ArrayList;

import com.javainuse.dto.UserDto;
import com.javainuse.model.UserEntity;
import com.javainuse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class JwtUserDetailsService implements UserDetailsService, IUserService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByLogin(login);
		if (user != null) {
			return new User(user.getLogin(), user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + login);
		}
	}

	@Override
	public void save(UserDto userDto) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDto.getId());
		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastName());
		userEntity.setMiddleName(userDto.getMiddleName());
		userEntity.setAge(userDto.getAge());
		userEntity.setLogin(userDto.getLogin());
		userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));
		userEntity.setPhone(userDto.getPhone());
		userRepository.save(userEntity);
	}

}