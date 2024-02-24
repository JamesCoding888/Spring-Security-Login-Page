package com.example.demo.repository;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	public Map<String, Map<String, String>> users;
	{
		// A01, 1234, Authorization: admin, normal; role: ROLE_manager
		Map<String, String> info1 = new LinkedHashMap<>();
		info1.put("password", "$2a$10$Ba2pfcpBkozKMXRRL8BmsuIBI4lF2EA7G5B3tS972sMxWwlEP6fT6");
		info1.put("authority", "admin, normal, ROLE_manager"); // role define must be upper-case 'ROLE_'
		
		// A02, 5678, Authorization: normal; role: ROLE_employee
		Map<String, String> info2 = new LinkedHashMap<>();
		info2.put("password", "$2a$10$RoqK9Xy9TLo6W7o5ZheSl.S2Nzhb6rYeHMAMXs4DW29.qNecxaqgG");
		info2.put("authority", "normal, ROLE_employee");
		
		users = new LinkedHashMap();
		users.put("A01", info1);
		users.put("A02", info2);
		System.out.println(users);
	}
}
