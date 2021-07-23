package koptional;

import java.util.Optional;
import java.util.function.Consumer;

public class KOptional<T> extends StandardOptionalWrapper<T>{

    private final Optional<T> value;

    @Override
    protected Optional<T> getValue() {
        return this.value;
    }

    private KOptional(T value) {
        this.value = Optional.ofNullable(value);
    }

    public static<T> KOptional<T> empty() {
        return new KOptional<>(null);
    }

    public static <T> KOptional<T> of(T value) {
        return new KOptional<>(value);
    }

    public KOptional<T> ifHasSomething(Consumer<? super T> action) {
        value.ifPresent(action::accept);
        return this;
    }

    public KOptional<T> ifHasNothing(Runnable action) {
        if (value.isEmpty()) {
            action.run();
        }
        return this;
    }
}
