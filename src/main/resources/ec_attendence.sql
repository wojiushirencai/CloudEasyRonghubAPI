/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50621
Source Host           : 127.0.0.1:3306
Source Database       : easycms_v11_wiki

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-11-16 00:44:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ec_attendence`
-- ----------------------------
DROP TABLE IF EXISTS `ec_attendence`;
CREATE TABLE `ec_attendence` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID',
  `member_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'member id',
  `location` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'location from client',
  `remark` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'remark',
  `update_date` date NOT NULL COMMENT 'update date',
  `update_time` date NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `fk_att_member` (`member_id`),
  CONSTRAINT `fk_att_member` FOREIGN KEY (`member_id`) REFERENCES `ec_members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_attendence
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_daily`
-- ----------------------------
DROP TABLE IF EXISTS `ec_daily`;
CREATE TABLE `ec_daily` (
  `id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID',
  `title` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT 'title',
  `update_time` date NOT NULL COMMENT 'update time',
  `content` varchar(500) COLLATE utf8_unicode_ci NOT NULL COMMENT 'daily content',
  `member_id` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT 'member id',
  PRIMARY KEY (`id`),
  KEY `fk_daily_member` (`member_id`),
  CONSTRAINT `fk_daily_member` FOREIGN KEY (`member_id`) REFERENCES `ec_members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_daily
-- ----------------------------

-- ----------------------------
-- Table structure for `ec_ronghub_api`
-- ----------------------------
DROP TABLE IF EXISTS `ec_ronghub_api`;
CREATE TABLE `ec_ronghub_api` (
  `id` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT 'UUID',
  `user_id` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT 'user id from ronghub',
  `token` varchar(200) COLLATE utf8_unicode_ci NOT NULL COMMENT 'token from ronghub',
  `expire_date` date DEFAULT NULL COMMENT 'expire date',
  PRIMARY KEY (`id`),
  KEY `fk_api_member` (`user_id`),
  CONSTRAINT `fk_api_member` FOREIGN KEY (`user_id`) REFERENCES `ec_members` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of ec_ronghub_api
-- ----------------------------
INSERT INTO `ec_ronghub_api` VALUES ('666dcbee73974a288f0ab5c18e4c2cc5', '297efa124f6d016e014f6d06341e0000', 'Y0P+FKYQoKJs/XtFzml6UYeJvHfflqPWfJ0R3EAGfB/E2hVlrUz6KhJhghoCxneyvLtzlhIBugDrD83dhSC3NaoSxTtohiXfDZY+GjVRxXyJe4KvjsHTZh4HRCan7Scxn+FFEd+FMB4=', null);
