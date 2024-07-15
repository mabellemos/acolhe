package io.github.mabellemos.acolheapi.core.interfaces.repositories;

import java.util.List;

public interface Manageable {
    void registration();
    List<?> display ();
    void alter();
    void delete();
}
