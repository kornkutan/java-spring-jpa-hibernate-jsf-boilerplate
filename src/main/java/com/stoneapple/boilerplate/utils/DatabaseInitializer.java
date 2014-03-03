package com.stoneapple.boilerplate.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

	private DataSource dataSource;

	public void initialize(){
        try {
            Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("CREATE TABLE PERSON (ID INTEGER IDENTITY, NAME VARCHAR(50), EMAIL VARCHAR(100))");
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
