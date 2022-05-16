import java.awt.*;
import java.awt.image.BufferedImage;

public class mandelbrot {
    int width = 1000, height = 800, max = 1000;
    private int black = 0;
    private int[] BackgroundColors = new int[max];
    private int[] MandelbrotColors = new int[max];
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    private void getBackroundColor(){
        for (int i = 0; i<max; i++) {
            BackgroundColors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+7f));
        }
    }

    private void getMandelbrotColor(){
        for (int i=0; i<max; i++) {
            MandelbrotColors[i] = Color.HSBtoRGB(i/256f, 1, i/(i+3f));
        }
    }


    public BufferedImage getPixels(double zoom ,float x_move, float y_move){
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                double cx = ((col - width/2) / zoom + x_move);
                double cy = ((row - height/2) / zoom + y_move);
                double x = 0, y = 0;
                int iteration = 0;
                while ((x*x)+(y*y) < 4 && iteration < max) {
                    double x_new = x * x - y * y + cx;
                    y = 2 * x * y + cy;
                    x = x_new;
                    iteration++;
                }
                if (iteration < max) image.setRGB(col, row, BackgroundColors[iteration]);
                else image.setRGB(col, row, MandelbrotColors[iteration%max]);
            }
        }
        return image;
    }

    public mandelbrot(int width, int height, int max){
        this.width = width;
        this.height = height;
        this.max = max;
        getBackroundColor();
        getMandelbrotColor();
    }
}
