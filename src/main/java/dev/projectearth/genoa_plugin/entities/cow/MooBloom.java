package dev.projectearth.genoa_plugin.entities.cow;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityCow;
import org.cloudburstmc.server.entity.passive.Cow;
import org.cloudburstmc.server.level.Location;

public class MooBloom extends EntityCow {
    public MooBloom(EntityType<Cow> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Moobloom";
    }
}
