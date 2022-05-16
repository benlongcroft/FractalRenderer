import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class render {
    public double zoom = 0.3;

    public render() throws IOException {
        //this is where main loop goes
        for (int i=0; i<200; i++){
            System.out.println(i+"/200");
            BufferedImage img = zoom();
            File outputfile = new File("/Users/benlongcroft/Documents/FractalRenderingEngine/fractalslides/img_n"+i+".jpg");
            ImageIO.write(img, "jpg", outputfile);
        }
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    public BufferedImage zoom() {
        mandelbrot img_obj = new mandelbrot(1000, 800, 1000);
        float x_move = 0.328f;
        float y_move = 0.3975f;
        BufferedImage new_img = img_obj.getPixels(this.zoom, x_move, y_move);
        this.zoom = this.zoom + this.zoom;
        return new_img;

    }
}