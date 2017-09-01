package com.itss.vn.common.constant;

public class Constants {

    public static final String RESULT_CODE_SUCCESS = "OK";
    public static final String RESULT_CODE_FAIL = "NOT_OK";

    public static final String MESSAGE_SUCCESS = "SUCCESSFULLY";
    public static final String MESSAGE_FAIL = "FAIL";

    public static final String PAGE_DEFAULT_START = "0";
    public static final String PAGE_DEFAULT_LIMIT = "100";

    public static final int PAGE_DEFAULT_START_NUM = 0;
    public static final int PAGE_DEFAULT_LIMIT_NUM = 100;

    public static final String PAGE_DEFAULT_ORDER_BY = "updatedTime";
    public static final String ASCENDING = "ascending";
    public static final String DESCENDING = "descending";

    //public static final String DATA_DIR = "../webapps/shops-services/data/";
    public static final String DATA_DIR = "../webapps/a/";

    //Const trang thai cac ban ghi trong bang
    public static final class STATUS {
        public static final Integer DELETE = 0;
        public static final Integer AVAILABLE = 1;
        public static final Integer TEMPLTE = 2;
    }

    public static final String EMPTY_STR = "";

    public static final class CODE_PREFIX {
        public static final String INVENTORY = "IVT";
        public static final String STOCK_TRANS = "STT";
        public static final String PRODUCT = "PRD";
        public static final String PRODUCT_GROUP = "PRG";
        public static final String ATTRIBUTE = "ATB";
        public static final String ATTRIBUTE_GROUPS = "ATG";
        public static final String FINISHED = "FIN";

    }

    public static final class TYPE_TRANS {
        public static final String PHIEU_NHAP = "PN";
    }
}
