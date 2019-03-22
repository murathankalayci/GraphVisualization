import javax.swing.JFrame;

public class Main extends JFrame
{
    public static void main(String[] args)
    {
        GraphFrame frame = new GraphFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 320);
        frame.setVisible(true);
    }

}