package com.company.generator;

import java.time.Instant;
import java.util.Arrays;

/**
 * @author Administrator
 */
public class SnowflakeTest {
    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(784);

        long beforeTimestamp = Instant.now().toEpochMilli();

        long id = snowflake.nextId();

        long[] attrs = snowflake.parse(id);

        System.out.println(Arrays.toString(attrs));
        System.out.println(attrs[0] >= beforeTimestamp);
        System.out.println(id);
    }
}
