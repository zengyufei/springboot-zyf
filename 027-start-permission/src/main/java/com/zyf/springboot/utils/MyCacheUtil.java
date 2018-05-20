package com.zyf.springboot.utils;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.FIFOCache;

public class MyCacheUtil {

    public static FIFOCache getCache() {
        return MyCache.Single.fifoCache;
    }

    private enum MyCache {

        Single;

        private FIFOCache fifoCache;

        MyCache() {
            this.fifoCache = CacheUtil.newFIFOCache(10);
        }

    }
}
