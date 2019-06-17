package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * class1表对应的实体类，用于保存表中一行一级类别信息
 * @author hp
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Class1 {
	/**
	 * 一级类别编号
	 */
    private Integer class1Id;
    /**
     * 一级类别名称
     */

    private String class1Name;
    /**
     * 一级类别数量
     */

    private Integer class1Num;
    /**
     * 一级类别备注
     */

    private String remark;
}