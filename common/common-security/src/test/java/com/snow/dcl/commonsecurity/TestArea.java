package com.snow.dcl.commonsecurity;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 身份证号解析demo
 */

public class TestArea {

    @Test
    public void password(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        final String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    public void idCard() {
        System.out.println("测试");
        // 需求：身份证号码，地区号+生日：年+月+日+性别
        String cardNo = "61011320010505241X";
        String area = ""; // 前6位，国家标准（国标GB）
        // 截串，身份证18位，固有长度
        area = cardNo.substring(0, 6);
        System.out.println("区域编码：" + area);

        String birthday = "";
        birthday = cardNo.substring(6, 14);
        System.out.println("出生年月：" + birthday);


        int year; // 从中间变量birthday来截取
        year = Integer.parseInt(birthday.substring(0, 4)); // 字符串转成整数
        System.out.println(year);

        int month;
        System.out.println(birthday.substring(4, 6));
        month = Integer.parseInt(birthday.substring(4, 6));
        System.out.println(month);

        int day;
        day = Integer.parseInt(birthday.substring(6));
        System.out.println(day);


        System.out.println("" + year + month + day);
        System.out.println("生日：" + year + "年" + month + "月" + day + "日");

        //倒数第二位
        String gender = "";
        int sex = Integer.parseInt(cardNo.substring(cardNo.length() - 2, cardNo.length() - 1));
        if (sex % 2 == 0) {
            gender = "女";
        } else {
            gender = "男";
        }
        System.out.println(gender);

    }

    @Test
    public void aVoid() {
        String a = "qqqqlmkFCAAAkAEABAAhhddfx1IgACAAIAAgACAAI" +
                "AAgACAAIAAgACAAIAAxADAAMQAyADAAMAAwADAANgAxADYAs2xXUwF34U" +
                "8zlgJec15laDpTopDGlkeVXlN8aVFnaGeEXlFnEWzEfjQA91MgACAAIAAgAC" +
                "AAIAAgACAAIAAgACAAIAAgADQAMQAxADUAMAAzADIAMAAwADAAMAA2ADEAN" +
                "gA2ADMANQAyAOFPM5YCXmxRiVtAXHNeZWgGUkBcIAAgACAAIAAgADIAMAAxA" +
                "DkAMAA2ADEAMgAyADAAMgA5ADAANgAxADIAIAAgACAAIAAgACAAIAAgACAAIA" +
                "AgACAAIAAgACAAIAAgACAAV0xmAH4AMgAA/4VBUVFRPgh5LSDkedK9Wp7Jg3lR" +
                "rpJSUVFdPg6oB7R50aRs8Kq/k+/xA+kmOWUs7mjjDnnh/2+eSsMiFdF1CmpY7/k" +
                "Oq84gvHrOQ0IaQQUcN8NM533rEKS28THz1uJ0FHO0Rbbl37MR4Sn8ym4SVpF+3t1" +
                "KXWbtUsQeh0gd/IhreoHPGscqEcjrys2qOxcTUXcMJdyaE+/OYWWjbA4N5QeedpTq6" +
                "9a95sMawMe81TiJ99BdwNFwnsLjR8+25E1jdOek6HkMa/IK07M16gjtrKAJShYdo4V" +
                "xzeYD362XqOG1G/w4zP6DeItATYs+zyGqL7h7wPcm8tb65Gy4EnuL+6Tqojh/NfJrRq" +
                "oN3pudSYbb804uO7Jty8X954CUtrdyZKp8s23yrMrgy7liUH3X45qyI97thaGsW7u3K1" +
                "O7xGG+Evke9qY8DYHH2UNOrlF4pMN1IT0llqhQKPSLqT1eM0CiA+eP3cjMZalu0y8NKv" +
                "n+SDDgvxOMv+Nbc0BW+qly7Dfm7BuZ8QOFylUs0KbrVxks9+CznaedsNkKAvTdZT3649" +
                "Tn1tcqNKb/owjunCHHvSkqsTaDFhJifO4cReHDEmpPVZBWedkGuPKVGD3IhJQ5Kge+YI" +
                "xoLyRTeseDPkZ+zKyQ2jIV294RaQsLYa5RWar/IleR6z3OsGFB2NIuQq/++E2tpkIFny" +
                "l44NN1ZUJPs+d60N8jVKDMlSSQe50ke0xMBEaTlbC4mHY1bhR61BBD7eSmffq46weg8L" +
                "fL2M1OodXVz65RPFWRyWM1nY/jvv1aQzIyZW6Ek5byzMdBXijiDyzgPV67JgOhXo4oEf" +
                "UsdJ21wvbGt+bzMtDKtoJZoPlm4zt1unJVWWFu4GNHOqLYraOEXib2A1kTEnOEfaRcCf" +
                "NI5BuhiZYHRs2Xn4S4BcWZl/khE9LVSD9w74rgvK5RlnVoJ5cC6ny49bWMsnAjPf8tI+J" +
                "9ci7p5jdctmHXUAC+PDU6S4Y4rlH+M4IY6xIqjpT2zaJl6uN5QqUcH07tQLW8A112fWE" +
                "sHZSordBkfFstTzDEQw8/MeuBdPKV4BlPPU3psU3IFYRfFG/wtrle2B8TbrBM0SW9H6q" +
                "+WStYa5N5zkJh+ZBWDfEdehYYfytk6BZaPgM4loD+xoPGPt/3rbaeRq5RrlGuUa/1A9fr" +
                "147tefEtItkC/PiNV3mIq0dTgupSkZ9oGTTyoRNlXqVq45jXs6D4M1T0j184Bjhvyf5Fhg" +
                "DuVMdbM1o+xo5wSUSFebfoMHBakqwZIeDNTR1h6xqn/wHrz+h7TqHIkLbPl0KZZiLCutL" +
                "R0n4dxWg01+stVgpBRWd7K4/hAm3NheOf6lWWlL07WYI=";
/*
        String a=totext("296e2566255a20002000200020002000200020002000200020002000200032003000310031003900350036003000330030003100b36c17530177996cb36c025e7d7654584795e07a51675297745e578831003800f753200020002000200020002000200020002000200020002000200020002000200020002000310033003200320032003200310039003500360030003300300031003300300032003300996cb36c025e6c51895b405c200020002000200020002000200020002000320030003000380030003900310037007f951f67200020002000200020002000200020002000200020002000200020002000200020002000200020002000200020002000574c66007e00320000ff851d5151513e710dd564f377a09724cae2b6a87252475366649bc7197462c8ba6cc096504cb5b094bc1beb8f1d83a22e0ae6dfce79464b78d3956c448ecd63befadc83b3aff34399db42ad88dccbe551aed65251515a3e9246d62e8efab13a23aa5760cdcd2fefefc758285052b3765ac80ab8d62e5d02e68ff0e25b6751cf9eab6ed739849c21215e2b815ed630e31598e88bc6b523cc0ce574f01a4be6a01587720030d0aae0e7509bc2c314e5596ede710b1822662513fbde4c49285f5b78a4f670bf9b471243330758415c0b48ab326f3fbfd6c36659e3f0a7902be24b2482653c0e837ed730688d09fd32b5a7c3f32824f43a7b7e0e02eca0029bb26b8ebc056817c8b395394b47e44bb9ef11accca648b7f3da18d239bf8ce8ad4c99818da7b0002c396127727b146024cf4fff1de094fe02038e64cf238ae1dedb1add56166b9b35c25cc6ce0fc0674e37ce341f28b8ea70404f1383231b3ed86ae9109dc85a57f914bde1d9c3fea84be450456786bae654b1c6ba5a8eac0f02fccfb500c7cf5595d81bef9808618a85abfaf4d4db1b1b986a5d61c2a115e202b0b8b7739bad202ad5c26b3087b88dbaa76ea7b627ed2e24913a8e2c57b49e3e11bf5149c6d164d82f7faae02adb3f958ce3337be71bdb46713fded859a06c5d13cd3e7e09ece27210b4fbcd5f92a2792992e77010c79731d3aa7e3a4773ca9bb0431370f01ec7984e441379f37f11d1531a99bc7878ac6da3a186783914c276ebb58637c34ceea5aba288e4c63913ee4d6188a1b39e2800ddab018b3a7e1a3ffb61100e98d9a245add137ccf820521e7814626b528c96b3604d29f31ee796e7841025585ba67d332eb341be513858a52ca35addde41a30651414ec8eb9402b91c0a5864459e3b18cae1244deb49425af5715ad12231d5d6d3d60bd65d1bd0599d6779faa6156f0dce9d19ffc86854acc656275dbd7caba9e3212f8d518f02df888f309180c2c3ecdf1bba38f91c7da6fbbd1fecea703909bfa0d511a9a41463657de72afae3bfb6c33cbdf18dd5aa07736f310572b9e9e024a4c0d568a680ad1dd24805c891bd9046a8a60eeba9e87cce6f04c33e3bae51ba6fe98de60c0f55834741aad7dbfc78e5827aae511449aa0942ac94ac79036aba8af5f233f8f0a7be99045829549470656d411074e4d47abfbdcd194f8050189d125de7a2be5a3ef372cb6c3d2eb4bbf4ea512ea4724555ea7d504a9c8b173afa612f9c37fac63abbcfe3982aa265a8502edb9c9e517fb517be84062a986d06881394e0b450d8920ad55b9f24bf8b4e4534700a9c13755a3ea859cdb63eb806e2c89f0eac6b3cd6d121512feaa5812696a8640d8242ea3e89868fe8c99c8ec173cda25566e0d4df665b27273afe71989ee5a90ca01d752042854cda8aef630117");
*/
        byte[] decode = Base64.getDecoder().decode(a);
        String b =  toHex(decode);
        //所有上报数据

        String info = b.substring(28, 540);
        //姓名
        String cardname = info.substring(0, 60);
        String string = totext(cardname);
        //性别
        String sex = info.substring(60, 64);

        //民族
        String nation = info.substring(64, 72);
        //出生日期
        String birth = info.substring(72, 104);
        //地址
        String address = info.substring(104, 244);
        //身份证号
        String idCard = info.substring(244, 316);
        //签发机关
        String sign = info.substring(316, 376);
        //起始日期
        String startTime = info.substring(376, 408);
        //结束日期
        String endTime = info.substring(408, 440);

    }

    /**
     * 16进制解码为中文
     *
     * @param str 16进制字符串
     * @return
     */
    public String unicodeToChar(String str) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            ch = (char) Integer.parseInt(matcher.group(2), 16);
            str = str.replace(matcher.group(1), ch + "");
        }
        return str;
    }

    /**
     * Unicode转16进制
     *
     * @param str Unicode字符串
     * @return
     */
    public String totext(String str) {
        String newtext = "";
        for (int i = 0; i < str.length(); i = i + 4) {
            String part = str.substring(i, i + 4);
            newtext = newtext + "\\u" + part.substring(2) + part.substring(0, 2);
        }
        return unicodeToChar(newtext);
    }


    private static final char[] DIGITS
            = {'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public String toHex(byte[] data) {
        final StringBuffer sb = new StringBuffer(data.length * 2);
        for (int i = 0; i < data.length; i++) {
            sb.append(DIGITS[(data[i] >>> 4) & 0x0F]);
            sb.append(DIGITS[data[i] & 0x0F]);
        }
        return sb.toString();
    }

}
