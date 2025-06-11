package com.example.ppgame.framework.interactive;

import org.apache.poi.xslf.usermodel.XSLFTextBox;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Renderer that allows adding simple VBA macros and control buttons.
 * The actual macro embedding is left as a placeholder. The idea is to
 * generate a macro-enabled presentation (.pptm) where shapes can invoke
 * macros for basic interactivity.
 */
public class InteractivePowerPointRenderer extends PowerPointRenderer {
    private final Map<String, String> macros = new LinkedHashMap<>();

    public InteractivePowerPointRenderer() {
        super();
    }

    /**
     * Register a VBA macro with the given name.
     * @param name macro name
     * @param code macro body without the Sub/End Sub wrapper
     */
    public void addMacro(String name, String code) {
        macros.put(name, code);
    }

    /**
     * Adds a clickable button that should trigger the given macro.
     * Actual linking of the macro to the shape is left as a TODO because
     * Apache POI does not yet expose a high level API for it.
     */
    public void addControlButton(String text, double x, double y, double width, double height, String macro) {
        XSLFTextBox box = currentSlide.createTextBox();
        box.setText(text);
        box.setAnchor(new Rectangle((int) x, (int) y, (int) width, (int) height));
        // TODO link the shape to run the macro when clicked
    }

    @Override
    public void save(String path) throws IOException {
        // TODO embed macros into the generated file and change extension to .pptm
        super.save(path);
    }
}
