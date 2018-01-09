/*
Navicat PGSQL Data Transfer

Source Server         : 192.168.0.10
Source Server Version : 90414
Source Host           : 192.168.0.10:5432
Source Database       : original
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90414
File Encoding         : 65001

Date: 2018-01-09 10:09:17
*/


-- ----------------------------
-- Table structure for industry_season
-- ----------------------------
DROP TABLE IF EXISTS "public"."industry_season";
CREATE TABLE "public"."industry_season" (
"id" int4 DEFAULT nextval('industry_season_id_seq'::regclass) NOT NULL,
"hy_name1" varchar(255) COLLATE "default",
"icodes" varchar(255) COLLATE "default",
"hy_name2" varchar(255) COLLATE "default",
"m1" float8,
"m2" float8,
"m3" float8,
"m4" float8,
"m5" float8,
"m6" float8,
"m7" float8,
"m8" float8,
"m9" float8,
"m10" float8,
"m11" float8,
"m12" float8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of industry_season
-- ----------------------------
INSERT INTO "public"."industry_season" VALUES ('1', '安全安保', '7281', '保安安保', '1', '2', '2', '2', '1', '2', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('2', null, '3595', '防盗报警', '2', '2', '2', '2', '1', '2', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('3', null, '3596', '交通消防', '2', '2', '2', '2', '2', '2', '2', '2', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('4', null, '3595', '门禁考勤', '1', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('5', '办公文教', '3479', '办公设备', '2', '2', '2', '2', '2', '2', '1', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('6', null, '4026', '教学设备', '2', '2', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('7', null, '2411', '文具', '2', '2', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('8', null, '514,524', '文教 体育用品批发、零售', '1', '1', '2', '2', '1', '1', '1', '1', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('9', '电脑硬件', '3911', '电脑', '2', '2', '2', '1', '2', '1', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('10', null, '3912', '配件', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('11', null, '3913', '外设', '2', '2', '2', '1', '1', '2', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('12', null, '3922', '网络设备', '1', '1', '1', '1', '2', '2', '1', '1', '1', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('13', '电子电工', '3561', '电工器材', '2', '2', '2', '1', '2', '2', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('14', null, '381', '电机设备', '2', '2', '2', '1', '2', '1', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('15', null, '3831', '电线电缆', '2', '2', '2', '1', '1', '1', '1', '1', '1', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('16', null, '382', '电源设备', '2', '2', '2', '2', '2', '2', '1', '1', '1', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('17', null, '397', '电子元件', '2', '2', '2', '1', '1', '1', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('18', null, '401', '仪器仪表', '2', '2', '2', '1', '1', '2', '2', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('19', null, '387', '照明设备', '2', '2', '2', '2', '1', '2', '2', '2', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('20', '房地产', '7010', '房产买卖', '2', '1', '1', '1', '1', '2', '2', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('21', null, '7030', '房屋出租', '2', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('22', '服装鞋帽', '181,182', '服装', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('23', null, '191', '皮革', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('24', null, '183,195', '鞋帽', '1', '1', '2', '2', '2', '2', '2', '2', '1', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('25', '广播通信', '3921', '通信设备', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('26', null, '631,641,642', '通信服务', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('27', null, '3922', '通信终端', '2', '2', '2', '1', '2', '1', '2', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('28', '广告及包装', '7293', '包装', '2', '2', '2', '2', '2', '1', null, null, '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('29', null, '724', '广告', '1', '2', '2', '2', '2', '2', '2', '2', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('30', null, '231', '印刷', '2', '2', '2', '1', '1', '1', '1', '2', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('31', '化工及材料', '261,265,281', '化工材料', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('32', null, '06,06,11,25,44,45', '能源', '2', '2', '2', '2', '1', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('33', null, '292', '塑料', '2', '2', '2', '2', '2', '1', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('34', null, '264', '涂料', '2', '2', '2', '1', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('35', null, '291', '橡胶', '2', '2', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('36', null, '31,32', '冶金', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('37', null, '2612', '纯碱', '1', '2', '3', '3', '3', '2', '1', '1', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('38', null, '2824', 'PVC', '1', '1', '2', '2', '2', '2', '2', '2', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('39', null, '2624', '尿素 ', '1', '2', '3', '3', '3', '3', '2', '2', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('40', null, '2511', '汽油 ', '3', '1', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3');
INSERT INTO "public"."industry_season" VALUES ('41', '化妆品', '2682,5234,5134', '化妆品', '2', '2', '2', '1', '2', '1', '1', '1', '1', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('42', '机械设备', '34', '通用机械设备', '2', '2', '1', '1', '1', '1', '2', '2', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('43', null, '331', '金属材料', '2', '2', '2', '2', '2', '2', '2', '1', '1', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('44', null, '352', '化工材料', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('45', null, '3513', '工程机械', '2', '2', '2', '2', '1', '2', '2', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('46', null, '348', '通用零配件', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('47', null, '3516', '冶金机械', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('48', null, '3468', '包装机械', '2', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('49', null, '355', '纺织机械', '2', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('50', null, '342', '机床设备', '2', '2', '2', '2', '2', '2', '2', '2', '1', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('51', null, '3592', '勘探机械', '2', '2', '2', '2', '2', '1', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('52', null, '3525', '模具', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('53', null, '357', '农林机械', '1', '1', '1', '2', '2', '2', '2', '2', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('54', null, '3554', '清洁设备', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('55', null, '3594', '商业设备', '2', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('56', null, '353', '食品机械', '2', '2', '1', '2', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('57', null, '3462', '通风设备', '2', '2', '2', '1', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('58', null, '343', '物流设备', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('59', null, '3523', '橡塑设备', '2', '2', '2', '2', '2', '1', '1', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('60', null, '358', '医疗机械', '2', '2', '2', '2', '1', '1', '2', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('61', null, '3541', '造纸设备', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('62', '家用电器', '3851,3852', '冷暖', '2', '2', '2', '2', '2', '2', '1', '1', '1', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('63', null, '3922', '手机数码', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('64', null, '3952', '音响', '2', '2', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('65', null, '3854', '厨用', '2', '2', '2', '1', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('66', null, '3855', '卫浴', '2', '2', '2', '2', '2', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('67', null, '3953', '影视', '1', '1', '1', '1', '2', '2', '1', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('68', null, '3951', '彩电 ', '2', '2', '1', '1', '1', '1', '1', '2', '3', '3', '3', '3');
INSERT INTO "public"."industry_season" VALUES ('69', '建筑及装修', '47,48,49', '建筑工程', '1', '1', '1', '2', '2', '2', '2', '2', '1', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('70', null, '202,203,292,301,302,303,304,3313351,3352', '建筑装修材料', '1', '1', '2', '1', '1', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('71', null, '5165,528', '建材类销售', '1', '1', '1', '2', '2', '2', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('72', null, '50', '装修服务', '1', '1', '2', '2', '2', '1', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('73', '交通运输', '3610', '车辆', '2', '2', '2', '2', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('74', null, '5174,5263', '摩托车销售', '1', '1', '2', '2', '2', '2', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('75', null, '5172,5261', '汽车销售', '2', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('76', null, '7111', '租车', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('77', null, '3650', '重卡 ', '1', '1', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('78', null, '5430', '公路货物运输量 ', '2', '2', '1', '1', '1', '1', '1', '1', '3', '3', '2', '3');
INSERT INTO "public"."industry_season" VALUES ('79', null, '5611', '旅客运输量 (航空)', '1', '1', '2', '3', '2', '1', '3', '3', '3', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('80', null, '6020', '货邮运输量 （航空）', '1', '1', '2', '2', '1', '1', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('81', null, '553', '沿海港口', '1', '1', '1', '2', '2', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('82', '教育培训', '8242', '高教自考', '1', '2', '1', '1', '2', '2', '2', '2', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('83', null, '8293', '家教和拓展', '2', '2', '2', '1', '2', '2', '2', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('84', null, '8830', '休闲培训', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('85', null, '8299', '语言培训', '2', '2', '2', '1', '1', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('86', null, '8291', '职业教育', '2', '2', '2', '1', '1', '2', '2', '2', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('87', '节能环保', '42', '废旧回收', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('88', null, '7514', '节能', '2', '2', '2', '2', '1', '1', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('89', null, '772', '污染处理', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('90', '金融', '68', '保险', '1', '1', '1', '2', '2', '2', '1', '1', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('91', null, '662', '银行', '3', '2', '3', '3', '2', '3', '1', '1', '2', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('92', '礼品饰品', '243', '工艺品', '2', '2', '1', '1', '1', '1', '1', '2', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('93', '旅游及票务', '727', '旅游', '1', '2', '2', '1', '1', '2', '2', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('94', null, '5822', '交通票务', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('95', null, '61', '宾馆', '1', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('96', '农林牧渔', '262', '化肥', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('97', null, '263', '农药', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('98', null, '03,04', '养殖', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('99', null, '0149,784,785,3079', '园林景观', '2', '2', '2', '1', '1', '1', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('100', null, '5123,5223', '水果批发', '2', '2', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('101', null, '01,02,05', '种植', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('102', null, '135', '猪肉', '2', '2', '2', '1', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('103', '软件游戏', '6510', '软件', '2', '2', '2', '2', '2', '2', '1', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('104', '商务服务', '7279', '出国', '2', '2', '2', '1', '2', '2', '1', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('105', null, '7299', '代理', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('106', null, '7232', '调查', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('107', null, '7294', '翻译', '2', '2', '2', '1', '2', '2', '2', '1', '1', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('108', null, '7233', '公关', '2', '2', '2', '2', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('109', null, '7231', '会计审计', '2', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('110', null, '5182', '拍卖', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('111', null, '7491', '设计', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('112', null, '726', '招聘', '2', '2', '2', '2', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('113', null, '721', '咨询策划', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('114', '生活服务', '7990', '搬家', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('115', null, '2320', '办证刻章', '1', '2', '2', '2', '1', '1', '2', '2', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('116', null, '811', '保洁', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('117', null, '7910', '保姆家政', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('118', null, '0519', '虫害控制', '2', '2', '2', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('119', null, '7492', '婚庆摄影', '2', '2', '2', '1', '1', '1', '2', '2', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('120', null, '7970', '征婚交友', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('121', '生活用品', '2927,3054,3073,3379,3381,3382', '厨具餐具', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('122', null, '21', '家具', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('123', null, '3389,411', '日常用品', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('124', '食品餐饮', '62', '餐馆', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('125', null, '14', '食品', '2', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('126', null, '1331,146', '食用油调料', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('127', null, '152', '饮料', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('128', '网络服务', '6420', '网站建设', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('129', null, '6490', '域名空间', '1', '2', '2', '2', '1', '1', '2', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('130', '休闲娱乐', '0330', '宠物', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('131', null, '242', '乐器', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('132', null, '244', '体育器械', '2', '2', '2', '2', '1', '1', '1', '1', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('133', null, '245', '玩具模型', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('134', null, '86,87,88,89', '休闲娱乐', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('135', '医疗健康', '8413', '保健心理', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('136', null, '8350', '妇、儿科', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('137', null, '7940', '美容整形', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('138', null, '358', '医疗器械', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('139', null, '8312', '中医', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('140', '采掘 ', '06', '煤 （产量）', '1', '1', '2', '2', '3', '3', '3', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('141', '黑色金属', '3140', '热轧薄板 ', '1', '2', '2', '3', '3', '2', '2', '2', '2', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('142', null, '331', '钢筋、线材 ', '1', '1', '3', '3', '3', '3', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('143', null, '3110', '钢厂 ', '2', '2', '2', '2', '2', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('144', '有色金属 ', '3262', '铝材 ', '1', '1', '2', '2', '3', '3', '3', '3', '3', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('145', null, '3261', '铜材 ', '1', '1', '3', '3', '3', '3', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('146', '建筑建材 ', '3011', '水泥 ', '1', '1', '1', '2', '2', '2', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('147', null, '3041', '玻璃 ', '1', '1', '1', '2', '2', '2', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('148', '房地产 ', '701', '房地产新开工 ', '1', '1', '3', '3', '3', '2', '2', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('149', '商业贸易', '52', '零售总额 ', '3', '2', '1', '1', '2', '2', '2', '2', '2', '3', '3', '3');
INSERT INTO "public"."industry_season" VALUES ('150', '公用事业 ', '4411', '火电发电量 ', '1', '2', '2', '2', '2', '2', '3', '3', '2', '2', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('151', '纺织服装 ', '18,19', '纺织 (生产)', '1', '1', '1', '2', '2', '2', '1', '1', '1', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('152', null, '5132,5131,5133,5231,5232,5233', '服装、床上用品批发', '2', '2', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('153', '电子元器件 ', '396,397', '半导体 ', '1', '1', '1', '2', '2', '2', '3', '3', '3', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('154', '办公及文教用品', '241,514,524', '办公及文教用品', '1', '1', '2', '2', '1', '2', '2', '2', '1', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('155', '彩票类', '8930', '彩票类', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('156', '电子电工及五金类', '38,39,40', '电子电工及五金类', '1', '1', '2', '2', '2', '2', '2', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('157', '广告印刷服务', '7240,231', '广告印刷服务', '1', '1', '2', '1', '1', '1', '1', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('158', '化工及材料类', '26,27,28,29', '化工及材料类', '1', '1', '2', '2', '1', '1', '1', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('159', '环保类', '3591,3597,4021,746,77,78,2665', '环保类', '1', '1', '1', '1', '2', '1', '1', '1', '1', '2', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('160', '机械加工类', '33', '机械加工类', '1', '1', '2', '1', '1', '1', '1', '1', '1', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('161', '机械设备类', '34,35', '机械设备类', '1', '1', '2', '2', '2', '1', '1', '2', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('162', '建筑类', '47,48,49,50', '建筑类', '1', '1', '2', '1', '2', '2', '1', '2', '2', '2', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('163', '交通运输类', '53,54,55,56,58', '交通运输类', '1', '1', '2', '1', '2', '2', '1', '1', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('164', '教育培训类', '82', '教育培训类', '1', '2', '2', '1', '1', '2', '2', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('165', '金融服务类', '66,67,68,69', '金融服务类', '1', '1', '2', '1', '2', '1', '2', '1', '2', '1', '1', '1');
INSERT INTO "public"."industry_season" VALUES ('166', '礼品类', '243,5245,5146', '礼品类', '1', '2', '2', '2', '2', '1', '2', '1', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('167', '模型雕塑类', '2431', '模型雕塑类', '1', '1', '2', '1', '2', '1', '1', '1', '1', '1', '2', '1');
INSERT INTO "public"."industry_season" VALUES ('168', '企业服务类', '72', '企业服务类', '1', '1', '2', '2', '2', '2', '1', '2', '2', '1', '2', '2');
INSERT INTO "public"."industry_season" VALUES ('169', '生活服务类', '79,80,81', '生活服务类', '1', '1', '1', '1', '2', '1', '1', '2', '1', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('170', '生活及体育用品类', '244', '生活及体育用品类', '1', '1', '2', '2', '2', '1', '1', '1', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('171', '信息服务类', '63,64,65', '信息服务类', '1', '1', '2', '2', '1', '1', '2', '2', '2', '1', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('172', '医疗健康类', '83', '医疗健康类', '1', '1', '2', '1', '2', '1', '1', '2', '2', '2', '1', '2');
INSERT INTO "public"."industry_season" VALUES ('173', '招商类', '5181', '招商类', '1', '1', '2', '2', '2', '1', '1', '2', '1', '2', '1', '2');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
