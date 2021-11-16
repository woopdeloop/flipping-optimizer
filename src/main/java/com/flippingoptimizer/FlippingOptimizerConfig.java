package com.flippingoptimizer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("flippingoptimizer")
public interface FlippingOptimizerConfig extends Config {
	@ConfigItem(
			position = 1,
			keyName = "useCurrentCash",
			name = "Use Current Cash Stack",
			description = "Automatically uses cash stack as gp available"
	)
	default boolean playerOption()
	{
		return false;
	}
}
