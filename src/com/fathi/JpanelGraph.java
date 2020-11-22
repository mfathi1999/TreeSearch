package com.fathi;

import javax.swing.*;
import java.awt.*;

class JPanelGraph extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(5, 5, 25, 25);

    }
}
