package org.unitedpro.mumsched.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.unitedpro.mumsched.domain.Faculty;
import org.unitedpro.mumsched.domain.Student;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IFacultyService facultyService;
	@Autowired
	private IStudentService studentService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.isEmpty()) {
			throw new UsernameNotFoundException("Username is Null");
		}
		String password = "";
		Iterable<Faculty> facultyList = facultyService.getAllFaculty();
		Iterable<Student> studentList = studentService.getAllStudent();

		Iterator<Faculty> iteratorFaculty = facultyList.iterator();
		Iterator<Student> iteratorStudent = studentList.iterator();

		
		UserDetailsImpl userDetail = new UserDetailsImpl();
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		

		//Admin role
		if (username.equals("admin")) {
			userDetail.setUsername("admin");
			userDetail.setPassword("admin");
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			userDetail.setAuthorities(grantedAuthorities);
			
		} else { //Faculty role
			while (iteratorFaculty.hasNext()) {
				Faculty faculty = (Faculty) iteratorFaculty.next();
				if (faculty.getEmail().equals(username)) {
					password = faculty.getPassword();
					grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_FACULTY"));
					break;
				}
			}
			if (password.equals("")) {  // Student role
				while (iteratorStudent.hasNext()) {
					Student student = (Student) iteratorStudent.next();
					if (student.getEmail().equals(username)) {
						password = student.getPassword();
						grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
						break;
					}
				}
			}
			if (password.equals("")) //There is no username in record
				throw new UsernameNotFoundException("There is no record found");

			userDetail.setUsername(username);
			userDetail.setPassword(password);
			userDetail.setAuthorities(grantedAuthorities);
			
		}
		return userDetail;
	}
}