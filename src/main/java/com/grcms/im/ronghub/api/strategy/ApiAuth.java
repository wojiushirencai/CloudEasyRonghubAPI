package com.grcms.im.ronghub.api.strategy;

import com.grcms.core.exception.ECAuthException;
import com.grcms.core.strategy.authorization.Authorization;
import com.grcms.core.util.ContextUtil;
import com.grcms.frontend.dao.MemberDao;
import com.grcms.frontend.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Administrator on 2015/11/15.
 */
@Component
public class ApiAuth implements Authorization<Member> {
    @Autowired
    private MemberDao memberDao;

    public Member executeAuth(String loginId, String password) throws ECAuthException {
        Member member = this.memberDao.findByLoginIdAndPassword(loginId, password);
        if (member == null) {
            throw new ECAuthException("login id or password not correct");
        } else {
//            HttpServletRequest request = ContextUtil.getRequest();
//            Date currentLoginTime = member.getCurrentLoginTime();
//            member.setLastLoginTime(currentLoginTime);
//            member.setCurrentLoginTime(new Date());
//            String currentLoginIp = member.getCurrentLoginIp();
//            member.setLastLoginIp(currentLoginIp);
//            if (null != request) {
//                member.setCurrentLoginIp(request.getRemoteAddr());
//            }
//            Integer loginTimes = member.getLoginTimes();
//            loginTimes = Integer.valueOf(loginTimes == null ? 0 : loginTimes.intValue());
//            member.setLoginTimes(Integer.valueOf(loginTimes.intValue() + 1));
//            this.memberDao.save(member);
            return member;
        }
    }
}