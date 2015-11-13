/* 
 * Globalroam 2015 @copyright 
 */
package com.grcms.im.ronghub.api.dao.impl;

import com.grcms.basic.impl.MybatisBaseDaoImpl;
import com.grcms.common.util.CommonUtility;
import com.grcms.im.ronghub.api.dao.RonghubApiDao;
import com.grcms.im.ronghub.api.domain.RonghubDetail;
import com.grcms.im.ronghub.api.exception.ECRonghubDetailException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jiepeng
 * @Date:2015/11/13 0013
 * @Description:
 */
@Repository("ronghubApiDao")
public class RonghubApiDaoImpl extends MybatisBaseDaoImpl<RonghubDetail> implements RonghubApiDao {
}
