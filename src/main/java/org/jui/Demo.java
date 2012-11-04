package org.jui;

import javax.swing.SwingUtilities;

public class Demo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Component().render();
            }
        });
    }
}
