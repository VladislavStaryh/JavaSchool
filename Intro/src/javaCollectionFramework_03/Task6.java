package javaCollectionFramework_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();


        lines = Files.readAllLines(Paths.get("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));
        ListIterator<String> it = lines.listIterator(lines.size());

        Scanner userInput = new Scanner(System.in);


        int number = -1;
        while (number != 0){
            number = userInput.nextInt();
            if (number <= lines.size() && number > 0 ) {
                System.out.println(lines.get(number - 1));
            }
        }


    }
}
