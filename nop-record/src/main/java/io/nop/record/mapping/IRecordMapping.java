package io.nop.record.mapping;

/**
 * 结构体映射规则，将一个source对象上的属性映射到target对象上
 */
public interface IRecordMapping {
    /**
     * 执行记录字段映射操作
     *
     * @param source 包含源数据的记录对象
     * @param target 接收映射结果的目标记录对象
     * @throws IllegalArgumentException 当任一参数为null时抛出
     */
    void map(Object source, Object target, RecordMappingContext ctx);
}