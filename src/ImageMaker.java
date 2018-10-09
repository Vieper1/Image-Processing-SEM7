import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Create
{
    static BufferedImage image;
    
    public static void main(String[] args) throws IOException
    {
        int width = 640;
        int height = 480;
        int r = 255, g = 255, b = 255, p = 0;
        File f = null;

        image = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_RGB
        );
        
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                image.setRGB(j, i, 0x009688);
        
        int d = Integer.valueOf(args[0]);
        
        
        for(int i=50;i<100;i++)
        {
            drawCircleUsingMidpointCircleAlgo(320, 240, i, d, 0x3F51B5);            
        }

for(int i=50;i<100;i++)
        {
            drawCircleUsingMidpointCircleAlgo(320+150, 240, i, d, 0xFF5722);        
        }
        
        for(int i=50;i<100;i++)
        {
            drawCircleUsingMidpointCircleAlgo(320-150, 240, i, d, 0x03A9F4);        
        }
        
        for(int i=50;i<100;i++)
        {
            drawCircleUsingMidpointCircleAlgo(320, 240+100, i, d, 0x673AB7);        
        }
        
        for(int i=50;i<100;i++)
        {
            drawCircleUsingMidpointCircleAlgo(320, 240-100, i, d, 0xE91E63);        
        }

        


        

        f = new File("ViperOut.png");
        ImageIO.write(image, "png", f);
    }
    
    public static void drawCircleUsingMidpointCircleAlgo(int centre_x, int centre_y, int r, float d_init, int draw_color)
    {
        float d=0;
        int x=0;
        int y=0;
        int i=0;

        draw_color = 0xCDDC39;
    
    
        d=d_init-r;
        x=0;
        y=r;
        do
        {
            if(d<0)
            {
    //            printf("[%d]", d);
                x=x+1;
                d=d+2*x+1;
            }
            else
            {
    //            printf("[%d]", d);
                x=x+1;
                y=y-1;
                d=d+2*x-2*y+10;
            }
            image.setRGB(centre_x+x, centre_y+y, draw_color);
            image.setRGB(centre_x-y, centre_y-x ,draw_color);
            image.setRGB(centre_x+y, centre_y-x, draw_color);
            image.setRGB(centre_x-y, centre_y+x, draw_color);
            image.setRGB(centre_x+y, centre_y+x, draw_color);
            image.setRGB(centre_x-x, centre_y-y, draw_color);
            image.setRGB(centre_x+x, centre_y-y, draw_color);
            image.setRGB(centre_x-x, centre_y+y, draw_color);
        }
        while(x<y);
    }
}
