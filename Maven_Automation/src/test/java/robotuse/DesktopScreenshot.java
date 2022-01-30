package robotuse;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DesktopScreenshot {

	public static void main(String[] args) throws Exception {

		Thread.sleep(500);
		Robot robot=new Robot();
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenshot=new Rectangle(screensize);
		BufferedImage img = robot.createScreenCapture(screenshot);
		ImageIO.write(img, "PNG", new File("Desktop.png"));


	}

}
