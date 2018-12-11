package me.ljnic.tomes;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.Value;

public final class TomeKeys {

    public static Key<Value<String>> TOME_COMMAND;
    static DataRegistration<TomeData, TomeData.Immutable> TOME_COMMAND_DATA_REGISTRATION;

    static {
        TOME_COMMAND = Key.builder()
                .type(new TypeToken<Value<String>>() {
                })
                .id("tomeCommand")
                .name("TomeCommand")
                .query(DataQuery.of("tomes", "TomeCommand"))
                .build();
    }

    TomeKeys() {
    }

}