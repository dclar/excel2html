package org.dclar.e2h.core.ex.impl;


import org.dclar.e2h.Const;
import org.dclar.e2h.core.ex.AbstractExecutor;
import org.dclar.e2h.core.ex.Executor;
import org.dclar.e2h.core.ex.toolkit.ExecutorHelper;
import org.dclar.e2h.core.tag.Tag;
import org.dclar.e2h.core.tag.tagEntity.TABLE;
import org.dclar.e2h.core.tag.tagEntity.TD;
import org.dclar.e2h.core.tag.tagEntity.TH;
import org.dclar.e2h.core.tag.tagEntity.TR;
import org.dclar.e2h.core.tagwrapper.TagWrapper;
import org.dclar.e2h.core.writer.Writer;
import org.dclar.e2h.core.writer.tookit.WriterHelper;
import org.dclar.e2h.entity.Bulk;
import org.dclar.e2h.tookit.Excel2html;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultExecutorImpl extends AbstractExecutor implements Executor {


    Logger logger = LoggerFactory.getLogger(DefaultExecutorImpl.class);

    @Autowired
    Writer consoleWriterImpl;

    @Autowired
    TagWrapper tDWrapperImpl;

    @Autowired
    TagWrapper tHWrapperImpl;

    public boolean begin(Bulk b) {

        // 输出<table>
        writeLn(b, " ".concat(TABLE.get().drawStartHtml()));
        return true;
    }

    /**
     * 一行开始时的处理
     *
     * @param b
     * @return
     */
    @Override
    protected boolean beforeOneLine(Bulk b) {

        // 输出<tr>
        writeLn(b, WriterHelper.addTab(TR.get().drawStartHtml(), 1));
        return true;
    }

    /**
     * 一个cell开始时的处理
     *
     * @param b
     * @return
     */
    @Override
    protected boolean beforeLineStep(Bulk b) {

        // 输出<th> or <td>
        if (b.getRow() == 0) {

            return executeWrapper(TH.get(), b);
        } else {

            // 取得合并区域内容 使用wrapper进行包装
            return executeWrapper(TD.get(), b);
        }
    }

    private boolean executeWrapper(Tag tag, Bulk b) {

        Tag tagNew = tDWrapperImpl.wrap(ExecutorHelper.isMergedRegion(b), tag);

        if (tagNew.isHidden() == false) {
            write(b, WriterHelper.addTab(tagNew.drawStartHtml(), 2));
            return true;
        } else {
            return false;
        }

    }


    /**
     * 处理cell过程中
     *
     * @param b
     * @return
     */
    @Override
    protected boolean lineStepping(Bulk b) {

        String cellString = Excel2html.getValue(b.getCell());

        // 输出内容

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)
                || cellString.startsWith(Const.CONTENT_TASK_LISTS_OVER)) {
            System.out.println();
        }

        write(b, cellString.replace(".0", ""));

        if (cellString.startsWith(Const.CONTENT_TASK_LISTS)
                || cellString.startsWith(Const.CONTENT_TASK_LISTS_OVER)) {
            System.out.println();
            System.out.println();
        }
        return true;
    }

    /**
     * 一个cell处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean afterLineStep(Bulk b) {

        // 输出<th> or <td>
        if (b.getRow() == 0) {
            writeLn(b, TH.get().drawEndHtml());
        } else {
            writeLn(b, TD.get().drawEndHtml());
        }
        return true;
    }


    /**
     * 一行处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean afterOneLine(Bulk b) {

        // 输出</tr>
        writeLn(b, WriterHelper.addTab(TR.get().drawEndHtml(), 1));
        return true;
    }


    /**
     * 整个处理完毕
     *
     * @param b
     * @return
     */
    @Override
    protected boolean end(Bulk b) {

        // 输出</table>
        writeLn(b, TABLE.get().drawEndHtml());
        return true;
    }

    @Override
    protected Writer getWriter() {
        return this.consoleWriterImpl;
    }


}
