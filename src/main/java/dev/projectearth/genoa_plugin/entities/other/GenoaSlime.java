package dev.projectearth.genoa_plugin.entities.other;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.hostile.EntitySlime;
import org.cloudburstmc.server.entity.hostile.Slime;
import org.cloudburstmc.server.level.Location;

public class GenoaSlime extends EntitySlime {
    public GenoaSlime(EntityType<Slime> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Slime";
    }
}
