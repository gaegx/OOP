//TIP Для <b>запуска</b> кода нажмите <shortcut actionId="Run"/> или
import main.java.com.model.Coins.Bitcoin;
import main.java.com.view.MainFrame;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Bitcoin bitcoin=Bitcoin.createBitcoin("Bit","B","block",1090,1);
        Bitcoin bitcoin1=Bitcoin.createBitcoin("Bit","B","block",1090,2);
        bitcoin1=bitcoin;
       SwingUtilities.invokeLater(MainFrame::new);





    }
}