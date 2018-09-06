package com.trainings.model.dao;

import com.trainings.constant.ConnectionProperty;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;

    public static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    Properties property = new Properties();
                    try {
                        setProperties(ds, property);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dataSource = ds;
                }
            }
        }
        return dataSource;
    }

    private static void setProperties(BasicDataSource ds, Properties property) throws IOException {
        property.load(new FileInputStream(ConnectionProperty.PROPERTY_PATH));
        ds.setDriverClassName(property.getProperty(ConnectionProperty.DRIVER));
        ds.setUrl(property.getProperty(ConnectionProperty.HOST));
        ds.setUsername(property.getProperty(ConnectionProperty.LOGIN));
        ds.setPassword(property.getProperty(ConnectionProperty.PASSWORD));
        ds.setMinIdle(Integer.parseInt(property.getProperty(ConnectionProperty.MIN_IDLE)));
        ds.setMaxIdle(Integer.parseInt(property.getProperty(ConnectionProperty.MAX_IDLE)));
        ds.setMaxOpenPreparedStatements(Integer.parseInt(property
                .getProperty(ConnectionProperty.MAX_STATEMENT)));
    }
}
