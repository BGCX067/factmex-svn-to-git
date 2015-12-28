package mx.com.factmex.app.client;

import com.smartgwt.client.widgets.Canvas;

public interface PanelFactory {

    Canvas create();

    String getID();

    String getDescription();
}
