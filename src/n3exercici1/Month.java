package n3exercici1;

public class Month {
    private String month;

    public Month(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "Month{" +
                "month='" + month + '\'' +
                '}';
    }
}
