package com.hfut.glxy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.hfut.glxy.entity.Inform;

/**
 * @author chenliangliang
 * @date: 2017/11/27
 */

public interface InformService extends IService<Inform> {




    PageInfo<Inform> listAll(int pageNum, String cid);

   Inform findById(Integer id);

}
