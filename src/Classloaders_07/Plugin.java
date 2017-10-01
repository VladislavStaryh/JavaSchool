package Classloaders_07;

public class Plugin implements IPlugin {
    @Override
    public void printPluginName() {
        System.out.println("It's class PluginClass in Browser");
    }
}
