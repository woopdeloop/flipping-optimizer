package com.flippingoptimizer;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.game.ItemManager;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.util.ImageUtil;
import net.runelite.api.Item;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;

@PluginDescriptor(
		name = "Flipping Optimizer",
		description = "Enable the Flipping Optimizer panel",
		tags = {"panel", "flipping"}
)
public class FlippingOptimizerPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private FlippingOptimizerConfig config;

	@Inject
	private FlippingOptimizer optimizer;

	@Override
	protected void startUp() throws Exception {

	}

	@Override
	protected void shutDown() throws Exception {

	}

	@Provides
	FlippingOptimizerConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(FlippingOptimizerConfig.class);
	}



}
