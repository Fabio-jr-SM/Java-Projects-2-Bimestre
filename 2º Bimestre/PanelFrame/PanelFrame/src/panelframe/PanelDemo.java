package panelframe;
import javax.swing.JFrame;

public class PanelDemo extends JFrame {

    public static void main(String[] args) {
        PanelFrame panelFrame = new PanelFrame();
        panelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelFrame.setSize(450, 200); // confi gura o tamanho do frame
        panelFrame.setVisible(true); // exibe o frame
    } // fi m de main
}
