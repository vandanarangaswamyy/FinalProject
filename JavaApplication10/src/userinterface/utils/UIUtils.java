/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userinterface.utils;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;
/**
 *
 * @author Admin
 */
public class UIUtils {
    /**
     * Sets a background image for a JLabel and ensures it resizes dynamically.
     *
     * @param label The JLabel to set the image on.
     * @param imagePath The path to the image file.
     */
    public static void setBackgroundImage(JLabel label, String imagePath) {
    System.out.println("Setting background image: " + imagePath);
    URL imageURL = label.getClass().getClassLoader().getResource(imagePath);
    if (imageURL != null) {
        System.out.println("Image found at: " + imageURL);
        ImageIcon imageIcon = new ImageIcon(imageURL);
        label.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));

        // Add a listener to resize the image dynamically
        label.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Image resizedImage = imageIcon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(resizedImage));
            }
        });
    } else {
        System.err.println("Image not found: " + imagePath);
    }
}

    
}
