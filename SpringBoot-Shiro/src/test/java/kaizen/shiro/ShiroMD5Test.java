package kaizen.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author: weizujie
 * @Date: 2020/12/5
 * @Github: https://github.com/weizujie
 */
public class ShiroMD5Test {

    public static void main(String[] args) {
        // 使用 MD5
        Md5Hash md5Hash = new Md5Hash("123");
        System.out.println(md5Hash.toHex());

        // 使用 MD5 + Salt(可以使用随机产生的字符串)
        Md5Hash md5Hash1 = new Md5Hash("123", "!Q@W#E");
        System.out.println(md5Hash1.toHex());

        // 使用 MD5 + Salt + Hash 散列(次数)
        Md5Hash md5Hash2 = new Md5Hash("123", "!Q@W#E", 1024);
        System.out.println(md5Hash2.toHex());
    }

}
