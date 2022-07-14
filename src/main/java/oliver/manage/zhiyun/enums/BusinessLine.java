package oliver.manage.zhiyun.enums;

/**
 * @author zhangxiaojian
 * @date 2022年07月14日 13:20
 */
public enum BusinessLine {
    ZHIYUN("000", "之云业务错误码");

    private final String code;
    private final String des;

    BusinessLine(final String code, final String des) {
        this.code = code;
        this.des = des;
    }

    public String getCode() {
        return this.code;
    }

    public String getDes() {
        return this.des;
    }

}
