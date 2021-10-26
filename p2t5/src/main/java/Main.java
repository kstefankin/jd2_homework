import java.sql.SQLException;

public class Main {


    public static void main (String[] args) throws ClassNotFoundException, SQLException {

        RashodDAO dao =new RashodDAO();

        int pnumber = Integer.parseInt(args[0]);
        String date = args[1];
        String reciv = args[2];
        double sum = Double.parseDouble(args[3]);

        Rashod rashod = new Rashod();
        rashod.setPnumber(pnumber);
        rashod.setDate(date);
        rashod.setReciv(reciv);
        rashod.setSum(sum);

        dao.regDriver();
        dao.saveNewRashod(rashod);
        dao.printAllRashod();






    }

}