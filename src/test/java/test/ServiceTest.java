package test;

import com.grcms.common.util.CommonUtility;
import com.grcms.core.exception.ECAuthException;
import com.grcms.im.ronghub.api.service.AuthService;
import com.grcms.im.ronghub.api.service.impl.AuthServiceImpl;
import org.junit.Test;


public class ServiceTest {

    private AuthService authService = new AuthServiceImpl();

    @Test
    public void findRole() {
        String username = "jiepeng";
        String password = CommonUtility.MD5Digest("easycms.com", "123456");
        try {
            authService.executeAuth(username,password);
        } catch (ECAuthException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void email() {
        System.out.println(CommonUtility.MD5Digest("easycms.com", "123456"));
    }


}
