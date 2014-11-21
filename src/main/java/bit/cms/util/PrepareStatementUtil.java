package bit.cms.util;

import bit.cms.core.dao.bean.BeanCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artem.Telizhenko
 *         Date: 17.11.2014
 *         Time: 21:48
 */
public class PrepareStatementUtil {
    public static ResultSet getSqlResultSet(String sql, Connection connection, Object[] parameters) throws SQLException {
        PreparedStatement preparedStatement = createSql(sql, connection, parameters);
        return preparedStatement.executeQuery();
    }

    public static <T> T getBean (String sql, Connection connection, Object[] parameters, BeanCreator<T> bean) throws SQLException {
        connection.setAutoCommit(false);
        try {
            ResultSet resultSet = getSqlResultSet(sql, connection, parameters);
            if (resultSet.first()) {
                return bean.getBean(resultSet);
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
            return null;
        } finally {
            connection.commit();
        }
    }

    public static  <T> List<T> getResults(String sql, Connection connection, Object[] parameters, BeanCreator<T> bean) throws SQLException {
        List<T> result = new ArrayList<>();
        connection.setAutoCommit(false);
        try {
            ResultSet resultSet = getSqlResultSet(sql, connection, parameters);
            while (resultSet.next()) {
                result.add(bean.getBean(resultSet));
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.commit();
        }
        return Collections.emptyList();
    }

    public static PreparedStatement createSql(String sql, Connection connection, Object[] parameters) throws SQLException {
        if (sql == null || sql.isEmpty())
            throw new SQLException("SQL is null or empty");
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (parameters != null)
            for (int i = 0; i < parameters.length; i++) {
                int statementIndex = i + 1;
                preparedStatement.setObject(statementIndex, parameters[i]);
            }
        return preparedStatement;
    }

    public static boolean executeSql(String sql, Connection connection, Object[] parameters) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = createSql(sql, connection, parameters);
            boolean execute = preparedStatement.execute();
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.commit();
        }
        return false;
    }

    public static void executeBatch(String sql, Connection connection, Object[] parameters) throws SQLException {
        connection.setAutoCommit(false);
        try {
            PreparedStatement preparedStatement = createSql(sql, connection, parameters);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.commit();
        }
    }
}
