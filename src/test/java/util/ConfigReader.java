package util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader
{
    private Properties property;

    public Properties initProperties()  {
        property = new Properties();
        try {
            FileInputStream ip = new FileInputStream("C:\\Users\\irfan\\IdeaProjects\\JavaProJect\\src\\test\\resources\\config.properties");
            property.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
             return property;
    }
}
