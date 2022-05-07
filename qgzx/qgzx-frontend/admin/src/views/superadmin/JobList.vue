<template>
  <div class="home">
    <el-table :data="jobTable" fit>
      <el-table-column prop="name" label="职位"> </el-table-column>
      <el-table-column prop="hireNum" label="招聘人数"> </el-table-column>
      <el-table-column prop="pay" label="薪酬"> </el-table-column>
      <el-table-column prop="workplace" label="工作地点"> </el-table-column>
      <el-table-column prop="deadline" label="截止日期"> </el-table-column>
      <el-table-column prop="updateTime" label="更新日期"> <template v-slot="{row}">
        {{formatTime(row.updateTime)}}
      </template></el-table-column>
      <el-table-column label="操作" width="240">
        <template #default="scope">
          <el-button
            @click="editJob(scope.$index, scope.row)"
            type="primary"
            size="small"
            >查看</el-button
          >
          <el-button type="danger" @click="deletejob(scope.row)" size="small"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>

    <div style="margin-top: 30px">
      <el-pagination
        background
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[10, 20, 30, 40]"
        :page-size="pageSize"
        layout="prev, pager, next, jumper, total"
        :total="total"
      ></el-pagination>
    </div>
  </div>
</template>

<script>
import { deleteJobById, getAllJobs, getPageJobs } from "@/utils/apis/jobs";
import dayjs from "dayjs";

export default {
  data() {
    return {
      jobTable: [],
      pageNum: 1,
      fit: true,
      currentPage: 1,
      total: 10,
      pageSize: 4,
      showjobInfo: false,
      jobInfo: { address: "", province: "", name: "" },
    };
  },
  methods: {
    formatTime(val){
      return dayjs(val).format("YYYY-MM-DD HH:mm:ss")
    },
    handleCurrentChange(val) {
      this.currentPage = val;
      this.getjobList();
      console.log(`当前页: ${val}`);
    },
    getjobList() {
      getPageJobs({ pageNum: this.currentPage, pageSize: this.pageSize }).then(
        (data) => {
          this.jobTable = data.data.list;
          this.total=data.data.totalPage
        }
      );
    },
    editJob(index, row) {
      this.$router.push(`/job/edit/${row.id}`);
    },

    deletejob(row) {
      deleteJobById(row.id).then((data) => {
        if (data.success) {
          this.$message.success({ message: data.msg });
          this.getjobList();
        }
      });
    },
    submitjobInfo() {
      this.$http.put("/job/update", this.jobInfo).then((res) => {
        this.$message.success({ message: "更新成功" });
        this.showjobInfo = false;
      });
    },
  },
  mounted() {
    this.getjobList();
  },
};
</script>
