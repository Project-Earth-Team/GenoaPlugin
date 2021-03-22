package dev.projectearth.genoa_plugin.entities.hostile;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.hostile.EntityWitch;
import org.cloudburstmc.server.entity.hostile.Witch;
import org.cloudburstmc.server.level.Location;

public class VilerWitch extends EntityWitch {
    public VilerWitch(EntityType<Witch> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Viler Witch";
    }
}
