package com.ruoyi.forest.ov.do2vo;



import com.ruoyi.forest.domian.SlDiaryDO;
import com.ruoyi.forest.domian.SysCardsDO;
import com.ruoyi.forest.dto.do2dto.DiaryTransform;
import com.ruoyi.forest.ov.CardsInfoVO;
import com.ruoyi.forest.ov.CardsListVO;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@org.mapstruct.Mapper(uses = DiaryTransform.class)
public interface DiaryConvertVO {

    DiaryConvertVO MAPPER = Mappers.getMapper(DiaryConvertVO.class);

    @Mappings({
            @Mapping(source = "creationtime",target = "tilte",dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "weather",target = "weather"),
            @Mapping(source = "haedimg",target = "headImg"),
            @Mapping(source = "contentimg",target = "imgList"),
            @Mapping(source = "content",target = "event"),
            @Mapping(source = "content",target = "phrase"),
            @Mapping(source = "type",target = "type")
    })
    public CardsInfoVO doToVO(SlDiaryDO slDiaryDO);


    public List<CardsInfoVO> doToVOList(List<SlDiaryDO> slDiaryDO);


    @Mappings({
            @Mapping(source = "cardUrl",target = "img"),
            @Mapping(source = "cardContent",target = "text"),
            @Mapping(source = "creationTime",target = "date",dateFormat = "yyyy-MM-dd"),
    })
    public CardsListVO sysCardDoToVO2(SysCardsDO sysCardsDO);


    public List<CardsListVO> sysCardDoToVOList(List<SysCardsDO> sysCardsDOList);

}
