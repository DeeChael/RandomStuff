package net.deechael.randomstuff.block;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum CornerType implements StringRepresentable {

    ES("es"),
    EN("en"),
    WS("ws"),
    WN("wn");

    private final String name;

    CornerType(String name) {
        this.name = name;
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
