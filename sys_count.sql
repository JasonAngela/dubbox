/*
Navicat PGSQL Data Transfer

Source Server         : postgres
Source Server Version : 100100
Source Host           : localhost:5432
Source Database       : platform
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 100100
File Encoding         : 65001

Date: 2018-01-09 16:39:41
*/


-- ----------------------------
-- Table structure for sys_count
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_count";
CREATE TABLE "public"."sys_count" (
"id" int8 DEFAULT nextval('sys_count_id_seq'::regclass) NOT NULL,
"province" varchar(50) COLLATE "default",
"city" varchar(50) COLLATE "default",
"area" varchar(50) COLLATE "default",
"category" varchar(50) COLLATE "default",
"sum" int8,
"level" int8,
"year" int2,
"type" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sys_count
-- ----------------------------

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_department";
CREATE TABLE "public"."sys_department" (
"id" varchar(36) COLLATE "default" NOT NULL,
"parent_id" varchar(36) COLLATE "default" NOT NULL,
"parent_ids" varchar(2000) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default" NOT NULL,
"type" char(1) COLLATE "default",
"address" varchar(255) COLLATE "default",
"enabled" bool DEFAULT true,
"remarks" varchar(255) COLLATE "default",
"create_date" date,
"update_date" date,
"del_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"master" varchar(100) COLLATE "default",
"primary_person" varchar(100) COLLATE "default",
"deputy_person" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_department"."parent_id" IS '父级ID';
COMMENT ON COLUMN "public"."sys_department"."type" IS '机构类型';
COMMENT ON COLUMN "public"."sys_department"."address" IS '地址';
COMMENT ON COLUMN "public"."sys_department"."del_flag" IS '删除标记
1：删除
0：未删除';
COMMENT ON COLUMN "public"."sys_department"."master" IS '负责人';
COMMENT ON COLUMN "public"."sys_department"."primary_person" IS '主要负责人';
COMMENT ON COLUMN "public"."sys_department"."deputy_person" IS '副主要负责人';

-- ----------------------------
-- Records of sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_menu";
CREATE TABLE "public"."sys_menu" (
"id" varchar(36) COLLATE "default" NOT NULL,
"parent_id" varchar(64) COLLATE "default" NOT NULL,
"parent_ids" varchar(2000) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default" NOT NULL,
"sort" numeric(10) NOT NULL,
"href" varchar(2000) COLLATE "default",
"icon" varchar(100) COLLATE "default",
"permission" varchar(200) COLLATE "default",
"remarks" varchar(255) COLLATE "default",
"create_date" date,
"update_date" date,
"del_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"is_show" bool DEFAULT true
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_menu"."parent_id" IS '父ID';
COMMENT ON COLUMN "public"."sys_menu"."parent_ids" IS '树ID';
COMMENT ON COLUMN "public"."sys_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "public"."sys_menu"."sort" IS '排序';
COMMENT ON COLUMN "public"."sys_menu"."href" IS '链接';
COMMENT ON COLUMN "public"."sys_menu"."icon" IS '图标s';
COMMENT ON COLUMN "public"."sys_menu"."permission" IS '权限标识';
COMMENT ON COLUMN "public"."sys_menu"."remarks" IS '备注';
COMMENT ON COLUMN "public"."sys_menu"."create_date" IS '创建时间';
COMMENT ON COLUMN "public"."sys_menu"."update_date" IS 'update_date';
COMMENT ON COLUMN "public"."sys_menu"."del_flag" IS '删除标记
1：删除
0：未删除';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO "public"."sys_menu" VALUES ('07fb63cf51d74e31b095d42b3dfb7686', '1caf32bb9f6f42e99b1d9413ebe84171', ',50223b0d0c014e848296f7580df517e7,1caf32bb9f6f42e99b1d9413ebe84171,', '修改', '20', null, null, 'trip:user:edit', null, '2016-10-20', '2016-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('1caf32bb9f6f42e99b1d9413ebe84171', '50223b0d0c014e848296f7580df517e7', ',50223b0d0c014e848296f7580df517e7,', '用户信息', '10', 'app.trip.user.list', 'glyphicon glyphicon-qrcode', '', '', '2016-10-17', '2016-10-20', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('50223b0d0c014e848296f7580df517e7', '', ',', '用户管理', '20', null, 'glyphicon glyphicon-user', null, null, '2016-10-17', '2016-10-17', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('71', '', ',', '首页', '1', 'app.dashboard', 'glyphicon glyphicon-dashboard', 'trip:dashboard:view', '', '2015-10-20', '2016-12-26', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('863b9d86e81f4e3599ce6e594c2e4932', '1caf32bb9f6f42e99b1d9413ebe84171', ',50223b0d0c014e848296f7580df517e7,1caf32bb9f6f42e99b1d9413ebe84171,', '查看', '10', null, null, 'trip:user:view', null, '2016-10-20', '2016-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('92', '', '', '系统设置', '60', '', 'glyphicon glyphicon-book', '', '', '2015-10-20', '2015-10-20', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('921', '92', '92,', '菜单管理', '30', 'app.sys.menu.list', 'glyphicon glyphicon-picture', '', '', '2015-10-20', '2015-10-20', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('9211', '921', '92,921,', '查看', '30', '', '', 'sys:menu:view', '', '2015-10-20', '2015-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('9212', '921', '92,921,', '修改', '40', '', '', 'sys:menu:edit', '', '2015-10-20', '2015-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('923', '92', '92,', '用户管理', '10', 'app.sys.user.list', 'glyphicon glyphicon-tag', '', '', '2015-10-20', '2016-10-09', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('9231', '923', '92,923,', '查看', '30', '', '', 'sys:user:view', '', '2015-10-20', '2016-10-12', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('9232', '923', '92,923,', '修改', '40', '', '', 'sys:user:edit', '', '2015-10-20', '2015-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('924', '92', '92,', '角色管理', '20', 'app.sys.role.list', 'glyphicon  glyphicon-list-alt', '', '', '2015-10-20', '2016-10-09', '0', 't');
INSERT INTO "public"."sys_menu" VALUES ('9241', '924', '92,924,', '查看', '30', '', '', 'sys:role:view', '', '2015-10-20', '2015-10-20', '0', 'f');
INSERT INTO "public"."sys_menu" VALUES ('9242', '924', '92,924,', '修改', '40', '', '', 'sys:role:edit', '', '2015-10-20', '2015-10-20', '0', 'f');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role";
CREATE TABLE "public"."sys_role" (
"id" varchar(36) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default" NOT NULL,
"remarks" varchar(255) COLLATE "default",
"create_date" date,
"update_date" date,
"del_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"enabled" bool DEFAULT true
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_role"."id" IS '编号';
COMMENT ON COLUMN "public"."sys_role"."name" IS '角色名称';
COMMENT ON COLUMN "public"."sys_role"."del_flag" IS '删除标记
1：删除
0：未删除';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO "public"."sys_role" VALUES ('1', 'ROLE_ADMIN', '管理员角色', '2016-10-09', '2016-12-26', '0', 't');
INSERT INTO "public"."sys_role" VALUES ('2', 'ROLE_USER', '用户角色', '2016-10-09', '2018-01-05', '0', 't');
INSERT INTO "public"."sys_role" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '新建的角色', 'qwe1', '2018-01-09', '2018-01-09', '0', 't');
INSERT INTO "public"."sys_role" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '而我却', '切', '2018-01-09', '2018-01-09', '0', 't');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_role_menu";
CREATE TABLE "public"."sys_role_menu" (
"role_id" varchar(36) COLLATE "default" NOT NULL,
"menu_id" varchar(36) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_role_menu"."role_id" IS '角色ID';
COMMENT ON COLUMN "public"."sys_role_menu"."menu_id" IS '菜单ID';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO "public"."sys_role_menu" VALUES ('1', '07fb63cf51d74e31b095d42b3dfb7686');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '1caf32bb9f6f42e99b1d9413ebe84171');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '50223b0d0c014e848296f7580df517e7');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '71');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '863b9d86e81f4e3599ce6e594c2e4932');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '92');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '921');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9211');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9212');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '923');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9231');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9232');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '924');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9241');
INSERT INTO "public"."sys_role_menu" VALUES ('1', '9242');
INSERT INTO "public"."sys_role_menu" VALUES ('2', '71');
INSERT INTO "public"."sys_role_menu" VALUES ('2', '92');
INSERT INTO "public"."sys_role_menu" VALUES ('2', '923');
INSERT INTO "public"."sys_role_menu" VALUES ('2', '9231');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '07fb63cf51d74e31b095d42b3dfb7686');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '1caf32bb9f6f42e99b1d9413ebe84171');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '24489a5167634be4a98fdd1efb2e6f78');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '50223b0d0c014e848296f7580df517e7');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '71');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '863b9d86e81f4e3599ce6e594c2e4932');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '92');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '921');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9211');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9212');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '923');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9231');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9232');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '924');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9241');
INSERT INTO "public"."sys_role_menu" VALUES ('cd3d8cade1a24c07ae22d7ee7616e49f', '9242');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '07fb63cf51d74e31b095d42b3dfb7686');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '1caf32bb9f6f42e99b1d9413ebe84171');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '24489a5167634be4a98fdd1efb2e6f78');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '50223b0d0c014e848296f7580df517e7');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '71');
INSERT INTO "public"."sys_role_menu" VALUES ('e372499d9de74e4bb34a9c4a99498af9', '863b9d86e81f4e3599ce6e594c2e4932');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user" (
"id" varchar(36) COLLATE "default" NOT NULL,
"login_name" varchar(100) COLLATE "default" NOT NULL,
"password" varchar(100) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default" NOT NULL,
"email" varchar(200) COLLATE "default",
"phone" varchar(200) COLLATE "default",
"mobile" varchar(200) COLLATE "default",
"remarks" varchar(255) COLLATE "default",
"create_date" date,
"update_date" date,
"del_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"enabled" bool DEFAULT true
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_user"."login_name" IS '登录名';
COMMENT ON COLUMN "public"."sys_user"."password" IS '密码';
COMMENT ON COLUMN "public"."sys_user"."name" IS '姓名';
COMMENT ON COLUMN "public"."sys_user"."del_flag" IS '删除标记
1：删除
0：未删除';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO "public"."sys_user" VALUES ('1', 'admin', '$2a$08$UIbl948v1vaFLzwr3Hea7uJECTdYsEA8gkxWxNgBLBVXbIG1ODyLO', '系统管理员1', '', '', '', '超级管理员', '2016-10-08', '2018-01-05', '0', 't');
INSERT INTO "public"."sys_user" VALUES ('ce27f240f293455781389327caea4119', 'jason', '$2a$08$5brrd9eSaepB9dQCLmSYfuR2KftsWUEywRJieIg0DKzQd.FKbhTHe', 'Jason', 'asdasd@qq.com', '136981712112', '73871298371923', 'weqweqw', '2018-01-05', '2018-01-09', '0', 't');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user_role";
CREATE TABLE "public"."sys_user_role" (
"user_id" varchar(36) COLLATE "default" NOT NULL,
"role_id" varchar(36) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."sys_user_role"."user_id" IS '用户ID';
COMMENT ON COLUMN "public"."sys_user_role"."role_id" IS '角色ID';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO "public"."sys_user_role" VALUES ('1', '1');
INSERT INTO "public"."sys_user_role" VALUES ('ce27f240f293455781389327caea4119', '2');

-- ----------------------------
-- Table structure for trip_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."trip_user";
CREATE TABLE "public"."trip_user" (
"id" varchar(36) COLLATE "default" NOT NULL,
"mobile" varchar(64) COLLATE "default" NOT NULL,
"password" varchar(255) COLLATE "default" NOT NULL,
"nickname" varchar(255) COLLATE "default",
"gender" char(1) COLLATE "default",
"age" varchar(10) COLLATE "default",
"photo" varchar(100) COLLATE "default",
"remarks" varchar(255) COLLATE "default",
"create_date" date,
"update_date" date,
"del_flag" char(1) COLLATE "default" DEFAULT '0'::bpchar,
"enabled" bool DEFAULT true
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."trip_user"."gender" IS '性别
0：未知
1：男
2：女';
COMMENT ON COLUMN "public"."trip_user"."del_flag" IS '删除标记
1：删除
0：未删除';

-- ----------------------------
-- Records of trip_user
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table sys_count
-- ----------------------------
ALTER TABLE "public"."sys_count" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_department
-- ----------------------------
ALTER TABLE "public"."sys_department" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_menu
-- ----------------------------
ALTER TABLE "public"."sys_menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table sys_role
-- ----------------------------
CREATE UNIQUE INDEX "name_UNIQUE" ON "public"."sys_role" USING btree ("name");

-- ----------------------------
-- Primary Key structure for table sys_role
-- ----------------------------
ALTER TABLE "public"."sys_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_role_menu
-- ----------------------------
ALTER TABLE "public"."sys_role_menu" ADD PRIMARY KEY ("role_id", "menu_id");

-- ----------------------------
-- Indexes structure for table sys_user
-- ----------------------------
CREATE UNIQUE INDEX "login_name_UNIQUE" ON "public"."sys_user" USING btree ("login_name");

-- ----------------------------
-- Primary Key structure for table sys_user
-- ----------------------------
ALTER TABLE "public"."sys_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sys_user_role
-- ----------------------------
ALTER TABLE "public"."sys_user_role" ADD PRIMARY KEY ("user_id", "role_id");

-- ----------------------------
-- Indexes structure for table trip_user
-- ----------------------------
CREATE UNIQUE INDEX "mobile_UNIQUE" ON "public"."trip_user" USING btree ("mobile");

-- ----------------------------
-- Primary Key structure for table trip_user
-- ----------------------------
ALTER TABLE "public"."trip_user" ADD PRIMARY KEY ("id");
