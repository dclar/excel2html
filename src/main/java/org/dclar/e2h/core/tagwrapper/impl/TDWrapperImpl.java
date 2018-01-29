package org.dclar.e2h.core.tagwrapper.impl;

import org.dclar.e2h.core.tagwrapper.AbstractColRowSpanWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * TD标签的包装类
 *
 * @author darcula
 */
@Service("tDWrapperImpl")
public class TDWrapperImpl extends AbstractColRowSpanWrapper {

    Logger log = LoggerFactory.getLogger(TDWrapperImpl.class);

}
