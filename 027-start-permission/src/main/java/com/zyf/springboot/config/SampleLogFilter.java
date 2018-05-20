package com.zyf.springboot.config;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import cn.hutool.core.util.StrUtil;

public class SampleLogFilter extends Filter<ILoggingEvent> {

    @Override
    public FilterReply decide(ILoggingEvent event) {
        CharSequence[] charSequences = {"OPTIONS request", "ModelAndView", "Last-Modified", "Enabling autowire", "Skipped (empty)", "Loading source class"};
        if (StrUtil.containsAnyIgnoreCase(event.getMessage(), charSequences)) {
            return FilterReply.DENY;
        } else {
            return FilterReply.ACCEPT;
        }
    }
}