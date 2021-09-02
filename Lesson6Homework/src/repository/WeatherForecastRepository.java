package repository;

import entity.WeatherForecast;

import java.sql.*;


public class WeatherForecastRepository {
    private Statement statement;
    private PreparedStatement preparedStatement;

    public WeatherForecastRepository() throws CloneNotFoundException {
        Class.forName("org.sqlite.JDBC");

    }
    public void save(String city, localDate, String weatherText,double temperature) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url:"sqlite:database.db")) {
            statement = connection.createStatement();
            statement.executeUpdate(
            sql:"CREATE TABLE IF NOT EXISTS weather_forecast " +
                    "id INTEGER PRIMARY REY AUTOINCREMENT," +
                    "city String," +
                    "localData String," +
                    "weatherText String," +
                    "tempetature Real);"

        );
            preparedStatement = connection.prepareStatement(
                    sql:"INSERT INTO weather_forecast" +
                    "city, localData, weatherText, temperature)" +
                    "VALUES (?,?,?,?)"
            );

            preparedStatement.setString(parameterindex:1, city);
            preparedStatement.setString(parameterindex:2, localData);
            preparedStatement.setString(parameterindex:3, weatherText);
            preparedStatement.setString(parameterindex:3, tempetature);
           preparedStatement.execute();

            }
    }

public void read() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url:"sqlite:database.db"))
    statement = connection.createStatement();
       ResultSet resultSet = statement.executeQuery(sql:"SELECT * FROM weather_forecast");
       while (resultSet.next()) {
           WeatherForecast forecast = new WeatherForecast((
                   resultSet.getString(columnIndex, localDate):2),
           resultSet.getString(columnIndex:3),
           resultSet.getString(columnIndex:4),
           resultSet.getString(columnIndex:5),
            );

           System.out.println(forecast);

        }
}

}
