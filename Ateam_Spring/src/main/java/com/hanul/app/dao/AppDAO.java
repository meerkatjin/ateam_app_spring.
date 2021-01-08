package com.hanul.app.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AppDAO {

	DataSource dataSource;

	public AppDAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/ateam");
		} catch (NamingException e) {
			e.getMessage();
		}

	}
}
