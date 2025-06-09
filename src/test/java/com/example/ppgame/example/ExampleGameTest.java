package com.example.ppgame.example;

import com.example.ppgame.framework.PowerPointRenderer;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleGameTest {
    @Test
    public void generatesValidPresentation() throws IOException {
        System.setProperty("java.awt.headless", "true");
        Path temp = Files.createTempFile("game", ".pptx");
        PowerPointRenderer renderer = new PowerPointRenderer();
        ExampleGame game = new ExampleGame(renderer);
        game.run(2);
        renderer.save(temp.toString());

        try (XMLSlideShow slideShow = new XMLSlideShow(Files.newInputStream(temp))) {
            assertTrue(slideShow.getSlides().size() >= 2);
        }
    }
}
