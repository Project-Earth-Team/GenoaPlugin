package dev.projectearth.genoa_plugin.entities.sheep;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntitySheep;
import org.cloudburstmc.server.entity.passive.Sheep;
import org.cloudburstmc.server.level.Location;

public class GenoaSheep extends EntitySheep {
    public GenoaSheep(EntityType<Sheep> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Sheep";
    }
}
