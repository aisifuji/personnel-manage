package cn.edu.xmut.personnelmanage.util;


import cn.edu.xmut.personnelmanage.domain.entity.SysUser;
import cn.edu.xmut.personnelmanage.domain.vo.SysUserVO;
import cn.edu.xmut.personnelmanage.properties.CustomizeProperties;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 密码工具类
 */
@Component
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    @Autowired
    private CustomizeProperties consumerProperties;
    /**
     * 加密密码（用于初始化密码）
     *
     * @param sysUserVO
     */
    public void encryptPassword(SysUserVO sysUserVO) {

        sysUserVO.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                consumerProperties.getAlgorithmName(),
                sysUserVO.getPassword(),
                ByteSource.Util.bytes(sysUserVO.getSalt()),
                consumerProperties.getHashIterations()).toHex();

        sysUserVO.setPassword(newPassword);
    }

    /**
     * 获取加密后的密码
     *
     * @param credentialsSalt
     * @param password
     *
     * @return
     */
    public String encryptPassword(String credentialsSalt, String password) {
        String newPassword = new SimpleHash(
                consumerProperties.getAlgorithmName(),
                password,
                ByteSource.Util.bytes(credentialsSalt),
                consumerProperties.getHashIterations()).toHex();
        return newPassword;
    }
}
