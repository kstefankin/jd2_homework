
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;




public class ExpDao {

    private static ExpDao instance;

    private ExpDao(){}

    public static ExpDao getInstance(){
        if(instance == null){
            instance = new ExpDao();
        }
        return instance;
    }



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





    protected Receiver getReceiver(int num) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Receiver WHERE num=?");
        st.setString(1, String.valueOf(num));
        ResultSet rs = st.executeQuery();
        Receiver receiver = null;
        if (rs.next()) {
            receiver = new Receiver();
            receiver.setNum(rs.getInt(1));
            receiver.setName(rs.getString(2));




            System.out.println(receiver.getNum()+" "+receiver.getName());
        }

        con.close();
        st.close();
        return receiver;


    }

    protected ArrayList<Receiver> getReceivers() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Receiver");
        ArrayList<Receiver> receiversList = new ArrayList<>();
        while(rs.next()) {
            Receiver receiver = new Receiver();
            receiver.setNum(rs.getInt(1));
            receiver.setName(rs.getString(2));

            System.out.println(receiver.getNum()+" "+receiver.getName());
            receiversList.add(receiver);

        }
        st.close();
        con.close();
        return receiversList;




    }

    protected void addReceiver(Receiver receiver) throws SQLException{
        Connection con = getConnection();
        String sql = "INSERT INTO Receiver VALUES (?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, receiver.getNum());
        preparedStatement.setString(2, receiver.getName());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();


    }

    protected Expense getExpense (int num) throws SQLException {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM Expense WHERE paymnum=?");
        st.setString(1, String.valueOf(num));
        ResultSet rs = st.executeQuery();
        Expense expense = null;
        if (rs.next()) {
            expense = new Expense();
            expense.setPaymnum(rs.getInt(1));
            expense.setPaymdate(rs.getString(2));
            expense.setPaymreceiver(rs.getInt(3));
            expense.setPaymsumma(rs.getDouble(4));



            System.out.println(expense.getPaymnum()+" "+expense.getPaymdate()+" "+expense.getPaymreceiver()+" "+expense.getPaymsumma());
        }

        con.close();
        st.close();
        return expense;
    }

    protected ArrayList<Expense> getExpenses() throws SQLException {
        Connection con = getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Expense");
        ArrayList<Expense> expensesList = new ArrayList<>();
        while(rs.next()) {
            Expense expense= new Expense();
            expense.setPaymnum(rs.getInt(1));
            expense.setPaymdate(rs.getString(2));
            expense.setPaymreceiver(rs.getInt(3));
            expense.setPaymsumma(rs.getDouble(4));

            System.out.println(expense.getPaymnum()+" "+expense.getPaymdate()+" "+expense.getPaymreceiver()+" "+expense.getPaymsumma());
            expensesList.add(expense);

        }
        st.close();
        con.close();
        return expensesList;

    }

   protected void addExpense(Expense expense) throws SQLException {
        Connection con = getConnection();
        String sql = "INSERT INTO Expense VALUES (?, ?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, expense.getPaymnum());
        preparedStatement.setString(2, expense.getPaymdate());
        preparedStatement.setInt(3, expense.getPaymreceiver());
        preparedStatement.setDouble(4, expense.getPaymsumma());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        con.close();
    }

}
