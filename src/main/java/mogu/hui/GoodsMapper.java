package mogu.hui;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yihui on 15/7/9.
 *
 * 商品访问接口
 */
@Repository
@Transactional
public interface GoodsMapper {
    public Goods getGoodsById(int id);

    public Goods getGoodsByName(String name);

    public String getNameById(int id);

    public List<Goods> dynamicForeachTest(List<Integer> ids);
}
