/*
 * Copyright (c) 2012 Bing-Qian Luan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package org.jui;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The default renderer of a <code>Component</code>. This renderer uses
 * Swing to render UI components.
 */
public class ComponentRenderer {
    private static ComponentRenderer instance = null;

    protected ComponentRenderer() {
    }

    public static ComponentRenderer getInstance() {
        if (instance == null) {
            instance = new ComponentRenderer();
        }
        return instance;
    }

    /**
     * Creates the UI object to be rendered. This default implementation
     * creates a JLabel.
     *
     * @param component the component to render
     * @return the root UI object for the component
     */
    public Object createUi(Component component) {
        return new JLabel("Hello World!");
    }

    /**
     * Initializes the UI object created by <code>createUi</code> by
     * configuring properties that can only be set after the UI object
     * is added in some container.
     *
     * @param comonent the component whose UI object is to be initialized
     *     as it is added in some container
     */
    public void initializeUi(Component component) {
    }

    /**
     * Adds <code>child</code> in the <code>parent</code> container.
     *
     * @param child the child component to be added
     */
    public void addChild(Component child) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add((java.awt.Component)child.getUi());
        frame.pack();
        frame.show();
    }

    public void setText(Component component, String text) {
        JLabel label = (JLabel)component.getUi();
        label.setText(text);
    }
}
