package n2exercici1;

import java.nio.file.Path;

public class N2Exercici1 {
    public static void main(String[] args){
        Worker worker = new Worker("Bette", "Davis", 123);

        try {
            Path path = JsonSerializingTool.serialize(worker);
            System.out.println("Json file saved in: " + path.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
