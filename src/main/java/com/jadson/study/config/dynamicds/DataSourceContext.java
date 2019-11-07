package com.jadson.study.config.dynamicds;

/**
 * 声明类来保存当前使用
 */
public class DataSourceContext {
    private static final ThreadLocal<String> DATA_SOURCE = new ThreadLocal<>();

    public static String getDataSource() {
        return DATA_SOURCE.get();
    }

    public static void setDataSource(String dataSource) {
        DATA_SOURCE.set(dataSource);
    }

    public static void clear() {
        DATA_SOURCE.remove();
    }
}
