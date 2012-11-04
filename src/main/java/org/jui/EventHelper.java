package org.jui;

public class EventHelper {
    private static EventHelper instance;

    protected EventHelper() {
    }

    public static EventHelper getInstance() {
        if (instance == null) {
            instance = new EventHelper();
        }
        return instance;
    }

    public void listen(Object source,
                       String type,
                       EventListener listener) {
        if (source instanceof java.awt.Component) {
            AwtEventHelper.getInstance().listen(source, type, listener);
        }
    }
}
