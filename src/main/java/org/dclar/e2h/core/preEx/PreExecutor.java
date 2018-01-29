package org.dclar.e2h.core.preEx;

import org.dclar.e2h.entity.RawTable;
import org.apache.poi.ss.usermodel.Workbook;

public interface PreExecutor {

    RawTable execute(Workbook workbook);
}
