package com.grcms.im.ronghub.api.directive;

import com.grcms.basic.BaseDirective;
import com.grcms.common.util.CommonUtility;
import com.grcms.content.core.domain.CMSInfo;
import com.grcms.content.core.domain.CMSModel;
import com.grcms.content.core.domain.CMSNode;
import com.grcms.content.core.exception.ECCMSInfoException;
import com.grcms.content.core.exception.ECCMSModelException;
import com.grcms.content.core.service.CMSModelService;
import com.grcms.core.freemarker.FreemarkerTemplateUtility;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Daily;
import com.grcms.im.ronghub.api.exception.ECDailyException;
import com.grcms.im.ronghub.api.service.DailyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * CMSMODEL
 * 
 * @author jiepeng
 * 
 */
@Component
public class DailyDirective extends BaseDirective<Daily> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DailyDirective.class);
	@Autowired
	private DailyService dailyService;

	@Override
	protected Integer count(Map params,Map<String,Object> envParams) {
		return null;
	}

	@Override
	protected List<Daily> tree(Map params,Map<String,Object> envParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Daily field(Map params,Map<String,Object> envParams) {
		// 会员ID信息
		String id = FreemarkerTemplateUtility.getStringValueFromParams(params,
				"id");
		logger.debug("[id] ==> " + id);
		try {
			// 查询ID信息
			if (CommonUtility.isNonEmpty(id)) {
				Daily daily = dailyService.findById(id);
				return daily;
			}
			
		}  catch (ECDailyException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected List<Daily> list(Map params, String filter, String order, String sort,
			boolean pageable, Page<Daily> pager,Map<String,Object> envParams) {
		Daily condition = null;
		if(CommonUtility.isNonEmpty(filter)) {
			condition = CommonUtility.toObject(Daily.class, filter, "yyyy-MM-dd");
		}else{
			condition = new Daily();
		}
		
		if (condition.getId() != null && !CommonUtility.isNonEmpty(condition.getId())) {
			condition.setId(null);
		}
		String memberId = FreemarkerTemplateUtility.getStringValueFromParams(params,"userId");
		if(pageable) {
			try {
				condition.setMemberId(memberId);
				pager = dailyService.findPage(pager, condition);
			} catch (ECDailyException e) {
				e.printStackTrace();
			}
			return pager == null ?null:pager.getDatas();
		}else{
			try {
				if(CommonUtility.isNonEmpty(memberId)) {
					return dailyService.findByMemberId(memberId);
				}
			} catch (ECDailyException e) {
				e.printStackTrace();
			}
		}
		// 查询列表
		try {
			List<Daily> dailyList = dailyService.findAll();
			logger.debug("==> list length [" + dailyList.size() + "]");
			return dailyList;
		} catch (ECDailyException e) {
			e.printStackTrace();
		}
		return null;
	}

}
