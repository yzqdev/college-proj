/*
 Navicat Premium Data Transfer

 Source Server         : localpg
 Source Server Type    : PostgreSQL
 Source Server Version : 140002
 Source Host           : localhost:5432
 Source Catalog        : qgzx
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 140002
 File Encoding         : 65001

 Date: 15/05/2022 22:29:43
*/


-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin";
CREATE TABLE "public"."admin" (
  "user_code" varchar(244) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "pass" varchar(255) COLLATE "pg_catalog"."default",
  "isSuper" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO "public"."admin" VALUES ('b6201f83b8ae7fc32c85b0e5ea209dd1', 'admin', '123', '0');

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS "public"."job";
CREATE TABLE "public"."job" (
  "id" int4 NOT NULL,
  "name" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "time" timestamp(6),
  "title" varchar(25) COLLATE "pg_catalog"."default",
  "type" varchar(25) COLLATE "pg_catalog"."default",
  "location" varchar(25) COLLATE "pg_catalog"."default",
  "worktime" varchar(25) COLLATE "pg_catalog"."default",
  "workplace" varchar(255) COLLATE "pg_catalog"."default",
  "pay" varchar(255) COLLATE "pg_catalog"."default",
  "hireNum" int4,
  "deadline" varchar(255) COLLATE "pg_catalog"."default",
  "sex" varchar(255) COLLATE "pg_catalog"."default",
  "content" varchar(255) COLLATE "pg_catalog"."default",
  "create_time" timestamp(6),
  "update_time" timestamp(6)
)
;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO "public"."job" VALUES (22, '这是名12', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 19:50:22', '2021-08-17 19:50:22');
INSERT INTO "public"."job" VALUES (23, '这是名1212', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 19:50:29', '2021-08-17 19:50:29');
INSERT INTO "public"."job" VALUES (24, '这是名字222', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 19:50:34', '2021-08-17 19:50:34');
INSERT INTO "public"."job" VALUES (25, '这是名字3333', '2021-08-17 00:00:00', '这是标题afsfds', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 19:50:37', '2021-08-17 20:47:04');
INSERT INTO "public"."job" VALUES (26, '这是名字4', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 19:50:41', '2021-08-17 19:50:41');
INSERT INTO "public"."job" VALUES (27, '这是名字33', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:34:12', '2021-08-17 20:34:12');
INSERT INTO "public"."job" VALUES (28, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:19', '2021-08-17 20:49:19');
INSERT INTO "public"."job" VALUES (29, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:19', '2021-08-17 20:49:19');
INSERT INTO "public"."job" VALUES (30, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:19', '2021-08-17 20:49:19');
INSERT INTO "public"."job" VALUES (31, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:20', '2021-08-17 20:49:20');
INSERT INTO "public"."job" VALUES (32, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:20', '2021-08-17 20:49:20');
INSERT INTO "public"."job" VALUES (33, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:21', '2021-08-17 20:49:21');
INSERT INTO "public"."job" VALUES (34, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:21', '2021-08-17 20:49:21');
INSERT INTO "public"."job" VALUES (35, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:21', '2021-08-17 20:49:21');
INSERT INTO "public"."job" VALUES (36, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:22', '2021-08-17 20:49:22');
INSERT INTO "public"."job" VALUES (37, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:22', '2021-08-17 20:49:22');
INSERT INTO "public"."job" VALUES (38, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:22', '2021-08-17 20:49:22');
INSERT INTO "public"."job" VALUES (39, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:23', '2021-08-17 20:49:23');
INSERT INTO "public"."job" VALUES (40, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:23', '2021-08-17 20:49:23');
INSERT INTO "public"."job" VALUES (41, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:23', '2021-08-17 20:49:23');
INSERT INTO "public"."job" VALUES (42, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:24', '2021-08-17 20:49:24');
INSERT INTO "public"."job" VALUES (43, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:24', '2021-08-17 20:49:24');
INSERT INTO "public"."job" VALUES (44, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:24', '2021-08-17 20:49:24');
INSERT INTO "public"."job" VALUES (45, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:24', '2021-08-17 20:49:24');
INSERT INTO "public"."job" VALUES (46, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:25', '2021-08-17 20:49:25');
INSERT INTO "public"."job" VALUES (47, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:25', '2021-08-17 20:49:25');
INSERT INTO "public"."job" VALUES (48, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:25', '2021-08-17 20:49:25');
INSERT INTO "public"."job" VALUES (49, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:26', '2021-08-17 20:49:26');
INSERT INTO "public"."job" VALUES (50, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:26', '2021-08-17 20:49:26');
INSERT INTO "public"."job" VALUES (51, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:26', '2021-08-17 20:49:26');
INSERT INTO "public"."job" VALUES (52, '这是名字', '2021-08-17 00:00:00', '这是标题123', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:27', '2021-08-17 21:09:33');
INSERT INTO "public"."job" VALUES (53, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:27', '2021-08-17 20:49:27');
INSERT INTO "public"."job" VALUES (54, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:27', '2021-08-17 20:49:27');
INSERT INTO "public"."job" VALUES (55, '这是名字123', '2021-08-17 00:00:00', '这是标题123', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34556, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:27', '2021-08-17 21:11:11');
INSERT INTO "public"."job" VALUES (56, '这是名字', '2021-08-17 00:00:00', '这是标题ss', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:28', '2021-08-17 21:08:13');
INSERT INTO "public"."job" VALUES (57, '这是名字', '2021-08-17 00:00:00', '这是标题', '1', '地址', '工作室就', '啊啊啊', '啊啊啊', 34, '2021-08-17', '1', '这是工作内容', '2021-08-17 20:49:28', '2021-08-17 20:49:28');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS "public"."notice";
CREATE TABLE "public"."notice" (
  "id" varchar(30) COLLATE "pg_catalog"."default" NOT NULL,
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "sub_title" varchar(255) COLLATE "pg_catalog"."default",
  "content" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO "public"."notice" VALUES ('1414047648373133313', '这是标题', '这是副标题', '这是正文122');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "id" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "userName" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "password" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "phoneNumber" varchar(11) COLLATE "pg_catalog"."default" NOT NULL,
  "qq" varchar(15) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" VALUES ('123', '123', 'qgzx123456', '123', '123');

-- ----------------------------
-- Primary Key structure for table admin
-- ----------------------------
ALTER TABLE "public"."admin" ADD CONSTRAINT "admin_pkey" PRIMARY KEY ("user_code");

-- ----------------------------
-- Primary Key structure for table job
-- ----------------------------
ALTER TABLE "public"."job" ADD CONSTRAINT "job_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table notice
-- ----------------------------
ALTER TABLE "public"."notice" ADD CONSTRAINT "notice_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("id");
