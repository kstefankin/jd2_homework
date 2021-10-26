
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RashodDAO {

    protected void regDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error load driver " +cnfe);
        }
    }


    protected Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TLE","root","root");
    }




    public void saveNewRashod(Rashod rashod) throws SQLException {
        Connection con = getConnection();
        String sql = "INSERT INTO myrashod4 VALUES (?, ?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, rashod.getPnumber());
        preparedStatement.setString(2, rashod.getDate());
        preparedStatement.setString(3, rashod.getReciv());
        preparedStatement.setDouble(4, rashod.getSum());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();
    }



    public void printAllRashod() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM myrashod4");

        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
        }
        st.close();
        con.close();

    }





}


