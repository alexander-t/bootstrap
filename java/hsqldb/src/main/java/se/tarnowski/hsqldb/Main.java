package se.tarnowski.hsqldb;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:mem:db", "SA", "");
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE TABLE example_table(id BIGINT IDENTITY, name VARCHAR(255))");
        stmt.execute("INSERT INTO example_table (id, name) VALUES(NULL, 'first')");
        stmt.execute("INSERT INTO example_table (id, name) VALUES(NULL, 'second')");

        ResultSet rs = stmt.executeQuery("SELECT id, name FROM example_table");
        while (rs.next()) {
            System.err.println(rs.getLong("id") + ", " + rs.getString("name"));
        }

        // Overkill
        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(stmt);
        DbUtils.closeQuietly(connection);
    }
}
