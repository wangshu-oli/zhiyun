package oliver.manage.zhiyun.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import java.nio.charset.StandardCharsets;

/**
 * @author zhangxiaojian
 * @date 2022年07月15日 14:22
 */
public final class SecureUtils {

    private SecureUtils() {
    }

    /**
     * 密码加密
     *
     * @param key      转成16进制的公钥
     * @param password 密码
     * @author zhangxiaojian
     * @date 2022/7/15 14:51
     */
    public static String encryptHexPassword(String key, String password) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,
            Base64.decode(key.getBytes(StandardCharsets.UTF_8)));
        return aes.encryptHex(password);
    }

    /**
     * 密码解密
     *
     * @param key      转成16进制的公钥
     * @param password 密码
     * @author zhangxiaojian
     * @date 2022/7/15 14:51
     */
    public static String decryptHexPassword(String key, String password) {
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,
            Base64.decode(key.getBytes(StandardCharsets.UTF_8)));
        return aes.decryptStr(password);
    }
}
