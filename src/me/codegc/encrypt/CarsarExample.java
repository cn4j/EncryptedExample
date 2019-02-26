package me.codegc.encrypt;


import org.jetbrains.annotations.Contract;

import java.util.Scanner;

/**
 * ==========================
 * Created by IntelliJ IDEA.
 *
 * @email：coding1618@gmail.com
 * @version：1.0
 * @author: Ding / 2019年02月26日12:34:18
 * @TODO: 凯撒密码 & CarsarCode Example
 * ==========================
 */
public class CarsarExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要加密的明文:");

        String ClearText = scanner.next();

        int key = 3;

        char[] CipherText = encrypt(ClearText, key);


        System.out.println("加密结果:" + new String(CipherText));


        System.out.println("解密结果:" + new String(decrypt(new String(CipherText), 3)));

    }

    /**
     * TODO: 凯撒加密实现
     *
     * @return 返回密文char类型
     * @author coding
     * @date 2019-02-26 12:50
     * @paeam 明文 秘钥
     */
    @Contract("null, _ -> !null")
    private static char[] encrypt(String clearText, int key) {

        char[] ClearChars = null;

        if (clearText != null) {
            ClearChars = clearText.toCharArray();
        } else {
            return "你传入明文为空!加密失败!".toCharArray();
        }

        char[] CipherChars = null;

        if (ClearChars != null) {
            CipherChars = new char[ClearChars.length];
        }

        for (int i = 0; i < ClearChars.length; i++) {
            int cipher = ClearChars[i] + key;
            CipherChars[i] = (char) cipher;
        }
        return CipherChars;
    }

    /**
     * TODO: 凯撒解密实现
     *
     * @return 返回明文char类型
     * @author coding
     * @date 2019-02-26 12:50
     * @paeam 密文 秘钥
     */
    private static char[] decrypt(String ciphertext, int key) {

        char[] CipherChars = null;

        if (ciphertext != null) {
            CipherChars = ciphertext.toCharArray();
        } else {
            return "解密失败!你传入的密文为空!".toCharArray();
        }

        for (int i = 0; i < CipherChars.length; i++) {
            CipherChars[i] -= key;
        }

        return CipherChars;
    }
}
