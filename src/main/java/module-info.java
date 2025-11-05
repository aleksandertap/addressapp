module ch.makery.address {
    requires javafx.controls;
    requires javafx.fxml;
    // piltide kasutamiseks
    requires javafx.graphics;
    requires java.prefs;

    // JAXB
    requires jakarta.xml.bind;
    requires javafx.base;

    // Anna FXML-le peegeldusligipääs kontrolleritele
    opens ch.makery.address.view to javafx.fxml;

    // Ava JAXB-le *ja* Glassfishi implementatsioonile (core + runtime)
    opens ch.makery.address.model to jakarta.xml.bind, org.glassfish.jaxb.core, org.glassfish.jaxb.runtime;
    opens ch.makery.address.util  to jakarta.xml.bind, org.glassfish.jaxb.core, org.glassfish.jaxb.runtime;

    exports ch.makery.address;
}