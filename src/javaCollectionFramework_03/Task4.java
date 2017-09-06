package javaCollectionFramework_03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task4 {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();


        lines = Files.readAllLines(Paths.get("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));
        ListIterator<String> it = lines.listIterator(lines.size());
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }


    }
}
