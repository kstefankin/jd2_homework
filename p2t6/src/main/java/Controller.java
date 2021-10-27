import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class Controller {

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


    public void firstQuery() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT poluch, sum(sum) AS summa  FROM poluch, myrashod4 WHERE reciv=reciv_number group by reciv");

        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2));
        }
        st.close();
        con.close();

    }

    public void secondQuery() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select sum(sum) from myrashod4 where paym_date = (select paym_date from myrashod4 where sum = (select max(sum) from myrashod4))");

        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
        st.close();
        con.close();

    }


    public void thirdQuery() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select max(sum) from myrashod4 where paym_date=(select paym_date from (select paym_date, sum(sum) from myrashod4 group by paym_date order by 2 desc limit 1) as sd)");

        while(rs.next()) {
            System.out.println(rs.getString(1));
        }
        st.close();
        con.close();

    }






}
