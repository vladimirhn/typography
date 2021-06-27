package kpersistence;

import java.util.List;

public interface KChangeListener<T> {
    void updateState(List<T> entries);
}
