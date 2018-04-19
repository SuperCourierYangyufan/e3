package cn.e3.item.pojo;

import cn.e3.pojo.TbItem;

/**
 * Created by YangYuFan on 2018/4/18.
 */
public class Item extends TbItem {

    public Item(TbItem tbItem){
        this.setSellPoint(tbItem.getSellPoint());
        this.setId(tbItem.getId());
        this.setTitle(tbItem.getTitle());
        this.setPrice(tbItem.getPrice());
        this.setNum(tbItem.getNum());
        this.setBarcode(tbItem.getBarcode());
        this.setImage(tbItem.getImage());
        this.setCid(tbItem.getCid());
        this.setStatus(tbItem.getStatus());
        this.setCreated(tbItem.getCreated());
        this.setUpdated(tbItem.getUpdated());
    }

    public Item() {
    }

    public String[] getImages(){
        String image2 = this.getImage();
        if(image2!=null&&"".equals(image2)){
            String[] str = image2.split(",");
            return str;
        }
        return null;
    }
}
