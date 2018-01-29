package org.dclar.e2h.processor.impl;

import org.dclar.e2h.core.ex.Executor;
import org.dclar.e2h.core.preEx.PreExecutor;
import org.dclar.e2h.entity.RawTable;
import org.dclar.e2h.entity.Result;
import org.dclar.e2h.processor.Processor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class ProcessorImpl implements Processor {

    @Autowired
    PreExecutor preExecutor;

    @Autowired
    Executor defaultExecutorImpl;


    /**
     * 利用Excel文件路径开始解析
     *
     * @param path Excel的路径
     */
    @Override
    public void  startProcessByPath(String path, String covertFormat) throws Exception {

        File file = new File(path);

        Workbook book = new XSSFWorkbook(file);

        RawTable rawTable = preExecutor.execute(book);

        Result result = defaultExecutorImpl.execute(rawTable);

    }
}
