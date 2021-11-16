package com.flippingoptimizer;

import lombok.Getter;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.FlatTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
class UISolverInputArea extends JPanel
{
    private final JTextField uiFieldGold;
    private final JTextField uiFieldWindows;

    UISolverInputArea()
    {
        setLayout(new GridLayout(2, 2, 7, 7));
        uiFieldGold = addComponent("GP Available");
        uiFieldWindows = addComponent("Windows Available");
    }

    int getGoldInput() {
        return getInput(uiFieldGold);
    }

    void setGoldInput(int value) {
        setInput(uiFieldGold, value);
    }

    int getWindowsInput() {
        return getInput(uiFieldWindows);
    }

    void setWindowsInput(Object value) {
        setInput(uiFieldWindows, value);
    }

    private int getInput(JTextField field)
    {
        try
        {
            return Integer.parseInt(field.getText().replaceAll("\\D", ""));
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }

    private void setInput(JTextField field, Object value)
    {
        field.setText(String.valueOf(value));
    }

    private JTextField addComponent(String label)
    {
        final JPanel container = new JPanel();
        container.setLayout(new BorderLayout());

        final JLabel uiLabel = new JLabel(label);
        final FlatTextField uiInput = new FlatTextField();

        uiInput.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        uiInput.setHoverBackgroundColor(ColorScheme.DARK_GRAY_HOVER_COLOR);
        uiInput.setBorder(new EmptyBorder(5, 7, 5, 7));

        uiLabel.setFont(FontManager.getRunescapeSmallFont());
        uiLabel.setBorder(new EmptyBorder(0, 0, 4, 0));
        uiLabel.setForeground(Color.WHITE);

        container.add(uiLabel, BorderLayout.NORTH);
        container.add(uiInput, BorderLayout.CENTER);

        add(container);

        return uiInput.getTextField();
    }
}

