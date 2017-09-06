package javaCollectionFramework_03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\javaCollectionFramework_03\\in.txt"));

        Comparator<String> seqComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer l1 = new Integer(o1.length());
                Integer l2 = new Integer(o2.length());
                if (l1.compareTo(l2)==0){
                    return o1.compareTo(o2);
                }
                return l1.compareTo(l2);
            }
        };

        Set<String> words = new TreeSet<>(seqComparator);
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
