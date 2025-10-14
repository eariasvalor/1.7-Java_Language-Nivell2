package n2exercici1;

public class Worker {
    private String name;
    private String surname;
    private double priceHour;

    public Worker() {}

    public Worker(String name, String surname, double priceHour){
        this.name = name;
        this.surname = surname;
        this.priceHour = priceHour;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getPriceHour() {
        return priceHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPriceHour(double priceHour) {
        this.priceHour = priceHour;
    }

    public double calculateSalary(double hours){
        double result = (hours * this.priceHour);

        return result;
    }

    @Deprecated
    public void oldMethod(){
        System.out.println("This is a deprecated method.");
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", priceHour=" + priceHour +
                '}';
    }
}
