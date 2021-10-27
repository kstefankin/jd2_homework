import java.sql.SQLException;


public class Main  {

    public static void main(String[] args) throws SQLException {

        ExpDao dao= ExpDao.getInstance();

       // Expense ex1=new Expense();
        //ex1.setPaymnum(3);
       // ex1.setPaymdate("2020-05-09");
       // ex1.setPaymreceiver(1);
       // ex1.setPaymsumma(7300);

       // Receiver re1 = new Receiver();
        //re1.setNum(2);
        //re1.setName("KORONA");



        dao.regDriver();

        //dao.addReceiver(re1);
        //dao.addExpense(ex1);
        dao.getExpense(2);

        dao.getReceiver(1);

        dao.getExpenses();
        dao.getReceivers();















    }






}
