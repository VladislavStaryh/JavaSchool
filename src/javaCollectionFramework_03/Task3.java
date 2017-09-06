package javaCollectionFramework_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));
        Map<String,Integer> words = new HashMap<>();
        while(in.hasNext()) {
            String word = in.next();
            int count = words.getOrDefault(word,0);
            words.put(word,++count);
        }
        Iterator<String> it  = words.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key + " " + words.get(key));
        }
    }
}
