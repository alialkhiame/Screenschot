package keyboardListener;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class KeyboardListenerExample implements KeyListener {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Keyboard Listener Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(3, 1);
		frame.addKeyListener(new KeyboardListenerExample());
		frame.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// Invoked when a physical key has been pressed
		int keyCode = e.getKeyCode();
		System.out.println("Key pressed: " + KeyEvent.getKeyText(keyCode));
		BufferedImage image = null;
		if (KeyEvent.getKeyText(keyCode).equals("NumPad-8")) {
			try {
				image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			} catch (HeadlessException | AWTException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {

				ImageIO.write(image, "png", new File(Integer.toString(counter++) + ".png"));
				System.out.println("saved " + Integer.toString(counter) + ".png");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	static int counter = 0;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
