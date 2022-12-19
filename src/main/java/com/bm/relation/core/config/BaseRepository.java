package com.bm.relation.core.config;


import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
/**
 * .
 *
 * @author : zyg
 * @since : 2022/07/20
 **/

public class BaseRepository<T, ID> extends SimpleMongoRepository<T, ID> implements IBaseRepository<T, ID> {

    protected final MongoOperations mongoOperations;
    protected final MongoEntityInformation<T, ID> entityInformation;

    public BaseRepository(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
        super(metadata, mongoOperations);
        this.mongoOperations = mongoOperations;
        this.entityInformation = metadata;
    }

    @Override
    public T find(ID id) {
        return findById(id).orElse(null);
    }

    @Override
    public T findOne(Criteria criteria) {

        Query query = new Query(criteria);
        return this.mongoOperations.findOne(query, getEntityClass(), getTableName());
    }

    @Override
    public List<ID> findIdsByQuery(Query query) {

        return this.mongoOperations.findDistinct(query, this.getIdColumn(), getTableName(), getIdClass());
    }

    @Override
    public List<T> listAll() {
        return this.mongoOperations.findAll(getEntityClass(), getTableName());
    }

    @Override
    public List<T> listByIds(Collection<ID> ids) {

        Iterable<T> iterable =  findAllById(ids);
        if(iterable instanceof List){
            return (List<T>) iterable;
        }
        List<T> list = new LinkedList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Override
    public List<T> listByField(String fieldName, Collection values) {

        Criteria criteria = new Criteria();
        criteria.and(fieldName).in(values);
        Query query = new Query(criteria);
        List<T> list = this.find(query);
        return list;
    }

    @Override
    public List<T> listByField(String fieldName, Object value) {

        Criteria criteria = new Criteria();
        criteria.and(fieldName).is(value);
        Query query = new Query(criteria);
        List<T> list = this.find(query);
        return list;
    }

    @Override
    public List<T> listByField(String fieldName1, Object value1, String fieldName2, Collection value2) {

        Criteria criteria = new Criteria();
        criteria.and(fieldName1).is(value1).and(fieldName2).in(value2);
        Query query = new Query(criteria);
        List<T> list = this.find(query);
        return list;
    }

    @Override
    public List<T> listByField(String fieldName1, Object value1, String fieldName2, Object value2) {

        Criteria criteria = new Criteria();
        criteria.and(fieldName1).is(value1).and(fieldName2).is(value2);
        Query query = new Query(criteria);
        List<T> list = this.find(query);
        return list;
    }


    @Override
    public String getTableName(){
        return entityInformation.getCollectionName();
    }

    @Override
    public ID getIdValue(T entity){
        return entityInformation.getId(entity);
    }

    @Override
    public String getIdAttribute(){
        return entityInformation.getIdAttribute();
    }

    @Override
    public String getIdColumn(){
        return "_id";
    }


    @Override
    public void deleteAll(Collection<ID> ids) {
        Criteria criteria = Criteria.where(this.getIdColumn()).in(ids);
        Query query = new Query(criteria);
        mongoOperations.remove(query, getTableName());
    }


    @Override
    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }

    @Override
    public MongoEntityInformation<T, ID> getEntityInformation() {
        return entityInformation;
    }

    @Override
    public Class<T> getEntityClass() {
        return entityInformation.getJavaType();
    }

    @Override
    public Class<ID> getIdClass() {
        return entityInformation.getIdType();
    }

    @Override
    public BaseRepository<T, ID> _baseThis() {
        return this;
    }

    @Override
    public List<T> find(Query query) {
        return this.mongoOperations.find(query, getEntityClass(), getTableName());
    }

    @Override
    public long count(Query query) {
        return this.mongoOperations.count(query, getTableName());
    }

    @Override
    public <F> List<F> findDistinct(Query query, String field, Class<F> clazz) {
        return this.mongoOperations.findDistinct(query, field, getTableName(), clazz);
    }

    @Override
    public <F> AggregationResults<F> aggregate(Aggregation aggregation, Class<F> clazz) {
        return  this.mongoOperations.aggregate(aggregation, getTableName(), clazz);
    }

}