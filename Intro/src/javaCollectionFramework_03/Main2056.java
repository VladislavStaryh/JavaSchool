package javaCollectionFramework_03;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Main2056 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));
        Map<String,Integer> map = new HashMap<>();
        while(in.hasNext()) {
            String str = in.next().toLowerCase();
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        in.close();
        Integer max = Collections.max(map.values());
        Set <String> set = new TreeSet<>();

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            String key = it.next();
            if (map.get(key)==max){
                set.add(key);
            }
        }
        System.out.println(set.toString());

        FileWriter fw = null;
        try {
            fw = new FileWriter("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\out.txt", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        it = set.iterator();

            while (it.hasNext()) {
                String word = it.next();
                try {
                    bw.write(word);
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
