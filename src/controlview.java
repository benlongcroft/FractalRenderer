import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class controlview extends JFrame implements MouseListener {

    private BufferedImage img;
    Container contentPane;
    private int zoom = 200;


    public controlview(){
        super("Mandelbrot Set");
        setBounds(100, 100, 1000, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        x_move = e.getX();
//        y_move = e.getY();
        System.out.println(1000 - e.getX());
        System.out.println(800 - e.getY());
        mandelbrot img_obj = new mandelbrot(1000, 800, 1000);
        float x_move = 0.328f;
        float y_move = 0.3975f;
        this.img = img_obj.getPixels(zoom, x_move, y_move);
        contentPane.removeAll();
        contentPane.repaint();
        contentPane.add(new imgPanel());
        zoom = zoom + zoom;
        validate();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public class imgPanel extends JPanel{
        public imgPanel(){
            setBounds(0,0,1000,800);

        }
        @Override
        public void paint (Graphics g){
            super.paint(g);
            g.drawImage(img, 0, 0, this);
        }
    }

}
