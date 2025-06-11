package com.example.ppgame.framework;

import org.apache.poi.sl.usermodel.PictureData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;

public class PowerPointRenderer {
    protected final XMLSlideShow ppt;
    protected XSLFSlide currentSlide;

    public PowerPointRenderer() {
        ppt = new XMLSlideShow();
        currentSlide = ppt.createSlide();
    }

    public void newFrame() {
        currentSlide = ppt.createSlide();
    }

    public void drawSprite(Sprite sprite, double x, double y) {
        try (InputStream is = sprite.getResourceStream();
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            PictureData data = ppt.addPicture(bos.toByteArray(), PictureData.PictureType.PNG);
            XSLFPictureShape shape = currentSlide.createPicture(data);
            shape.setAnchor(new Rectangle((int)x, (int)y, sprite.getWidth(), sprite.getHeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String path) throws IOException {
        try (FileOutputStream out = new FileOutputStream(path)) {
            ppt.write(out);
        }
    }
}
