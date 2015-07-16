package mogu.hui;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yihui on 15/7/9.
 */
public class GoodsTest {
    @Test
    public void dynamicForearchTest(){
        SqlSessionFactory ssf;
        Reader reader;
        try{
            reader = Resources.getResourceAsReader("Configure.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = ssf.openSession();
            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(1);
            List<Goods> goods = mapper.dynamicForeachTest(ids);
            for(Goods good: goods){
                System.out.println(good.toString());
            }
            session.close();
        }catch(Exception e){
            System.out.println("open session error!");
        }
    }

    /*
     * 直接运行本程序，进行mybatis的测试
     */
    public static void main(String[] args){
        SqlSessionFactory ssf;
        Reader reader;
        try{
            reader = Resources.getResourceAsReader("Configure.xml");
            System.out.println("1");
            ssf = new SqlSessionFactoryBuilder().build(reader);
            System.out.println("2");
            SqlSession session = ssf.openSession();
            System.out.println("3");
            Goods goods = (Goods)session.selectOne("getGoodsById", 2);
            System.out.println("4");
            System.out.println(goods.getName());

            GoodsMapper mapper = session.getMapper(GoodsMapper.class);
            Goods g = mapper.getGoodsById(1);
            System.out.println(g.toString());
            session.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
        }
    }

}
