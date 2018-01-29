package cn.bjd.platform.elastic.provider.serviceimpl;

import cn.bjd.platform.elastic.provider.mapper.IndustryMapper;
import cn.bjd.platform.elastic.api.entity.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018/1/13.
 */
@Service
public class IndustryService {

    @Autowired
    private IndustryMapper industryMapper;

    private Map<Integer,Industry> idMap = new HashMap<>();
    private Map<String,Industry> codeMap = new HashMap<>();

    @PostConstruct
    public void before(){
        List<Industry> industryList = industryMapper.findAll();
        for(Industry industry : industryList){
            idMap.put(industry.getId(),industry);
            codeMap.put(industry.getiPath(),industry);
        }
    }

    public String getCategory(String code){
        Industry industry = codeMap.get(code);
        if(industry == null){
            return  code;
        }

        return industry.getiName();
    }

    public String getSmallCategory(Integer id){
        Industry industry = idMap.get(id);
        if(industry == null || industry.getiLevel() == null || industry.getiLevel() < 4){
            return null;
        }

        return industry.getiName();
    }

    public String getMiddleCategory(Integer id){
        Industry industry = idMap.get(id);
        if(industry == null || industry.getiLevel() == null || industry.getiLevel() < 3){
            return null;
        }

        if(industry.getiLevel() == 3){
           return industry.getiName();
        }
        else{
            industry = codeMap.get(industry.getTypeXxl() + "/" + industry.getTypeXl() + "/" + industry.getTypeMl());
            if(industry == null || industry.getiLevel() == null){
                return null;
            }
            else{
                return industry.getiName();
            }
        }
    }

    public String getBigCategory(Integer id){
        Industry industry = idMap.get(id);
        if(industry == null || industry.getiLevel() == null || industry.getiLevel() < 2){
            return null;
        }

        if(industry.getiLevel() == 2){
            return industry.getiName();
        }
        else{
            industry = codeMap.get(industry.getTypeXxl() + "/" + industry.getTypeXl());
            if(industry == null || industry.getiLevel() == null){
                return null;
            }
            else{
                return industry.getiName();
            }
        }
    }
}
