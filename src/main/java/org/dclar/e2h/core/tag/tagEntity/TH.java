package org.dclar.e2h.core.tag.tagEntity;

import org.dclar.e2h.Const;
import org.dclar.e2h.core.tag.AbstractColRowSpanTag;

public class TH extends AbstractColRowSpanTag {

    private String name = Const.HTML_TAG_TH;

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return this.name;
    }

    public static TH get() {
        return new TH();
    }
}
