package com.ruoyi.forest.dto.do2dto;


import com.ruoyi.forest.domian.Diary;
import com.ruoyi.forest.domian.SlDiaryDO;
import com.ruoyi.forest.dto.SLDiaryDTO;

import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper(uses = DiaryTransform.class)
public interface DiaryConvert {

    DiaryConvert MAPPER = Mappers.getMapper(DiaryConvert.class);

    @Mappings({
            @Mapping(source = "creationTime",target = "creationtime",dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "contentImg",target = "contentimg")
    })
    SLDiaryDTO doToDTO(Diary diary);


    @Mappings({
            @Mapping(source = "creationTime",target = "creationtime",dateFormat = "yyyy-MM-dd"),
            @Mapping(source = "contentImg",target = "contentimg"),
            @Mapping(source = "cardId",target = "cardid"),
            @Mapping(source = "cardContent",target = "cardcontent")
    })
    SlDiaryDO doToDO(Diary diary);
}
