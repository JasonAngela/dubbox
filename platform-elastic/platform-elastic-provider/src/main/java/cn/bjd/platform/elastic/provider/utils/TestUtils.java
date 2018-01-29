package cn.bjd.platform.elastic.provider.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/27.
 */
public final class TestUtils {

    private TestUtils() {
    }

    /**
     * Key
     */
    private static final String[] KEYS = new String[]{"etpShareholder", "etpSeniorManager", "etpAlter", "etpBranch", "etpStock", "etpStockChange"
            , "etpSharesFrost", "etpChattel", "etpAbnormal", "etpIllegal", "etpPunish", "etpLicence", "crdBreakfaith", "crdCourt", "crdCourtpub", "crdExecuted"};

    /**
     * @param args
     */
    public static void main(String[] args) {

        String template = "    /**\n" +
                "     * etpShareholder\n" +
                "     */\n" +
                "    public static final List<CellConfig> ETP_SHAREHOLDER_HEAD = new ArrayList<>();";

        for (String key : KEYS) {
            if (!"etpShareholder".equals(key)) {
                System.out.println(template.replace("etpShareholder", key)
                        .replace("EtpShareholder", key.substring(0, 1).toUpperCase() + key.substring(1))
                        .replace("ETP_SHAREHOLDER", trans(key).toUpperCase()));
            }
        }
    }

    /**
     * @param str
     * @return String
     */
    public static String trans(String str) {
        List record = new ArrayList();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if ((tmp <= 'Z') && (tmp >= 'A')) {
                record.add(i);//记录每个大写字母的位置
            }

        }

        str = str.toLowerCase();
        char[] charofstr = str.toCharArray();
        String[] t = new String[record.size()];
        for (int i = 0; i < record.size(); i++) {
            t[i] = "_" + charofstr[(int) record.get(i)];//加“_”
        }
        String result = "";
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((flag < record.size()) && (i == (int) record.get(flag))) {
                result += t[flag];
                flag++;
            } else {
                result += charofstr[i];
            }
        }

        return result;
    }
}
