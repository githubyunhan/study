package cn.itcast.bootstart.utils;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class DozerUtils {//该工具类实现List转List
    static DozerBeanMapper dozerBeanMapper=new DozerBeanMapper();

    /*@Autowired
    protected Mapper dozerMapper;通常这样注入*/


    public static <T> List<T> mapList(Collection sourceList,Class<T> destinationClass) {
        List destinationList = Lists.newArrayList();
        for (Iterator i$=sourceList.iterator();i$.hasNext();){
            Object sourceObject = i$.next();
            Object destinationObject = dozerBeanMapper.map(sourceObject, destinationClass);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }
}
