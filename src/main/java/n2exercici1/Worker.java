package n2exercici1;


@SerializationAnnotation
public class Worker {
    private String name;
    private String surname;
    private double priceHour;

    public Worker() {
    }

    public Worker(String name, String surname, double priceHour) {
        validate(name, surname, priceHour);
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
        validate(name);
        this.name = name;
    }

    public void setSurname(String surname) {
        validate(surname);
        this.surname = surname;
    }

    public void setPriceHour(double priceHour) {
        validate(priceHour);
        this.priceHour = priceHour;
    }

    public double calculateSalary(double hours) {
        double result = (hours * this.priceHour);

        return result;
    }

    public <T> void validate(T... args) {
        for (Object arg : args) {
            if (arg == null) {
                throw new IllegalArgumentException("Invalid data: null value.");
            }

            if (arg instanceof String s) {
                if (s.isBlank()) {
                    throw new IllegalArgumentException("Invalid data: blank string.");
                }
            }

            if (arg instanceof Number n) {
                if (n.doubleValue() <= 0) {
                    throw new IllegalArgumentException("Invalid data: number must be greater than 0.");
                }
            }
        }
    }

    @Deprecated
    public void oldMethod() {
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
