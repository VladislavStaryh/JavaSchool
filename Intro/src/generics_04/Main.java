package generics_04;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        CustomLinkedList<Integer> customLinkedList= new CustomLinkedList<>();
        customLinkedList.add(111);
        customLinkedList.add(222);
        customLinkedList.add(333);
        customLinkedList.add(444);
        customLinkedList.add(555);

        customLinkedList.remove(0);
        customLinkedList.remove(2);


        Iterator <Integer> it = customLinkedList.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
