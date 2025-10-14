package n2exercici1;

import java.nio.file.Path;

public class N2Exercici1 {
    public static void main(String[] args){
        try {
            Worker worker = new Worker("Bette", "Davis", 123);
            Path path = JsonSerializing.serialize(worker);
            System.out.println("Json file saved in: " + path.toAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
