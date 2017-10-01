package Classloaders_07;

import java.net.URL;
import java.net.URLClassLoader;


public class ExtendedURLClassLoader extends URLClassLoader {

    public ExtendedURLClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        Class<?> c;
        try {
            c = this.findClass(name);
        } catch (ClassNotFoundException ignore) {
            c = super.loadClass(name);
        }
        return c;
    }
}
