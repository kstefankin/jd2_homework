
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class Main {


    public static void main (String[] arg) throws SQLException {

        String pnumber = arg[0].toString();
        String date = arg[1].toString();
        String reciv = arg[2].toString();
        String sum = arg[3].toString();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error load driver " +cnfe);
        }

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TLE","root","root");


        StringBuilder fortab = new StringBuilder("INSERT INTO myrashod4 VALUES (");
        fortab.append(pnumber);
        fortab.append(",");
        fortab.append("'");
        fortab.append(date);
        fortab.append("'");
        fortab.append(",");
        fortab.append(reciv);
        fortab.append(",");
        fortab.append(sum);
        fortab.append(")");

        String sql = fortab.toString();

        Statement st = con.createStatement();

        st.executeUpdate(sql);
        st.close();



        Statement st2 = con.createStatement();
        ResultSet rs = st2.executeQuery("SELECT * FROM myrashod4");

        while(rs.next()) {
            System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
        }
        st2.close();
        con.close();





    }

}
