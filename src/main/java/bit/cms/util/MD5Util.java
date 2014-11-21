package bit.cms.util;

import java.security.MessageDigest;

/**
 * @author Artem.Telizhenko
 *         Date: 18.11.2014
 *         Time: 16:55
 */
public class MD5Util {
    private String inStr;

    private MessageDigest md5;

    public MD5Util(String inStr) {
        this.inStr = inStr;
        try {
            this.md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String compute() {
        char[] charArray = this.inStr.toCharArray();

        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];

        byte[] md5Bytes = this.md5.digest(byteArray);

        StringBuffer hexValue = new StringBuffer();

        for (byte md5Byte : md5Bytes) {
            int val = ((int) md5Byte) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
