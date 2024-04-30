package ru.netology.buytour.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static Connection getConn() throws SQLException {
        var dbUrl = System.getProperty("db.url");
        var username = System.getProperty("username");
        var password = System.getProperty("password");
        return DriverManager.getConnection(dbUrl, username, password);
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        var status = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        return QUERY_RUNNER.query(getConn(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditRequestStatus() {
        var status = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        return QUERY_RUNNER.query(getConn(), status, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditId() {
        var id = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        return QUERY_RUNNER.query(getConn(), id, new ScalarHandler<>());
    }
}
