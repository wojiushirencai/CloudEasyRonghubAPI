package com.grcms.im.ronghub.api.directive;

import com.grcms.basic.BaseDirective;
import com.grcms.common.util.CommonUtility;
import com.grcms.core.freemarker.FreemarkerTemplateUtility;
import com.grcms.core.util.Page;
import com.grcms.im.ronghub.api.domain.Attendency;
import com.grcms.im.ronghub.api.exception.ECAttendenceException;
import com.grcms.im.ronghub.api.service.AttendenceService;
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
public class AttendencyDirective extends BaseDirective<Attendency> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(AttendencyDirective.class);
	@Autowired
	private AttendenceService attendenceService;

	@Override
	protected Integer count(Map params,Map<String,Object> envParams) {
		return null;
	}

	@Override
	protected List<Attendency> tree(Map params,Map<String,Object> envParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Attendency field(Map params,Map<String,Object> envParams) {
		// 会员ID信息
		String id = FreemarkerTemplateUtility.getStringValueFromParams(params,
				"id");
		logger.debug("[id] ==> " + id);
		try {
			// 查询ID信息
			if (CommonUtility.isNonEmpty(id)) {
				Attendency attendence = attendenceService.findById(id);
				return attendence;
			}
			
		}  catch (ECAttendenceException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected List<Attendency> list(Map params, String filter, String order, String sort,
			boolean pageable, Page<Attendency> pager,Map<String,Object> envParams) {
		Attendency condition = null;
		if(CommonUtility.isNonEmpty(filter)) {
			condition = CommonUtility.toObject(Attendency.class, filter, "yyyy-MM-dd");
		}else{
			condition = new Attendency();
		}
		
		if (condition.getId() != null && !CommonUtility.isNonEmpty(condition.getId())) {
			condition.setId(null);
		}
		String memberId = FreemarkerTemplateUtility.getStringValueFromParams(params,"userId");
		Integer departmentId = FreemarkerTemplateUtility.getIntValueFromParams(params, "departmentId");
		String updateDate = FreemarkerTemplateUtility.getStringValueFromParams(params, "updateDate");
		String firstname = FreemarkerTemplateUtility.getStringValueFromParams(params, "firstname");
		String lastname = FreemarkerTemplateUtility.getStringValueFromParams(params, "lastname");
		if(pageable) {
			try {
				condition.setMemberId(memberId);
				condition.setUpdateDate(updateDate);
				condition.setLastname(lastname);
				condition.setFirstname(firstname);
				condition.setDepartmentId(departmentId);
				pager = attendenceService.findPage(pager, condition);
			} catch (ECAttendenceException e) {
				e.printStackTrace();
			}
			return pager == null ?null:pager.getDatas();
		}else{
			try {
				if(CommonUtility.isNonEmpty(memberId)) {
					return attendenceService.findByMemberId(memberId);
				}
			} catch (ECAttendenceException e) {
				e.printStackTrace();
			}
		}
		// 查询列表
		try {
			List<Attendency> attendenceList = attendenceService.findAll();
			logger.debug("==> list length [" + attendenceList.size() + "]");
			return attendenceList;
		} catch (ECAttendenceException e) {
			e.printStackTrace();
		}
		return null;
	}

}
