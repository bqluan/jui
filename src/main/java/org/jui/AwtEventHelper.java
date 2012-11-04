package org.jui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AwtEventHelper extends EventHelper {
    private static EventHelper instance;

    private AwtEventHelper() {
    }

    public static EventHelper getInstance() {
        if (instance == null) {
            instance = new AwtEventHelper();
        }
        return instance;
    }

    public void listen(Object source,
                       String type,
                       EventListener listener) {
        this.listen((java.awt.Component)source, type, listener);
    }

    public void listen(java.awt.Component source,
                       String type,
                       EventListener listener) {
        Method method = null;
        Class[] params = new Class[] {
            java.awt.Component.class, EventListener.class
        };

        try {
            method = this.getClass().getDeclaredMethod(type, params);
        } catch (NoSuchMethodException e) {
            return;
        }

        try {
            method.invoke(this, new Object[] {source, listener});
        } catch (IllegalAccessException e)  {
            return;
        } catch (InvocationTargetException e) {
            return;
        }
    }

    public void click(java.awt.Component source, final EventListener listener) {
        source.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                listener.handleEvent(null);
            }
        });
    }
}
