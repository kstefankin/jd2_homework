import java.io.Serializable;


public class Expense implements Serializable{

    private int paymnum;
    private String paymdate;
    private int paymreceiver;
    private double paymsumma;

    public int getPaymnum() {
        return paymnum;
    }

    public void setPaymnum(int paymnum) {
        this.paymnum = paymnum;
    }


    public String getPaymdate() {
        return paymdate;
    }

    public void setPaymdate(String paymdate) {
        this.paymdate = paymdate;
    }

    public int getPaymreceiver() {
        return paymreceiver;
    }

    public void setPaymreceiver(int paymreceiver) {
        this.paymreceiver = paymreceiver;
    }

    public double getPaymsumma() {
        return paymsumma;
    }

    public void setPaymsumma(double paymsumma) {
        this.paymsumma = paymsumma;
    }
}
