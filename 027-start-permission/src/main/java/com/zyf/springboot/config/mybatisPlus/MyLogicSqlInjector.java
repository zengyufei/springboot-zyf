package com.zyf.springboot.config.mybatisPlus;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.entity.TableFieldInfo;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.apache.ibatis.mapping.SqlSource;

import java.util.List;

/**
 * 自定义处理器
 * @author zengyufei
 * @since 1.0.0
 */
public class MyLogicSqlInjector extends LogicSqlInjector {

    @Override
    protected String sqlWhere(TableInfo table) {
        if (table.isLogicDelete()) {
            StringBuilder where = new StringBuilder("\n<where>");
            // 过滤逻辑
            List<TableFieldInfo> fieldList = table.getFieldList();
            // EW 逻辑
            if (StringUtils.isNotEmpty(table.getKeyProperty())) {
                where.append("\n<if test=\"ew.")
                        .append(table.getKeyProperty())
                        .append("!=null and ew.")
                        .append(table.getKeyProperty())
                        .append(">0\">\n");
                where.append(" AND ").append(table.getKeyColumn()).append("=#{ew.");
                where.append(table.getKeyProperty()).append("}");
                where.append("</if>");
            }
            for (TableFieldInfo fieldInfo : fieldList) {
                where.append(convertIfTag(fieldInfo, "ew.", false));
                where.append(" AND ").append(this.sqlCondition(fieldInfo.getCondition(),
                        fieldInfo.getColumn(), "ew." + fieldInfo.getEl()));
                where.append(convertIfTag(fieldInfo, true));
            }
            // 过滤逻辑
            where.append("\n").append(getLogicDeleteSql(table));
            where.append("\n</where>");
            return where.toString();
        }
        // 正常逻辑
        else {
            StringBuilder where = new StringBuilder();
            where.append("\n<where>");
            if (StringUtils.isNotEmpty(table.getKeyProperty())) {
                where.append("\n<if test=\"ew.")
                        .append(table.getKeyProperty())
                        .append("!=null and ew.")
                        .append(table.getKeyProperty())
                        .append(">0\">\n");
                where.append(table.getKeyColumn()).append("=#{ew.").append(table.getKeyProperty()).append("}");
                where.append("\n</if>");
            }
            List<TableFieldInfo> fieldList = table.getFieldList();
            for (TableFieldInfo fieldInfo : fieldList) {
                where.append(convertIfTag(fieldInfo, "ew.", false));
                where.append(" AND ").append(this.sqlCondition(fieldInfo.getCondition(),
                        fieldInfo.getColumn(), "ew." + fieldInfo.getEl()));
                where.append(convertIfTag(fieldInfo, true));
            }
            where.append("\n</where>");
            return where.toString();
        }
    }

    @Override
    protected String sqlWhereEntityWrapper(TableInfo table) {
        if (table.isLogicDelete()) {
            StringBuilder where = new StringBuilder(128);
            where.append("\n<where>");
            where.append("\n<choose><when test=\"ew!=null\">");
            where.append("\n<if test=\"ew.entity!=null\">");
            if (StringUtils.isNotEmpty(table.getKeyProperty())) {
                where.append("\n<if test=\"ew.entity.")
                        .append(table.getKeyProperty())
                        .append("!=null and ew.entity.")
                        .append(table.getKeyProperty())
                        .append(">0\">");
                where.append(" AND ").append(table.getKeyColumn()).append("=#{ew.entity.");
                where.append(table.getKeyProperty()).append("}");
                where.append("</if>");
            }
            List<TableFieldInfo> fieldList = table.getFieldList();
            for (TableFieldInfo fieldInfo : fieldList) {
                where.append(convertIfTag(fieldInfo, "ew.entity.", false));
                where.append(" AND ").append(this.sqlCondition(fieldInfo.getCondition(),
                        fieldInfo.getColumn(), "ew.entity." + fieldInfo.getEl()));
                where.append(convertIfTag(fieldInfo, true));
            }
            where.append("\n</if>");
            where.append("\n").append(getLogicDeleteSql(table));
            where.append("\n<if test=\"ew.sqlSegment!=null\">${ew.sqlSegment}\n</if>");
            where.append("\n</when><otherwise>");
            where.append("\n").append(getLogicDeleteSql(table));
            where.append("\n</otherwise></choose>");
            where.append("\n</where>");
            return where.toString();
        }
        // 正常逻辑
        StringBuilder where = new StringBuilder(128);
        where.append("\n<where>");
        where.append("\n<if test=\"ew!=null\">");
        where.append("\n<if test=\"ew.entity!=null\">");
        if (StringUtils.isNotEmpty(table.getKeyProperty())) {
            where.append("\n<if test=\"ew.entity.")
                    .append(table.getKeyProperty())
                    .append("!=null and ew.entity.")
                    .append(table.getKeyProperty()).append(">0 \">\n");
            where.append(table.getKeyColumn()).append("=#{ew.entity.").append(table.getKeyProperty()).append("}");
            where.append("\n</if>");
        }
        List<TableFieldInfo> fieldList = table.getFieldList();
        for (TableFieldInfo fieldInfo : fieldList) {
            where.append(convertIfTag(fieldInfo, "ew.entity.", false));
            where.append(" AND ").append(this.sqlCondition(fieldInfo.getCondition(),
                    fieldInfo.getColumn(), "ew.entity." + fieldInfo.getEl()));
            where.append(convertIfTag(fieldInfo, true));
        }
        where.append("\n</if>");
        where.append("\n<if test=\"ew!=null and ew.sqlSegment!=null and ew.notEmptyOfWhere\">\n${ew.sqlSegment}\n</if>");
        where.append("\n</if>");
        where.append("\n</where>");
        where.append("\n<if test=\"ew!=null and ew.sqlSegment!=null and ew.emptyOfWhere\">\n${ew.sqlSegment}\n</if>");
        return where.toString();
    }

    @Override
    protected String convertIfTag(boolean ignored, TableFieldInfo fieldInfo, String prefix, boolean close) {
        /* 忽略策略 */
        FieldStrategy fieldStrategy = fieldInfo.getFieldStrategy();
        if (fieldStrategy == FieldStrategy.IGNORED) {
            if (ignored) {
                return "";
            }
            // 查询策略，使用全局策略
            fieldStrategy = this.getGlobalConfig().getFieldStrategy();
        }

        // 关闭标签
        if (close) {
            return "</if>";
        }

        /* 前缀处理 */
        String property = fieldInfo.getProperty();
        Class propertyType = fieldInfo.getPropertyType();
        property = StringUtils.removeIsPrefixIfBoolean(property, propertyType);
        if (null != prefix) {
            property = prefix + property;
        }
        // 验证逻辑
        if (fieldStrategy == FieldStrategy.NOT_EMPTY) {
            if (StringUtils.isCharSequence(propertyType)) {
                return String.format("%n\t<if test=\"%s!=null and %s!=''\">", property, property);
            } else {
                boolean isIdEndWith = StrUtil.endWithIgnoreCase(property, "id");
                boolean primitive = propertyType.isPrimitive();
                boolean assignableFrom = ClassUtil.isAssignable(Number.class, propertyType);
                boolean isNotPrimitiveWrapper = !ClassUtil.isPrimitiveWrapper(propertyType);
                if (primitive && assignableFrom && isIdEndWith && isNotPrimitiveWrapper) {
                    return String.format("%n\t<if test=\"%s!=null and %s > 0 \">", property, property);
                } else {
                    return String.format("%n\t<if test=\"%s!=null \">", property);
                }

            }
        } else {
            // FieldStrategy.NOT_NULL
            return String.format("%n\t<if test=\"%s!=null\">", property);
        }
    }


    /**
     * <p>
     * 注入EntityWrapper方式查询记录列表 SQL 语句
     * </p>
     * @param sqlMethod
     * @param mapperClass
     * @param modelClass
     * @param table
     */
    @Override
    protected void injectSelectListSql(SqlMethod sqlMethod, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        String sql1 = sqlMethod.getSql();
        String s = sqlSelectColumns(table, true);
        String tableName = table.getTableName();
        String s1 = sqlWhereEntityWrapper(table);
        String sql = String.format(sql1, s, tableName, s1);
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, modelClass);
        this.addSelectMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource, modelClass, table);
    }

}
