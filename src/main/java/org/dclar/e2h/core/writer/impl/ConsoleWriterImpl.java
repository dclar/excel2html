package org.dclar.e2h.core.writer.impl;

import org.dclar.e2h.core.writer.Writer;
import org.dclar.e2h.entity.Bulk;
import org.springframework.stereotype.Service;

@Service
public class ConsoleWriterImpl implements Writer {

    @Override
    public void write(Bulk bulk) {

        System.out.print(bulk.getOutput());

    }

    @Override
    public void writeLn(Bulk bulk) {

        System.out.println(bulk.getOutput());

    }
}
