package org.dclar.e2h;

import org.dclar.e2h.entity.Rule;
import org.dclar.e2h.processor.Processor;
import org.dclar.e2h.tookit.C;


/**
 * excel2html的主执行class
 *
 * @author darcula
 */

public class Start {

    public static void main(String[] args) throws Exception {

        // File
        String filePath = "/Users/yl/Downloads/write (10).xlsx";

        // 获得Context
        C c = C.get();

        // 规则一览
        // TODO
        Rule rule = new Rule();

        // 流程执行器
        Processor processor = c.g(Processor.class);

        // 开始
        processor.startProcessByPath(filePath, "");

        c.d();

    }
}
