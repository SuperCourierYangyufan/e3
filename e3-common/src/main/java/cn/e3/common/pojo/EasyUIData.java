package cn.e3.common.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYuFan on 2018/4/6.
 */
public class EasyUIData implements Serializable {

    private long total;
    private List rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
