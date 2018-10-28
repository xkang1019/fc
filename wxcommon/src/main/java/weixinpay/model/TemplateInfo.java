package weixinpay.model;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

public class TemplateInfo {

    private String touser;
    private String template_id;
    private String page;
    private String topcolor;
    private String form_id;
    private String url;
    private TemplateItem data;
    private Miniprogram miniprogram;

    public static TemplateInfo New() {
        return new TemplateInfo();
    }

    private TemplateInfo() {
        this.miniprogram = new Miniprogram();
        this.data = new TemplateItem();
    }

    public String getUrl() {
        return url;
    }

    public TemplateInfo setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getTouser() {
        return touser;
    }

    public String getForm_id() {
        return form_id;
    }

    public TemplateInfo setForm_id(String form_id) {
        this.form_id = form_id;
        return this;
    }

    public void setData(TemplateItem data) {
        this.data = data;
    }

    public TemplateInfo setTouser(String touser) {
        this.touser = touser;
        return this;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public TemplateInfo setTemplate_id(String template_id) {
        this.template_id = template_id;
        return this;
    }

    public String getPage() {
        return page;
    }

    public TemplateInfo setPage(String page) {
        this.page = page;
        return this;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public TemplateInfo setTopcolor(String topcolor) {
        this.topcolor = topcolor;
        return this;
    }

    public TemplateItem getData() {
        return data;
    }

    public TemplateInfo add(String key, String value, String color){
        data.put(key, new Item(value, color));
        return this;
    }


    public TemplateInfo setMini(String appid, String pagepath){
        miniprogram.put(appid, pagepath);
        return this;
    }

    /**
     * 直接转化成jsonString
     * @return {String}
     */
    public String build() {
        return JSONObject.toJSONString(this);
    }

    public class TemplateItem extends HashMap<String, Item> {

        private static final long serialVersionUID = -3728490424738325020L;

        public TemplateItem() {}

        public TemplateItem(String key, Item item) {
            this.put(key, item);
        }
    }

    public  class  Miniprogram extends  HashMap<String,String>{

        public Miniprogram() {}

        public Miniprogram(String appid, String pagepath) {
            this.put(appid, pagepath);
        }

    }

    public class Item {
        private Object value;
        private String color;

        public Object getValue() {
            return value;
        }
        public void setValue(Object value) {
            this.value = value;
        }
        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }

        public Item(Object value, String color) {
            this.value = value;
            this.color = color;
        }
    }
}

