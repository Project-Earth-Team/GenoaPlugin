package dev.projectearth.genoa_plugin.entities.neutral;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.hostile.Slime;
import org.cloudburstmc.server.entity.impl.hostile.EntitySlime;
import org.cloudburstmc.server.level.Location;

public class TropicalSlime extends EntitySlime {
    public TropicalSlime(EntityType<Slime> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Tropical Slime";
    }
}
