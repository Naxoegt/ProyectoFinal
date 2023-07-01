package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import javax.swing.JRadioButton;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PanelInformacionTest {

    @Test
    @DisplayName("Test verificar dimensiones correctas")
    void testPreferredSize() {
        PanelInformacion panelInformacion = new PanelInformacion(new ListaDeAsientos(new Estado()));

        assertEquals(new Dimension(1200, 600), panelInformacion.getPreferredSize());
    }
}
