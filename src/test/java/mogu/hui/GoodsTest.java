package mogu.hui;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Reader;

/**
 * Created by yihui on 15/7/9.
 */
public class GoodsTest {
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

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
