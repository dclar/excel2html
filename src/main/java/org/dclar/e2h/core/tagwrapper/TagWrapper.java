package org.dclar.e2h.core.tagwrapper;


import org.dclar.e2h.core.tag.Tag;

public interface TagWrapper<T> {

    /**
     * 对Tag进行包装处理的类
     *
     * @param t    传入包装处理的范型数据
     * @param tag  Tag
     * @return     作为参数传入的Tag
     */
    Tag wrap(T t, Tag tag);
}
