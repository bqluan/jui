package org.jui;

public class EventTarget {
    private EventTarget parentEventTarget;
    private EventHelper eventHelper;

    public EventTarget() {
        this(null);
    }

    public EventTarget(EventHelper eventHelper) {
        this.eventHelper =
            eventHelper != null ? eventHelper : EventHelper.getInstance();
    }

    public void addEventListener(String type,
                                 EventListener listener,
                                 boolean useCapture) {
        this.getEventHelper().listen(this, type, listener);
    }

    public void removeEventListener(String type,
                                    EventListener listener,
                                    boolean useCapture) {
    }

    public boolean dispatchEvent(Event e) {
        return false;
    }

    public EventTarget getParentEventTarget() {
        return this.parentEventTarget;
    }

    public void setParentEventTarget(EventTarget parentEventTarget) {
        this.parentEventTarget = parentEventTarget;
    }

    public EventHelper getEventHelper() {
        return this.eventHelper;
    }
}
