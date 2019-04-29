package designpatterns;

import java.io.Serializable;

public class CacheEntity implements Serializable {
    private static final long serialVersionUID = -5431498217838646933L;
    private Object value;
    private int expire;
    private long gmtModify;
    public Object getValue() {
        return value;
    }
    public void setValue(Object o) {
        value = o;
    }
    public long getGmtModify() {
        return gmtModify;
    }
    public void setGmtModify(long t) {
        gmtModify = t;
    }
    public int getExpire() {
        return expire;
    }
    public void setExpire(int e) {
        expire = e;
    }
}
