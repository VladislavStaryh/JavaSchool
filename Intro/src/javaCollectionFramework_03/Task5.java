package javaCollectionFramework_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));
        ReverseArrayList <String> words = new ReverseArrayList<>();
        while(in.hasNext()) {
            String word = in.next();
            words.add(word);
        }

        Iterator<String> it  = words.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
