/*
 Navicat Premium Data Transfer

 Source Server         : localpg
 Source Server Type    : PostgreSQL
 Source Server Version : 140002
 Source Host           : localhost:5432
 Source Catalog        : examweb
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140002
 File Encoding         : 65001

 Date: 15/05/2022 22:32:53
*/


-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS "public"."account";
CREATE TABLE "public"."account" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "phone" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "certificate_style" varchar(4) COLLATE "pg_catalog"."default" NOT NULL,
  "certificate_number" varchar(40) COLLATE "pg_catalog"."default",
  "account_style" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO "public"."account" VALUES ('2830cefa8c194f99abd4dbf78d98b083', 'admin23', '管理员电话', '管理员邮件', '123', '0', '管理员证件号码', '1', '2020-04-15 09:41:56', '2020-04-15 21:51:16', '0');
INSERT INTO "public"."account" VALUES ('a0b3b3b1bf564b92ae7efc429005d4f2', '1', '18856967709', '1111@qq.com', '123456', '0', '411328199802060699', '0', '2020-08-04 13:28:13', '2020-08-04 13:28:13', '0');
INSERT INTO "public"."account" VALUES ('c95525efd41a4902a655f2ca216c5873', '1111', '管理员电话', '管理员邮件', '111111', '0', '管理员证件号码', '1', '2020-04-15 10:15:06', '2020-04-15 10:15:06', '0');

-- ----------------------------
-- Table structure for examinee
-- ----------------------------
DROP TABLE IF EXISTS "public"."examinee";
CREATE TABLE "public"."examinee" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "exam_way" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "zhaosheng_unit" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "special_plan" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "name_spell" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "now_solier" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "nation" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "sex" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "marriage" varchar(4) COLLATE "pg_catalog"."default" NOT NULL,
  "policy" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "connect_address" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "connect_postalcode" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "native_place" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "hukou_place" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "hukou_detail" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "birth_place" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "now_study_or_work_unit" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "file_place" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "file_unit_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "file_unit_address" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "file_unit_postalcode" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "certificate_style" varchar(4) COLLATE "pg_catalog"."default" NOT NULL,
  "certificate_number" varchar(60) COLLATE "pg_catalog"."default" NOT NULL,
  "reward_and_punishment" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "account_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "want_department_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "want_major_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "exam_subject" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "learn_way" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "research_way" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "exam_point_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "exam_point_address" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "is_check" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of examinee
-- ----------------------------

-- ----------------------------
-- Table structure for exampoint
-- ----------------------------
DROP TABLE IF EXISTS "public"."exampoint";
CREATE TABLE "public"."exampoint" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "province" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of exampoint
-- ----------------------------

-- ----------------------------
-- Table structure for examway
-- ----------------------------
DROP TABLE IF EXISTS "public"."examway";
CREATE TABLE "public"."examway" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of examway
-- ----------------------------

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS "public"."major";
CREATE TABLE "public"."major" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "subject_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of major
-- ----------------------------

-- ----------------------------
-- Table structure for major_school
-- ----------------------------
DROP TABLE IF EXISTS "public"."major_school";
CREATE TABLE "public"."major_school" (
  "major_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "school_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "department" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "exam_subject" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "learn_way" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of major_school
-- ----------------------------

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS "public"."school";
CREATE TABLE "public"."school" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "address" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "province" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "account_id" varchar(64) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO "public"."school" VALUES ('1250462737984528385', '撒地', '嗯嗯嗯实打实大幅度', '呃呃二撒地方', '2020-04-16 09:40:07', '2020-04-16 00:35:00', '0', '无绑定');
INSERT INTO "public"."school" VALUES ('23', '河南省南阳市', '河南', '郑州大学', '2020-04-15 17:33:33', '2020-04-15 00:00:00', '0', 'c95525efd41a4902a655f2ca216c5873');
INSERT INTO "public"."school" VALUES ('232', '北京', '北京', '清华大学', '2020-04-15 17:33:38', '2020-04-15 00:00:00', '0', '2830cefa8c194f99abd4dbf78d98b083');

-- ----------------------------
-- Table structure for specialplan
-- ----------------------------
DROP TABLE IF EXISTS "public"."specialplan";
CREATE TABLE "public"."specialplan" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of specialplan
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS "public"."subject";
CREATE TABLE "public"."subject" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "menLei" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for subject_school
-- ----------------------------
DROP TABLE IF EXISTS "public"."subject_school";
CREATE TABLE "public"."subject_school" (
  "subject_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "school_id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "learn_way" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL,
  "province" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "school_name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of subject_school
-- ----------------------------

-- ----------------------------
-- Table structure for time_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."time_info";
CREATE TABLE "public"."time_info" (
  "id" varchar(64) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "content" timestamp(6) NOT NULL,
  "create_time" timestamp(6) NOT NULL,
  "update_time" timestamp(6) NOT NULL,
  "is_delete" varchar(2) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of time_info
-- ----------------------------
INSERT INTO "public"."time_info" VALUES ('1', '到达', '2020-04-01 00:00:00', '2020-04-15 19:34:21', '2020-04-15 19:34:18', '0');
INSERT INTO "public"."time_info" VALUES ('2', '到达2', '2020-04-02 00:00:00', '2020-04-15 19:34:25', '2020-04-21 19:34:22', '0');
INSERT INTO "public"."time_info" VALUES ('3', '到达3', '2020-04-03 00:00:00', '2020-04-15 19:34:29', '2020-04-14 19:34:26', '0');
INSERT INTO "public"."time_info" VALUES ('4', '到达4', '2020-04-04 00:00:00', '2020-04-15 19:34:32', '2020-04-15 19:34:30', '0');
INSERT INTO "public"."time_info" VALUES ('5', '到达5', '2020-04-05 00:00:00', '2020-04-15 19:34:36', '2020-04-15 19:34:34', '0');
INSERT INTO "public"."time_info" VALUES ('6', '到达6', '2020-04-15 19:34:39', '2020-04-15 19:34:39', '2020-04-15 19:34:36', '0');

-- ----------------------------
-- Primary Key structure for table account
-- ----------------------------
ALTER TABLE "public"."account" ADD CONSTRAINT "account_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table examinee
-- ----------------------------
ALTER TABLE "public"."examinee" ADD CONSTRAINT "examinee_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table exampoint
-- ----------------------------
ALTER TABLE "public"."exampoint" ADD CONSTRAINT "exampoint_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table examway
-- ----------------------------
ALTER TABLE "public"."examway" ADD CONSTRAINT "examway_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table major
-- ----------------------------
ALTER TABLE "public"."major" ADD CONSTRAINT "major_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table major_school
-- ----------------------------
ALTER TABLE "public"."major_school" ADD CONSTRAINT "major_school_pkey" PRIMARY KEY ("major_id", "school_id");

-- ----------------------------
-- Primary Key structure for table school
-- ----------------------------
ALTER TABLE "public"."school" ADD CONSTRAINT "school_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table specialplan
-- ----------------------------
ALTER TABLE "public"."specialplan" ADD CONSTRAINT "specialplan_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table subject
-- ----------------------------
ALTER TABLE "public"."subject" ADD CONSTRAINT "subject_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table subject_school
-- ----------------------------
ALTER TABLE "public"."subject_school" ADD CONSTRAINT "subject_school_pkey" PRIMARY KEY ("subject_id", "school_id");

-- ----------------------------
-- Primary Key structure for table time_info
-- ----------------------------
ALTER TABLE "public"."time_info" ADD CONSTRAINT "time_info_pkey" PRIMARY KEY ("id");
