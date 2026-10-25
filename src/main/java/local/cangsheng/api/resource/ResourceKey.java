package local.cangsheng.api.resource;

import net.minecraft.resources.Identifier;

/** Stable identifier and data shape for a resource-pool definition. */
public record ResourceKey(Identifier id, int max, ResourceShape shape) {}
