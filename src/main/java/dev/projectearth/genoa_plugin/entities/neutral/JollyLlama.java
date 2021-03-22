package dev.projectearth.genoa_plugin.entities.neutral;

import org.cloudburstmc.server.entity.EntityType;
import org.cloudburstmc.server.entity.impl.passive.EntityLlama;
import org.cloudburstmc.server.entity.passive.Llama;
import org.cloudburstmc.server.level.Location;

public class JollyLlama extends EntityLlama {
    public JollyLlama(EntityType<Llama> type, Location location) {
        super(type, location);
    }

    @Override
    public String getName() {
        return "Jolly Llama";
    }
}
