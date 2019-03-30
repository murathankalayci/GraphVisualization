import javax.swing.JFrame;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JFrame
{
    public static ArrayList<String> stringOne = new ArrayList<>();
    public static ArrayList<String> stringTwo = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader("src/test.txt");
        BufferedReader bufRead = new BufferedReader(file);
        String myLine = null;
        while ( (myLine = bufRead.readLine()) != null)
        {
            String[] array = myLine.split(" ");
            String a = array[1];
            String b = array[2];
            stringOne.add(a);
            stringTwo.add(b);
        }
        GraphFrame frame = new GraphFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }

}