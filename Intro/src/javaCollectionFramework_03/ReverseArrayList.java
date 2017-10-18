package javaCollectionFramework_03;

import java.util.ArrayList;
import java.util.Iterator;

public class ReverseArrayList <T> extends ArrayList<T>{
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pos = ReverseArrayList.super.size();

            @Override
            public boolean hasNext() {
                return pos > 0;
            }

            @Override
            public T next() {
                pos--;
                return ReverseArrayList.super.get(pos);
            }
        };
    }

}
