
import main.java.com.model.Coins.Bitcoin;


import javax.swing.*;
import main.java.com.model.User;
import main.java.com.model.CryptoList;
import main.java.com.service.ReflectionService;
import main.java.com.view.MainFrame;
import main.java.com.model.Token;
import org.reflections.Reflections;
import main.java.com.service.ReflectionService;

public class Main {
    public static void main(String[] args) {
        User testUser = new User("Сергей Персик", "1243","fagfsf@gdhsh",5673743,1000000 );
        CryptoList cryptoList = new CryptoList();

        testUser.setCryptoList(cryptoList);
        ReflectionService reflectionService = new ReflectionService();
        var str=reflectionService.getAssetFactoryClasses();
        for (String s : str) {

            System.out.println(s);

        }
//        Object d = reflectionService.getObjectByClassNameWithGUI("main.java.com.model.Coins.Ethereum");
//        System.out.println(d.toString());

        SwingUtilities.invokeLater(() -> new MainFrame(testUser));
    }

}