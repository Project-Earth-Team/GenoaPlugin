package dev.projectearth.genoa_plugin.entities.sheep;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntitySheep;
import org.cloudburstmc.server.entity.passive.Sheep;
import org.cloudburstmc.server.level.Location;

public class HornedSheep extends EntitySheep {
    public HornedSheep(EntityType<Sheep> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Horned Sheep";
    }
}
