package net.deechael.randomstuff.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum PillarType implements StringRepresentable {

    ES("es"),
    EN("en"),
    WS("ws"),
    WN("wn"),
    ES_EN("es_en"),
    ES_WS("es_ws"),
    ES_WN("es_wn"),
    EN_WS("en_ws"),
    EN_WN("en_wn"),
    WS_WN("ws_wn"),
    ES_EN_WS("es_en_ws"),
    ES_EN_WN("es_en_wn"),
    ES_WS_WN("es_ws_wn"),
    EN_WS_WN("en_ws_wn"),
    FULL("full");

    private final String name;

    PillarType(String name) {
        this.name = name;
    }

    public PillarType tryAdd(PillarType anotherPosition) {
        if (anotherPosition.name.length() != 2)
            throw new RuntimeException("Multi position type found!");
        if (this.name.contains(anotherPosition.name))
            throw new RuntimeException("Position duplicated!");
        List<String> directions = new ArrayList<>();
        directions.add(anotherPosition.getSerializedName());
        directions.addAll(List.of(this.getSerializedName().split("_")));
        for (PillarType pillarType : PillarType.values()) {
            boolean someNotFound = false;
            for (String direction : directions) {
                if (!pillarType.name.contains(direction)) {
                    someNotFound = true;
                    break;
                }
            }
            if (someNotFound)
                continue;
            return pillarType;
        }
        throw new RuntimeException("SHOULDN'T!");
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
