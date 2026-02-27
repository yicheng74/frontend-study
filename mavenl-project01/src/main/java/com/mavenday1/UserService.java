package com.mavenday1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserService {

    /**
     *  传入一个身份证号码，计算这个用户的年龄
     *
     * @param idCard 身份证号码
     * @return 年龄
     */
    public Integer getAge(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("身份证号码不合法");
        }

        // 取出生日字符串：第7位到第14位（下标 6 ~ 13）
        String birthday = idCard.substring(6, 14);

        // 按照 yyyyMMdd 格式解析成 LocalDate
        LocalDate birthDate = LocalDate.parse(
                birthday,
                DateTimeFormatter.ofPattern("yyyyMMdd")
        );

        // 计算从生日到今天相差的年数
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    /**
     *  传入一个身份证号码，计算这个用户的性别
     *
     * @param idCard 身份证号码
     * @return 性别："男" 或 "女"
     */
    public String getGender(String idCard) {
        if (idCard == null || idCard.length() != 18) {
            throw new IllegalArgumentException("身份证号码不合法");
        }

        // 身份证第 17 位（下标 16）是性别码：奇数男，偶数女
        char genderCode = idCard.charAt(16);
        int num = genderCode - '0';

        return (num % 2 == 0) ? "女" : "男";
    }
}