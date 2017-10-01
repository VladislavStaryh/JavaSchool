package Classloaders_07;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;

public class PluginManager {
    private final String pluginRootDirectory;
    private URLClassLoader urlClassLoader;
    private ExtendedURLClassLoader extendedURLClassLoader;

    public PluginManager(String pluginRootDirectory) throws MalformedURLException {
        this.pluginRootDirectory = pluginRootDirectory;

    }


    public Plugin load(String pluginName, String pluginClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {

        URL[] urls = new URL[]{Paths.get(pluginRootDirectory + "\\" + pluginName).toUri().toURL()};
        urlClassLoader = new URLClassLoader(urls);

        Class<?> clazz = urlClassLoader.loadClass(pluginClassName);

        Plugin result = (Plugin) clazz.newInstance();

        return result;
    }


    public Plugin loadPlugins(String pluginName, String pluginClassName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, MalformedURLException {

        URL[] urls = new URL[]{Paths.get(pluginRootDirectory + "\\" + pluginName).toUri().toURL()};
        extendedURLClassLoader = new ExtendedURLClassLoader(urls);

        Class<?> clazz = extendedURLClassLoader.loadClass(pluginClassName);

        Plugin result = (Plugin) clazz.newInstance();

        return result;
    }
}
