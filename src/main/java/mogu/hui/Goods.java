package mogu.hui;


import java.sql.Timestamp;

/**
 * Created by yihui on 15/7/9.
 */
public class Goods {
    private int id;
    private int categoryId;
    private String name;
    private float price;
    private String description;
    private int acount;
    private Timestamp updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAcount() {
        return acount;
    }

    public void setAcount(int acount) {
        this.acount = acount;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString(){
        return "id: " + id + " categoryId: " + categoryId + " name: " + name
                + " price: " + price + " description: " + description
                + " acount: " + acount + " updateTime: " + updateTime;
    }
}
