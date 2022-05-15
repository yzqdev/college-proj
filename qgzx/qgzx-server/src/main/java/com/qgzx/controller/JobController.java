package com.qgzx.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qgzx.dto.PageResult;
import com.qgzx.dto.Result;
import com.qgzx.entity.Admin;
import com.qgzx.entity.Job;
import com.qgzx.service.JobService;
import com.qgzx.mapper.JobMapper;
import com.qgzx.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author yanni
 */
@RestController

public class JobController {
    @Resource
    private JobService jobService;
    @Resource
    private JobMapper jobMapper;

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public Result addJob(@RequestBody Job job, HttpSession session) {
        Admin user = (Admin) session.getAttribute("admin");

        //if (user == null) {
        //    return new Result<>(false, "您还没有登陆", null);
        //}
        System.out.println(job.getHireNum());
        System.out.println("到达这里");
        job.setCreateTime(new Timestamp(System.currentTimeMillis()));
        job.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        boolean bool = false;

        try {

            bool = jobService.save(job);
            return ResultUtil.success("添加成功", job);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return ResultUtil.fail("未知错误");


    }

    @GetMapping("/getJobMyPage")
    public Result getMyJobPage(long pageNum,long pageSize) {

        try {
            PageResult<Job> pageResult=new PageResult<>();
            QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("update_time");
            Page<Job> page = new Page<>(pageNum, pageSize);
            IPage<Job> ipage = jobMapper.selectPage(page, queryWrapper);
            pageResult.setPageNumber(Math.toIntExact(ipage.getCurrent()));
            pageResult.setPageSize(Math.toIntExact(ipage.getSize()));
            pageResult.setTotalPage(Math.toIntExact(ipage.getTotal()));
            pageResult.setList(ipage.getRecords());

            System.out.println(ResultUtil.success(pageResult));
            return ResultUtil.success(pageResult);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @GetMapping("/getJobIPage")
    public Result getJobPage(long pageNum, long pageSize) {
        try {

            QueryWrapper<Job> queryWrapper = new QueryWrapper<>();
            queryWrapper.orderByDesc("id");
            Page<Job> page = new Page<>(pageNum, pageSize);
            IPage<Job> ipage = jobMapper.selectPage(page, queryWrapper);
            return ResultUtil.success(ipage);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(value = "/getAllJobs", method = RequestMethod.GET)
    public Result getAllJobs() {
        try {
            List<Job> list = jobMapper.getAllJobs();

            return ResultUtil.success("获取成功", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

    @RequestMapping(value = "/deleteJob/{id}", method = RequestMethod.DELETE)

    public Result deleteJob(@PathVariable("id") String id, HttpSession session) {
        Boolean bool = false;
        try {
            bool = jobService.removeById(id);
            if (!bool) {
                return ResultUtil.fail("删除失败");
            }
            return ResultUtil.success("删除成功", bool);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Result<>(true, "失败了", null);
    }

    @RequestMapping(value = "/updateJob", method = RequestMethod.PUT)
    public Result<String> updateJob(@RequestBody Job job, HttpSession session) {
        //User user = (User) session.getAttribute("user");
        //if (user == null) {
        //    return new Result<>(false, "您还没有登陆", null);
        //}
        job.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        boolean bool = false;
        try {
            bool = jobService.updateById(job);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!bool) {
            ResultUtil.fail("失败了");
        }
        return new Result<>(true, "更新成功", null);
    }

    @RequestMapping(value = "/getJobById/{id}", method = RequestMethod.GET)
    public Result getJobById(@PathVariable("id") String id) {
        try {
            Job job = jobService.getJobById(id);
            return ResultUtil.success("成功了", job);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.fail("失败了");
    }

}
