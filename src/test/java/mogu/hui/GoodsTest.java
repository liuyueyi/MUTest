package mogu.hui;

import junit.framework.Assert;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yihui on 15/7/9.
 */
public class GoodsTest {
    SqlSession session;
    GoodsMapper mapper;

    @Before
    public void setUp(){
        SqlSessionFactory ssf;
        Reader reader;
        try{
            reader = Resources.getResourceAsReader("Configure.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
            session = ssf.openSession();
            mapper = session.getMapper(GoodsMapper.class);
        }catch(Exception e){
            System.out.println("error");
        }
    }

    @After
    public void over(){
           if(null != session)
               session.close();
    }

    @Test
    public void dynamicForearchTest() {
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            List<Goods> goods = mapper.dynamicForeachTest(ids);
            for (Goods good : goods) {
                System.out.println(good.toString());
            }
    }

    @Test
    public void addGoodTest(){
        // 无法自动增加id的值，why？
        Goods good = new Goods();
        good.setCategoryId(3);
        good.setName("mi5");
        good.setPrice(2399);
        good.setDescription("Android 5.0");
        int i = mapper.addGood(good);
        session.commit();
        Assert.assertTrue(i == 1);
        System.out.println("the new id is " + good.getId());
    }

    @Test
    public void deleteGoodByIdTest(){
        int rt = mapper.deleteGoodById(0);
        session.commit();
        Assert.assertTrue(rt == 1);
    }

    @Test
    public void deleteGoodByNameTest(){
        int rt = mapper.deleteGoodByName("mi5");
        session.commit();
        Assert.assertTrue(rt == 1);
    }

    /*
     * 直接运行本程序，进行mybatis的测试
     */
    public static void main(String[] args) {
        SqlSessionFactory ssf;
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("Configure.xml");
            System.out.println("1");
            ssf = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("2");
            SqlSession session = ssf.openSession();
            System.out.println("3");
            Goods goods = (Goods) session.selectOne("getGoodsById", 2);
            System.out.println("4");
            System.out.println(goods.getName());

            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods g = mapper.getGoodsById(1);
            System.out.println(g.toString());
            session.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        }
    }

}
