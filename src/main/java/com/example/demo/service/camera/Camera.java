package com.example.demo.service.camera;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import javax.swing.*;

/**
 * @author ranran.mao
 * @date 2021/11/4 19:39
 */
public class Camera {
    public static void main(String[] args) {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);
        JFrame camera = new JFrame("camera");
        camera.add(panel);
        camera.setResizable(true);
        camera.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        camera.pack();
        camera.setVisible(true);
        System.out.println("111111111111");
    }
}
