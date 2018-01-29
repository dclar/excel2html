package org.dclar.e2h.core.writer;

import org.dclar.e2h.entity.Bulk;

public interface Writer {

    void write(Bulk bulk);

    void writeLn(Bulk bulk);
}
