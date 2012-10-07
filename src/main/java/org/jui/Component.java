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

/**
 * Default implementation of UI component. This defines the standard design pattern
 * that all UI components should follow.
 */
public class Component {
    private ComponentRenderer renderer = null;
    private boolean rendered = false;
    private Object ui = null;

    public Component() {
        this(null);
    }

    public Component(ComponentRenderer renderer) {
        this.renderer = renderer != null ? renderer : ComponentRenderer.getInstance();
    }

    public boolean isRendered() {
        return this.rendered;
    }

    public void render() {
        if (this.rendered) {
            return;
        }

        if (this.ui == null) {
            this.createUi();
        }

        this.renderer.addChild(this);

        this.rendered = true;
    }

    public void createUi() {
        this.ui = this.renderer.createUi(this);
    }

    public Object getUi() {
        return this.ui;
    }
}
