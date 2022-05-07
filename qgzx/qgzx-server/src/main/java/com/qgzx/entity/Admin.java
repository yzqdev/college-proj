package com.qgzx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yzq
 * @since 2020-04-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@TableName(value = "admin")
public class Admin extends Model<Admin> implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "user_code", type = IdType.ASSIGN_UUID)
    private String userCode;

    private String name;

    private String pass;
    @TableField("isSuper")
    private String isSuper;
}
