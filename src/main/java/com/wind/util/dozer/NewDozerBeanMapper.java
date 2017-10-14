package com.wind.util.dozer;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用于bean对象之间转换
 * <p>
 * 例如：User实例对象转成UserDTO对象
 * </p>
 *
 * @author wind
 * @since 01.06.2016
 */
public class NewDozerBeanMapper extends DozerBeanMapper {

    /**
     * 实现List集合的转换
     *
     * @param list
     * @param destinationClass
     * @param <T>
     * @return
     * @throws MappingException
     */
    public <T> List<T> mapList(List list, Class<T> destinationClass) throws MappingException {
        List<T> tList = new ArrayList<>();
        for (Object o : list) {
            tList.add(this.map(o, destinationClass));
        }
        return tList;
    }

    /**
     * 单个对象的转换
     *
     * @param object
     * @param destinationClass
     * @param <T>
     * @return
     * @throws MappingException
     */
    public <T> T mapObject(Object object, Class<T> destinationClass) throws MappingException {
        return this.map(object, destinationClass);
    }

    public void setMappingfile(String mappingFile) {
        this.setMappingFiles(Arrays.asList(mappingFile));
    }

}