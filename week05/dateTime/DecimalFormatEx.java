package javaStudy.week05.dateTime;

import java.text.DecimalFormat;

public class DecimalFormatEx {
    public static void main(String[] args) {
        double num = 1234567.89;
        String[] pattern = {
                "0",
                "#",
                "0.0",
                "#.#",
                "0000000000.0000",
                "##########.####",
                "#,###.##",
                "#,####.##",
                "'#'#,###",
                "''#,###"
        };

        for(int i = 0; i < pattern.length; i++) {
            DecimalFormat df = new DecimalFormat(pattern[i]);
            System.out.printf("%19s : %s\n", pattern[i], df.format(num));
        }
    }
}
