package com.printscsysrq.files;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.util.ArrayList;
import javax.imageio.ImageIO;
public class Print {
	private Robot rob ;
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private ArrayList<BufferedImage> bf = new ArrayList();
	private String extension;
	private File local;
	private Rectangle rectangle;
	
	public Print(File local,String extension) throws Exception {
		/**
		 * Constructor
		 * the parameter local is a local path where you want save the archives
		 * the parameter extension is a extension of image what you want use;
		 */
		rob = new Robot();
		
		setLocalPath(local.getPath());
		this.extension = extension;
		rectangle = new Rectangle(tk.getScreenSize());
	}
	public void setLocalPath(String local) throws IOException {
		File i = new File(local);
		if(!i.exists()) {
			 i.createNewFile();
			 this.local = i;
		}else {
			 this.local = i;
		}
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public void go(int tot)   {
		/**
		 * the paremeter tot is a total of images what you want
		 */
		for(int i = 0; i < tot; i ++) {
			bf.add(rob.createScreenCapture(rectangle));
		}
	}
	public void savePrints() throws IOException {
		/**
		 * this methods save images in local path
		 */
		for(int i = 0 ; i < bf.size(); i++) {
			ImageIO.write(bf.get(i), extension, new File(local.getPath()+"\\img"+i+"."+extension));
		}
	}
}

