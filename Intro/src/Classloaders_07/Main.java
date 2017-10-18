package Classloaders_07;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) {

        try {
            PluginManager pluginManager = new PluginManager("C:\\Users\\VVS\\IdeaProjects\\JavaSchoolTasks\\src\\Classloaders_07");
            Plugin plugin1 = pluginManager.load("Plugin", "Plugin");
            //Plugin plugin2 = pluginManager.load("Plugin2", "PluginClass");

            plugin1.printPluginName();
            //plugin2.printPluginName();

            plugin1 = pluginManager.loadPlugins("Plugin", "Plugin");
            //plugin2 = pluginManager.loadPlugins("Plugin2", "PluginClass");

            plugin1.printPluginName();
            //plugin2.printPluginName();

        } catch (ClassNotFoundException | MalformedURLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
