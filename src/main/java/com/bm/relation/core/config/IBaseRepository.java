package com.bm.relation.core.config;

/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/20
 **/
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.repository.NoRepositoryBean;
import java.util.Collection;
import java.util.List;

@NoRepositoryBean
public interface IBaseRepository<T, ID> extends MongoRepository<T, ID> {

    //根据id查询对象
    T find(ID id);

    T findOne(Criteria criteria);

    //查询对象id
    List<ID> findIdsByQuery(Query query);

    //根据字段名查询对象列表
    List<T> listAll();

    //根据id列表查询对象列表
    List<T> listByIds(Collection<ID> ids);

    //根据字段名查询对象列表
    List<T> listByField(String fieldName, Collection values);

    //根据字段名查询对象列表
    List<T> listByField(String fieldName, Object value);

    //根据字段名查询对象列表
    List<T> listByField(String fieldName1, Object value1, String fieldName2, Collection value2);

    //根据字段名查询对象列表
    List<T> listByField(String fieldName1, Object value1, String fieldName2, Object value2);

    //表名
    String getTableName();

    //id值
    ID getIdValue(T entity);

    //id属性名
    String getIdAttribute();

    //id列名
    String getIdColumn();

    //删除
    void deleteAll(Collection<ID> ids);

    //mongo操作对象
    MongoOperations getMongoOperations();

    //实体定义
    MongoEntityInformation<T, ID> getEntityInformation();

    //实体类
    Class<T> getEntityClass();

    //id类
    Class<ID> getIdClass();

    //mongo转换对象
    default MongoConverter getMongoConverter(){
        return getMongoOperations().getConverter();
    }

    //实例类base对象
    BaseRepository<T, ID> _baseThis();

    //查询数据
    List<T> find(Query query);

    //计算数量
    long count(Query query);

    //查询去重字段
    <F> List<F> findDistinct(Query query, String field, Class<F> clazz);

    //聚合
    <F> AggregationResults<F> aggregate(Aggregation aggregation, Class<F> clazz);
}
