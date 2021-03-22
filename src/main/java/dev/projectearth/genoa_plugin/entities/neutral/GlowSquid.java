package dev.projectearth.genoa_plugin.entities.neutral;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntitySquid;
import org.cloudburstmc.server.entity.passive.Squid;
import org.cloudburstmc.server.level.Location;

public class GlowSquid extends EntitySquid {
    public GlowSquid(EntityType<Squid> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Glow Squid";
    }
}
