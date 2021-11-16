package com.flippingoptimizer;

import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Item;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.game.ItemManager;
import com.flippingoptimizer.UISolverInputArea;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class FlippingOptimizer extends JPanel {

    private final UISolverInputArea uiInput;
    private final Client client;
    private final ClientThread clientThread;
    private final SpriteManager spriteManager;
    private final ItemManager itemManager;
    private List<Item> solution;
    private final List<UISolverResult> uiSolutionItems = new ArrayList<>();

    private static final int MAX_GOLD = 2147483647;
    private static final int MAX_WINDOWS = 8;

    private int gold = 0;
    private int windows = 8;

    FlippingOptimizer(Client client, ClientThread clientThread, SpriteManager spriteManager, ItemManager itemManager, UISolverInputArea uiInput) {
        this.client = client;
        this.clientThread = clientThread;
        this.uiInput = uiInput;
        this.spriteManager = spriteManager;
        this.itemManager = itemManager;

        uiInput.getUiFieldGold().addActionListener(e ->
        {
            onFieldGoldUpdated();
            uiInput.getUiFieldGold().requestFocusInWindow();
        });

        uiInput.getUiFieldWindows().addActionListener(e ->
        {
            onFieldWindowsUpdated();
            uiInput.getUiFieldWindows().requestFocusInWindow();
        });
    }

    private void renderSolution()
    {
        // Wipe the list of references to the slot components.
        uiSolutionItems.clear();

        // Create new components for the action slots.
        for (Item item : solution)
        {

            UISolverResult entry = new UISolverResult(item, clientThread);
            uiSolutionItems.add(entry); // Keep our own reference.
            add(entry); // Add component to the panel.

        }

        // Refresh the rendering of this panel.
        revalidate();
        repaint();
    }

    private void solve() {

        solution.clear();




    }

    private void updateInputFields()
    {
        uiInput.setGoldInput(gold);
        uiInput.setWindowsInput(windows);
    }


    private void onFieldGoldUpdated()
    {
        gold = checkGoldRange(uiInput.getGoldInput());
        updateInputFields();
    }

    private void onFieldWindowsUpdated()
    {
        windows = checkWindowsRange(uiInput.getWindowsInput());
        updateInputFields();
    }

    private static int checkGoldRange(int input) {
        if(input < 0) return 0;
        return Math.min(input, MAX_GOLD);
    }

    private static int checkWindowsRange(int input) {
        if(input < 0) return 0;
        return Math.min(input, MAX_WINDOWS);
    }

}
