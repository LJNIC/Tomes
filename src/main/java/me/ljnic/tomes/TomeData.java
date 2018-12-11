package me.ljnic.tomes;

import me.ljnic.tomes.TomeKeys;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.immutable.common.AbstractImmutableData;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.persistence.AbstractDataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;

import javax.annotation.Generated;
import java.util.Optional;

public class TomeData extends AbstractData<TomeData, TomeData.Immutable> {

    private String tomeCommand;

    TomeData() {
        tomeCommand = "";
        registerGettersAndSetters();
    }

    public TomeData(String tomeCommand) {
        this.tomeCommand = tomeCommand;
        registerGettersAndSetters();
    }

    @Override
    public void registerGettersAndSetters() {
        registerFieldGetter(TomeKeys.TOME_COMMAND, this::getDialogId);
        registerFieldSetter(TomeKeys.TOME_COMMAND, this::setDialogId);
        registerKeyValue(TomeKeys.TOME_COMMAND, this::tomeCommand);
    }

    public String getDialogId() {
        return tomeCommand;
    }

    public void setDialogId(String dialog) {
        this.tomeCommand = dialog;
    }

    public Value<String> tomeCommand() {
        return Sponge.getRegistry().getValueFactory().createValue(TomeKeys.TOME_COMMAND, tomeCommand);
    }

    @Override
    public Optional<TomeData> fill(DataHolder dataHolder, MergeFunction overlap) {
        dataHolder.get(TomeData.class).ifPresent(that -> {
            TomeData data = overlap.merge(this, that);
            this.tomeCommand = data.tomeCommand;
        });
        return Optional.of(this);
    }

    @Override
    public Optional<TomeData> from(DataContainer container) {
        return from((DataView) container);
    }

    public Optional<TomeData> from(DataView container) {
        container.getString(TomeKeys.TOME_COMMAND.getQuery()).ifPresent(v -> tomeCommand = v);
        return Optional.of(this);
    }

    @Override
    public TomeData copy() {
        return new TomeData(tomeCommand);
    }

    @Override
    public Immutable asImmutable() {
        return new Immutable(tomeCommand);
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(TomeKeys.TOME_COMMAND.getQuery(), tomeCommand);
    }

    public static class Immutable extends AbstractImmutableData<Immutable, TomeData> {

        private String dialog;

        {
            registerGetters();
        }

        Immutable() {
            dialog = "";
        }

        Immutable(String dialog) {
            this.dialog = dialog;
        }

        @Override
        protected void registerGetters() {
            registerFieldGetter(TomeKeys.TOME_COMMAND, this::getDialogId);
            registerKeyValue(TomeKeys.TOME_COMMAND, this::tomeCommand);
        }

        public String getDialogId() {
            return dialog;
        }

        public ImmutableValue<String> tomeCommand() {
            return Sponge.getRegistry().getValueFactory().createValue(TomeKeys.TOME_COMMAND, dialog).asImmutable();
        }

        @Override
        public TomeData asMutable() {
            return new TomeData(dialog);
        }

        @Override
        public int getContentVersion() {
            return 1;
        }

        @Override
        public DataContainer toContainer() {
            return super.toContainer().set(TomeKeys.TOME_COMMAND.getQuery(), dialog);
        }

    }

    public static class Builder extends AbstractDataBuilder<TomeData> implements DataManipulatorBuilder<TomeData, Immutable> {

        public Builder() {
            super(TomeData.class, 1);
        }

        @Override
        public TomeData create() {
            return new TomeData();
        }

        @Override
        public Optional<TomeData> createFrom(DataHolder dataHolder) {
            return create().fill(dataHolder);
        }

        @Override
        protected Optional<TomeData> buildContent(DataView container) throws InvalidDataException {
            return create().from(container);
        }

    }
}
