package com.flippingoptimizer;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Item;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.shadowlabel.JShadowedLabel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class UISolverResult extends JPanel
{
    private static final Border GREEN_BORDER = new CompoundBorder(
            BorderFactory.createMatteBorder(0, 4, 0, 0, (ColorScheme.PROGRESS_COMPLETE_COLOR).darker()),
            BorderFactory.createEmptyBorder(7, 12, 7, 7));

    private static final Dimension ICON_SIZE = new Dimension(32, 32);

    @Getter(AccessLevel.PACKAGE)
    private final Item item;

    @Getter(AccessLevel.PACKAGE)
    private String itemName;

    private final JShadowedLabel uiItemQuantity;
    private final JPanel uiInfo;

    @Getter(AccessLevel.PACKAGE)
    private boolean isAvailable;

    @Getter(AccessLevel.PACKAGE)
    private boolean isSelected;

    @Getter(AccessLevel.PACKAGE)
    private boolean isOverlapping;

    @Getter(AccessLevel.PACKAGE)
    @Setter(AccessLevel.PACKAGE)
    private int value;

    UISolverResult(Item item, ClientThread clientThread)
    {
        this.item = item;

        setLayout(new BorderLayout());
        setBorder(GREEN_BORDER);
        setBackground(ColorScheme.DARKER_GRAY_COLOR);

        uiInfo = new JPanel(new GridLayout(2, 1));
        uiInfo.setBackground(ColorScheme.DARKER_GRAY_COLOR);
        uiInfo.setBorder(new EmptyBorder(0, 5, 0, 0));

        JShadowedLabel uiItemName = new JShadowedLabel();
        clientThread.invokeLater(() ->
        {
            itemName = item.toString();
            SwingUtilities.invokeLater(() -> uiItemName.setText(itemName));
        });
        uiItemName.setForeground(Color.WHITE);

        uiItemQuantity = new JShadowedLabel("0");
        uiItemQuantity.setFont(FontManager.getRunescapeSmallFont());
        uiItemQuantity.setForeground(ColorScheme.LIGHT_GRAY_COLOR);

        uiInfo.add(uiItemName);
        uiInfo.add(uiItemQuantity);

        add(uiInfo, BorderLayout.CENTER);
    }

    void setText(String text)
    {
        uiItemQuantity.setText(text);
    }


    @Override
    public void setBackground(Color color)
    {
        super.setBackground(color);
        if (uiInfo != null)
        {
            uiInfo.setBackground(color);
        }
    }
}