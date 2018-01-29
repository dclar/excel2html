package org.dclar.e2h.core.tag.tagEntity;

import org.dclar.e2h.Const;
import org.dclar.e2h.core.tag.AbstractColRowSpanTag;

public class TD extends AbstractColRowSpanTag {

    private String name = Const.HTML_TAG_TD;

    /**
     * 获得Tag的名称，如td,tr
     *
     * @return Tag名称
     */
    @Override
    public String getTagName() {
        return name;
    }

    public static TD get() {
        return new TD();
    }




}
