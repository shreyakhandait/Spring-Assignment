package com.cg.customerjparest.util;

import com.cg.customerjparest.exception.InvalidArgumentException;
import com.cg.customerjparest.exception.InvalidCustomerIdException;
import com.cg.customerjparest.exception.InvalidCustomerNameException;


public class ValidationUtil {

	public static void checkArgumentNotNull(Object arg) {
		if (arg == null) {
			throw new InvalidArgumentException("arg can't be null");
		}
	}

	public static void checkName(String name) {
		if (name == null || name.isEmpty()) {
			throw new InvalidCustomerNameException("name is not valid");
		}

	}

	public static void checkId(Long id) {
		if (id == null) {
			throw new InvalidCustomerIdException("id is not valid");
		}
		
	}


}
