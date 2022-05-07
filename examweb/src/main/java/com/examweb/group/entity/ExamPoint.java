package com.examweb.group.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Jessiecaicai
 * @Description:
 * @Date:Created in 2018/7/3
 */
@Data
@NoArgsConstructor
public class ExamPoint extends Model<ExamPoint> {
    private String id;
    private String province;
    private String examPointName;
    @JsonIgnore
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date updateTime;
    @JsonIgnore
    private String  isDelete;

    @Override
    public String toString() {
        return "ExamPoint{" +
                "id='" + id + '\'' +
                ", province='" + province + '\'' +
                ", examPointName='" + examPointName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete='" + isDelete + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getExamPointName() {
        return examPointName;
    }

    public void setExamPointName(String examPointName) {
        this.examPointName = examPointName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }


}
